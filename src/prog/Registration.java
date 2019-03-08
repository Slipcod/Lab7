package prog;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Registration {

    private String username, password;
    public Registration(){
      reg();
    }


    private void reg(){
        Scanner  scanner = new Scanner(System.in);
        System.out.print("\nВведите логин: ");
        username = inputUsername();
        System.out.print("\nВведите пароль: ");
        password = scanner.next();
        writeDataProperties();
        createUserFile();

        System.out.print("\nРегистрация прошла успешно.\n\n");

    }

    private void createUserFile(){
        File file = new File("res/", username + "data.txt");
        Messages messages = new Messages(username, password, false);
        messages.generateRandomMessagess();
    }

    private void writeDataProperties() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("res/users.properties")), StandardCharsets.UTF_8);
            content += "\n" + username + "=" + password;
            Files.write(Paths.get("res/users.properties"), content.getBytes(StandardCharsets.UTF_8));
        }catch(IOException e){
            System.exit(1488);
        }
    }


    //Логин
    private String inputUsername(){
        String result = "11";
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        try{
        do{
            result = scanner.next();
            username = result;
            Path path = Paths.get("res/users.txt");
            String string = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

            if(!(new String (Files.readAllBytes(path)).contains(username))){
                string += "\n" + username;
                Files.write(path,string.getBytes(StandardCharsets.UTF_8));
                return result;
            }
            System.out.print("\n Такой пользователь уже существует. Введите другой логин: ");
        }while(flag);
        }catch (IOException e) {
            System.exit(112);
        }
        return result;
    }
}
