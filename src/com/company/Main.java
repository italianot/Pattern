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


        switch(a) {
            case 1:
                b = in.nextInt();
                file++;
                memory = memory + b;
                System.out.println("Создан текстовый файл, размер = " + b);
                break;
            case 2:
                b = in.nextInt();
                file++;
                memory = memory + b;
                System.out.println("Создан файл-изображение, размер = " + b);
                break;
            case 3:
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
    public void keep(){
        System.out.println("hello folder");
    }
}



class Composite implements Object{
    private List<Object> components = new ArrayList<>();

    public void addComponent(Object component){
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




