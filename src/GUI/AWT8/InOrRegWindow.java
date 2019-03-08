package GUI.AWT8;
import prog.Messages;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class InOrRegWindow extends Frame implements ActionListener {

    Label lLog;
    Label lPass;
    Label info;
    TextField textLog;
    TextField textPass;
    Button    btnLog;

    public InOrRegWindow() {

        initLog();


    }

    private void initLog(){
        info= new Label("Информация");
        lLog= new Label("Логин");
        lPass= new Label("Пароль");
        textLog= new TextField(10);
        textPass= new TextField(10);

        btnLog = new Button("Ок");


        add(lLog).setBounds(10,10,10,10);
        add(textLog);
        add(lPass);
        add(textPass);
        add(btnLog);
        add(info);

        setLayout(new GridLayout(4,2,50,50));
        setSize(600,300);
        setVisible(true);

        btnLog.addActionListener(this);
    }

    private void initReg(){
        info= new Label("Информация");
        lLog= new Label("Логин");
        lPass= new Label("Пароль");
        textLog= new TextField(10);
        textPass= new TextField(10);

        btnLog = new Button("Ок");


        add(lLog).setBounds(10,10,10,10);
        add(textLog);
        add(lPass);
        add(textPass);
        add(btnLog);
        add(info);

        setLayout(new GridLayout(4,2,50,50));
        setSize(600,300);
        setVisible(true);

        btnLog.addActionListener(this);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnLog){



            String username = textLog.getText();

            String pass = textPass.getText();

            if(username.trim().isEmpty()&pass.trim().isEmpty()){
                info.setText("\nВведите имя пользователя.\nВведите пароль. ");


            }else if(!checkData(pass,username)){
                info.setText("\nВы ввели неверные данные. Попробуйте снова.");
            } else {
                SecondWindow secondWindow= new SecondWindow();
                secondWindow.setSize(300,300) ;
                secondWindow.setVisible(true);   //видимость
                this.hide();

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

