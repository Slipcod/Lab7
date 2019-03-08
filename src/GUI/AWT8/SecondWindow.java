package GUI.AWT8;

import java.awt.*;

public class SecondWindow extends Frame  {
    Label lblComment=new Label ( "Текстовое поле:" );
    TextArea txtComment=new TextArea();
    Button btnMesShow=new Button( "Посмотреть сообщения" );
    Button btnMesRand=new Button( "Новое сообщение(рандом" );
    Button btnWrite=new Button( "Написать сообщение" );
    Button btnSave=new Button( "Сохранить сообщения в файл" );
    Button btnExit=new Button( "Закрыть программу" );

    public SecondWindow() {

        BorderLayout borderLayout= new BorderLayout();

        setLayout(new GridLayout(6,1));



        add(txtComment,borderLayout.CENTER);



       add(btnMesShow);
       add(btnMesRand);
       add(btnWrite);
       add(btnSave);
       add(btnExit);



    }

    public static void main(String args []) {
        SecondWindow secondWindow=new SecondWindow();
        secondWindow.setSize(500,400) ;
        secondWindow.show();
    }

}
