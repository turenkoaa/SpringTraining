package inject_seller;

import inject_seller.services.ServiceA;
import inject_seller.services.ServiceB;
import inject_seller.services.ServiceC;
import inject_seller.services.ServiceD;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean(ServiceA.class).getSeller().getName());
        System.out.println(context.getBean(ServiceB.class).getSeller().getName());
        System.out.println(context.getBean(ServiceC.class).getSeller().getName());
        System.out.println(context.getBean(ServiceD.class).getSeller().getName());
//        context.getBean(ServiceE.class);
    }
}
