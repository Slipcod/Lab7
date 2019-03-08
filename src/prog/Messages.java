package prog;

import utils.Rand;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Messages {
    private String username, pass;



    private Stack<String> stack = new Stack<String>();

    private Iterator iterator;
    private Rand rand = new Rand();


    public Messages(String username, String pass, boolean flag) {
        this.username = username;
        this.pass = pass;


        if(flag)
        addToStack();
    }

    //сохраняет данные из стека в файл
    public void saveToFile() {
        iterator = stack.iterator();
        String content = "";
        Path path = Paths.get("res/" + username + "data.txt");
        Charset charset = StandardCharsets.UTF_8;

        while (iterator.hasNext()) {
            content += iterator.next() + "\n";
        }
        try {
            Files.write(path, content.getBytes(charset));
            System.out.print("\nДанные успешно записаны.");
        }catch (IOException e){
            System.out.print("\nIOException при сейве");
            System.exit(0);
        }
    }

    //добавляет данные из файла в стек
    private void addToStack() {
        try {
            File file = new File("res/" + username + "data.txt");
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                stack.add(scanner.nextLine());
            }

        }catch (FileNotFoundException e){
            System.out.print("\nФайл не найден в addToStack");
            System.exit(1337);
        }
    }

    //создает новое сообщение и добавляет его в стек
    public void newMessage() {
        String add = getDate() + " - " + rand.getRandUser() + " - " + rand.getRandText();
        stack.add(add);


    }

    //вывод того что есть в стеке
    public void readStack(){
        while(!stack.empty()){
            System.out.print("\n" + stack.pop());
        }
    }




    //генерирует сообщения и записывает в файл
    public void generateRandomMessagess(){
        try{
            int countt = 0;
            Path path = Paths.get("res/" + username + "data.txt");
            Charset charset = StandardCharsets.UTF_8;
            String content = getDate() + " - " + rand.getRandUser() + " - " + rand.getRandText();
            for (int i = 1;i<7;i++){
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
                content += "\n" + getDate() + " - " + rand.getRandUser() + " - " + rand.getRandText();
            }
            Files.write(path, content.getBytes(charset));
        }catch(IOException e){
            System.out.print("\nIOException в generateRandomMessagess");
            System.exit(5);
        } catch (InterruptedException e) {
            System.out.print("\nInteruptedExeption в generateRandomMessagess");
            e.printStackTrace();
        }
    }

    //Отправка сообщений
    public void writeMessagess(){
            Scanner scanner = new Scanner(System.in);


                System.out.print("\nВведите кому хотите отправить: ");
                String user=scanner.next();

                System.out.print("\nВведите желаемое сообщение: ");
                String text=scanner.next();
            String content = "\n"+ getDate() + " - " + username + " - " + text;

        Path path = Paths.get("res/" + user + "data.txt");
        try {
            FileWriter writer = new FileWriter(String.valueOf(path), true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(content);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println("\nIOException в writeMessagess");
        }
    }

    //возвращает текущую дату
    private String getDate(){
        return new Date().toString();
    }

}
