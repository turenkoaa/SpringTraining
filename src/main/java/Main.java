import model.TalkingRobot;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Quoter shakeSpearById = (Quoter) context.getBean("shakeSpear");
//        Quoter shakeSpearByName = (Quoter) context.getBean("shakeSpearName");
//        Quoter shakeSpearByClass = context.getBean(Shakespear.class);
//        Quoter terminatorByEqualIdAndName = (Quoter) context.getBean("terminator");
////        NoUniqueBeanDefinitionException: No qualifying bean of type 'Quoter' available: expected single matching bean but found 2: shakeSpear,terminator
////        Quoter shakeSpearByInterface = context.getBean(Quoter.class);
//        Map<String, Quoter> quoterMap = context.getBeansOfType(Quoter.class);

        context.getBean(TalkingRobot.class);
        context.close();
    }
}
