package GUI.AWT8;

import prog.Messages;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondWindow extends Frame implements ActionListener {
    Messages messages;

    TextArea txtOut =new TextArea();
    Button btnMesShow=new Button( "Посмотреть сообщения" );
    Button btnMesRand=new Button( "Новое сообщение(рандом)" );

    Button btnSave=new Button( "Сохранить сообщения в файл" );
    Button btnExit=new Button( "Закрыть программу" );

    public SecondWindow(String username, String pass) {

        BorderLayout borderLayout= new BorderLayout();

        setLayout(new GridLayout(5,1));



        add(txtOut,borderLayout.CENTER);



       add(btnMesShow);
       add(btnMesRand);

       add(btnSave);
       add(btnExit);
       messages = new Messages(username, pass, true);

       btnMesShow.addActionListener(this);
       btnMesRand.addActionListener(this);
       btnSave.addActionListener(this);
       btnExit.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnMesShow){
            messages.readStack(txtOut);
        }else if(e.getSource()==btnMesRand){
            messages.newMessage();
        }else if(e.getSource()==btnSave){
            messages.saveToFile();
        }else if(e.getSource()==btnExit){
            System.exit(0);
        }
    }
}
