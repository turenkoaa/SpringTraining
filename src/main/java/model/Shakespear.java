package model;

import lombok.Setter;

public class Shakespear implements Quoter {
    @Setter
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
