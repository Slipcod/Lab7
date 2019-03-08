package prog;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Registration {

    private String username, password;



    public void reg(TextField textLog, TextField textPass, Label info){
        Scanner  scanner = new Scanner(System.in);

        username = textLog.getText();

        password = textPass.getText();
        writeDataProperties();
        createUserFile();

        info.setText("\nРегистрация прошла успешно. Подождите.\n\n");

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
    public boolean inputUsername(String user, Label info){
        String result;

        boolean flag = true;
        try{
        do{
            result = user;
            this.username = result;
            Path path = Paths.get("res/users.txt");
            String string = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

            if(!(new String (Files.readAllBytes(path)).contains(this.username))){
                string += "\n" + this.username;
                Files.write(path,string.getBytes(StandardCharsets.UTF_8));
                System.out.println("\nOK");
                return true;
            }
            info.setText("\n Такой пользователь уже существует. ");
        }while(flag);
        }catch (IOException e) {
            System.exit(112);
        }
        return false;
    }
}
