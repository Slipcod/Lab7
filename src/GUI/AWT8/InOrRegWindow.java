package GUI.AWT8;
import prog.Messages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class InOrRegWindow extends Frame implements ActionListener {

    Label labLogIn;
    TextField textLogIn;
    Button    btnLogIn;

    public InOrRegWindow() {

        labLogIn= new Label("ХУЙ");
        add(labLogIn);
        textLogIn= new TextField(40);
        add(textLogIn);
        btnLogIn = new Button("Log In");
        add(btnLogIn);


        btnLogIn.addActionListener(this);


    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnLogIn){
            System.out.print("\nВведите имя пользователя: ");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.next();
            System.out.print("\nВведите пароль: ");
            String pass = scanner.next();

            if(!checkData(pass,username)){
                System.out.print("\nВы ввели неверные данные. Попробуйте снова.");

            }else {
                Messages messages = new Messages(username, pass, true);

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

