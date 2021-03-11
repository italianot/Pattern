package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int a;
        int b;
        int memory = 0;
        int file = 0;
        int folder = 0;
        System.out.println("Выберите тип создаваемого элемента: " +
                "\n1. Текстовый файл " +
                "\n2. Файл-изображение " +
                "\n3. Папка " +
                "\n4. Конец ");

        while (in.hasNext()) {

            a = in.nextInt();
            int c = a;
            switch(a) {
                case 1:
                    b = in.nextInt();
                    Object File = new File();
                    //Folder.addComponent(File); это работает, но нужно
                    //чтобы файл добавлялся при создании пользователем папки
                    //Как получить или запомнить что была создана папка?
                        if (c==3){
                            Folder.addComponent(File);
                            System.out.println("В папке создан текстовый файл, размер = " + b);
                        }else{
                            System.out.println("Создан текстовый файл, размер = " + b);
                        }
                    file++;
                    memory = memory + b;
                    //System.out.println("Создан текстовый файл, размер = " + b);
                    break;
                case 2:
                    b = in.nextInt();
                    Object Image = new Image();
                    file++;
                    memory = memory + b;
                    System.out.println("Создан файл-изображение, размер = " + b);
                    break;
                case 3:
                    Object Folder = new Folder();
                    folder++;
                    System.out.println("Создана папка");
                    break;
                case 4:
                    System.out.println("Объем памяти, занимаемый файловым " +
                            "хранилищем составил " + memory + " мегабайт. " +
                            "Хранится: " + file + " файла и " + folder + " папки. ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверное значение...");
            }
        }

    }
}

interface Object{
    void keep();
}

class File implements Object{
    public void keep(){
        System.out.println("hello file");
    }
}

class Image implements Object{
    public void keep(){
        System.out.println("hello image");
    }
}

class Folder implements Object{

    private static List<Object> components = new ArrayList<>();

    public static void addComponent(Object component){
        components.add(component);
    }

    public void removeComponent(Object component){
        components.remove(component);
    }

    public void keep(){
        for(Object component: components){
            component.keep();
        }
    }
}




