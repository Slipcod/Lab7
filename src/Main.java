import prog.Messages;
import prog.Registration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        int action;



        while(true){

            System.out.print("Добро пожаловать.\n1.Войти в систему\n2.Зарегистрироваться в системе\n3.Выйти из системы\nВведите число:");
            Scanner scanner = new Scanner(System.in);
            action = input();

            switch(action){
                case 1: signIn();
                    break;
                case 2: registration();
                    break;
                case 3:
                    System.exit(1);
            }
        }

    }

    private static int input() {
        Scanner scanner;
        int action;
        do {
            scanner = new Scanner(System.in);
            action = scanner.nextInt();
            if (action != 1 && action != 2 && action != 3)
                System.out.print("\nОшибка. Повторите ввод:");
        } while (action != 1 && action != 2 && action != 3);
        return action;
    }

    private static void registration() {
        Registration registration = new Registration();

    }

    private static void signIn() {
        while (true){


        System.out.print("\nВведите имя пользователя: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.print("\nВведите пароль: ");
        String pass = scanner.next();
        if(!checkData(pass,username)){
            System.out.print("\nВы ввели неверные данные. Попробуйте снова.");

        }else {
            Messages messages = new Messages(username, pass, true);
            actionSignIn(messages);
        }

        }
    }

    private static void actionSignIn(Messages messages) {
        while (true) {
            System.out.print("\n1.Посмотреть сообщения\n2.Новое сообщение(рандом)\n3.Написать сообщение\n4.Сохранить сообщения в файл\n5.Закрыть программу");
            System.out.print("\nВведите действие: ");
            Scanner scanner = new Scanner(System.in);
            int action = 0;
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("\nОшибка ввода. Попробуйте снова.");

            }

            switch (action) {
                case 1:
                    messages.readStack();
                    break;
                case 2:
                    messages.newMessage();
                    break;
                case 3:
                    messages.writeMessagess();
                    break;
                case 4:
                    messages.saveToFile();
                    break;
                case 5:
                    System.exit(1);
                default:
                    System.out.print("Вы ввели неверные данные. Начните заново.");

            }

        }
    }

    //Проверяет данные
    private static boolean checkData(String pass, String username) {
         FileInputStream fis;
         Properties properties;
        try {
            fis = new FileInputStream("res/users.properties");
            properties = new Properties();
            properties.load(fis);
            if(pass.equals(properties.get(username)))
                return true;
            else return false;
        }catch(FileNotFoundException e){
            System.out.print("\nФайла не существует.");
            System.exit(0);
        }catch(IOException e){
            System.out.print("IOException в авторизации");
            System.exit(0);
        }
        return true;
    }


}

