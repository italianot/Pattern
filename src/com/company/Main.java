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
        int fileCount = 0;
        int folderCount = 0;
        System.out.println("Выберите тип создаваемого элемента: " +
                "\n1. Текстовый файл " +
                "\n2. Файл-изображение " +
                "\n3. Папка " +
                "\n4. Конец ");

        Folder lastFolder = new Folder();

        while (in.hasNext()) {
            a = in.nextInt();
            switch(a) {
                case 1:
                    b = in.nextInt();
                    File File = new File();
                    lastFolder.addComponent(File);
                    System.out.println("Создан текстовый файл, размер = " + b);

                    fileCount++;
                    memory = memory + b;

                    break;
                case 2:
                    b = in.nextInt();
                    Image Image = new Image();
                    lastFolder.addComponent(Image);
                    System.out.println("Создан файл-изображение, размер = " + b);

                    fileCount++;
                    memory = memory + b;
                    break;
                case 3:
                    Folder Folder = new Folder();
                    lastFolder.addComponent(Folder);
                    lastFolder = Folder;

                    folderCount++;
                    System.out.println("Создана папка");
                    break;
                case 4:
                    System.out.println("Объем памяти, занимаемый файловым " +
                            "хранилищем составил " + memory + " мегабайт. " +
                            "Хранится: " + fileCount + " файла и " + folderCount + " папки. ");
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




