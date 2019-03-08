package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Rand {
    FileWorker fileWorker = new FileWorker();



    //возвращает текст в рандомном порядке
    public String getRandText(){
        try {
            Random random = new Random(System.currentTimeMillis());
            String content = Files.readAllLines(Paths.get("res/text4rand.txt")).get(random.nextInt(20));
            return content;
        }catch (IOException e){
            System.out.print("\nIOExeption в RandText");
        }

        return null;
    }


    //случайно выбирает пользователей для генерации
    public String getRandUser(){
        try {
            Random random = new Random(System.currentTimeMillis());
            String content = Files.readAllLines(Paths.get("res/users.txt")).get(random.nextInt(fileWorker.getCount()));
            return content;
        }catch (IOException e){
            System.out.print("\nIOExeption в getRandUser ");
        }

        return null;
    }



}
