package lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        int id;
        Scanner scanner = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("lesson2");
        Cart cart = context.getBean(Cart.class);

        while (true){
            String scanLine = scanner.nextLine();
            if(scanLine.equals("/q")){
                break;
            }

            switch (scanLine){
                case "/add":
                    id = scanner.nextInt();
                    cart.addById(id);
                    break;
                case "/delete":
                    id = scanner.nextInt();
                    cart.delete(id);
                    break;
                case "/print":
                    cart.print();
                    break;
            }

        }
    }

}
