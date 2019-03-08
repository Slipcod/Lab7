package GUI.AWT8;

import java.awt.*;

public class SecondWindow extends Frame  {
    Label lblComment=new Label ( "Comments :" );
    TextArea txtComment=new TextArea("ТестТест");
    Button btnBread=new Button( "Войти в систему" );
    Button btnButter=new Button( "Зарегистрироваться в системе" );
    Button btnJam=new Button( "Выйти из системы" );

    public SecondWindow(String title) {
        super(title);
        setLayout(new FlowLayout() ) ;
        lblComment.setBounds(60,30,120,30);
        txtComment.setBounds(80,60,130,30);
        btnBread.setBounds(100,90,120,30);
        btnButter.setBounds(120,120,120,30);
        btnJam.setBounds(130,150,120,30);
        add(lblComment);
        add(txtComment);
        add(btnBread);
        add(btnButter);
        add(btnJam);
    }

    public static void main(String args []) {
        SecondWindow secondWindow=new SecondWindow( "Главная страница" );
        secondWindow.setSize(300,300) ;
        secondWindow.show();
    }

}
