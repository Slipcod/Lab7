package utils;

import java.io.*;

public class FileWorker {

    private int count;
    private String userpath ;

    public FileWorker(){

       count=countOfStrInFiles();

    }




    //считает строчки в файле
    private int countOfStrInFiles(){
        userpath = "res/users.txt";
        try {
            File file = new File(userpath);
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
            count = 0;
            while (null != lineNumberReader.readLine()){
                count++;
            }
            return count;
        }catch (FileNotFoundException e){
            System.out.print("\nFileNotFound в countOfStrInFiles");
        }catch(IOException e){
            System.out.print("\nIOExeption в countOfStrInFiles");
        }
        return 0;
    }

    public int getCount() {
        return count;
    }


    /*
    //читает данные из файла
    //В итоге не пригодилось
    public void writeFile() {
        userpath = "res/" + username + "data.txt";
        try {
            File file = new File(userpath);
            Scanner scan= new Scanner(file);
            System.out.println();
            while (scan.hasNextLine()){
                System.out.print(scan.nextLine());
                System.out.println();
            }
        }catch(FileNotFoundException e){
            System.out.print("FileNotFoundException в writeFile");
        }
    }*/
}
