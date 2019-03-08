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
            setLayout(new FlowLayout() );

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
            MainWindow mWindow=new MainWindow( "The three little buttons!" );
            mWindow.setSize(300,300) ;
            mWindow.show();
        }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnIn){
            InOrRegWindow inOrReg= new InOrRegWindow();

            inOrReg.setSize(300,300) ;
            inOrReg.setVisible(true);   //видимость
            this.hide();

        }else if(e.getSource()==btnReg){

        }
        else if(e.getSource()==btnOut){

        }


    }



}