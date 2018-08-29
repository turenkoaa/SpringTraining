package inject_and_streams;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SellerCollection {
    private static SellerCollection ourInstance = new SellerCollection();

    public static SellerCollection getInstance() {
        return ourInstance;
    }

    private SellerCollection() {
    }

    private List<Seller> sortedSellers;

    public List<Seller> getAllSellers() {
        return Arrays.asList(
                Seller.builder()
                        .name("trade 16")
                        .trade(new Trade().setGood("good1").setPrice(100000))
                        .trade(new Trade().setGood("good2").setPrice(200000))
                        .trade(new Trade().setGood("good3").setPrice(300000))
                        .trade(new Trade().setGood("good4").setPrice(400000))
                        .trade(new Trade().setGood("good6").setPrice(600000))
                        .build(),
                Seller.builder()
                        .name("trade 14")
                        .trade(new Trade().setGood("good1").setPrice(100000))
                        .trade(new Trade().setGood("good2").setPrice(200000))
                        .trade(new Trade().setGood("good5").setPrice(500000))
                        .trade(new Trade().setGood("good6").setPrice(600000))
                        .build(),
                Seller.builder()
                        .name("trade 12")
                        .trade(new Trade().setGood("good3").setPrice(300000))
                        .trade(new Trade().setGood("good4").setPrice(400000))
                        .trade(new Trade().setGood("good5").setPrice(500000))
                        .build(),
                Seller.builder()
                        .name("trade 9")
                        .trade(new Trade().setGood("good1").setPrice(100000))
                        .trade(new Trade().setGood("good2").setPrice(200000))
                        .trade(new Trade().setGood("good6").setPrice(600000))
                        .build()
        );
    }

    public List<Seller> getAllSellerSortedByTrades() {
        if (sortedSellers == null) {
            sortedSellers = getAllSellers().stream()
                    .map(s -> new Pair<>(s, s.getTrades()
                            .stream()
                            .mapToInt(Trade::getPrice)
                            .sum()))
                    .sorted((p1, p2)->-Integer.compare(p1.getValue(), p2.getValue()))
                    .map(Pair::getKey)
                    .collect(Collectors.toList());
        }
        return sortedSellers;
    }
}
