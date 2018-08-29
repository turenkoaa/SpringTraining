package inject_and_streams;

import inject_and_streams.services.ServiceA;
import inject_and_streams.services.ServiceB;
import inject_and_streams.services.ServiceC;
import inject_and_streams.services.ServiceD;
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
