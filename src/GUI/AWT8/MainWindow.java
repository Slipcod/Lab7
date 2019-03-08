package GUI.AWT8;

import prog.Registration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainWindow extends Frame implements ActionListener {
        Button btnIn ;
        Button btnReg ;
        Button btnOut ;

        public MainWindow(String title) {
            super(title);
            setLayout(new GridLayout(3,1));

            btnIn =new Button( "Войти в систему" );
             btnReg =new Button( "Зарегистрироваться в системе" );
             btnOut =new Button( "Выйти из системы" );

            add(btnIn);
            add(btnReg);
            add(btnOut);
            btnIn.addActionListener(this);
            btnReg.addActionListener(this);
            btnOut.addActionListener(this);

        }

        public static void main(String args []) {
            MainWindow mWindow=new MainWindow( "Main Window" );
            mWindow.setSize(300,300) ;
            mWindow.show();
        }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnIn){
            InOrRegWindow inOrReg= new InOrRegWindow(1);


            inOrReg.setVisible(true);   //видимость
            this.hide();

        }else if(e.getSource()==btnReg){
            InOrRegWindow inOrReg= new InOrRegWindow(2);

            inOrReg.setVisible(true);   //видимость
            this.hide();
        }
        else if(e.getSource()==btnOut){
            System.exit(0);
        }


    }



}