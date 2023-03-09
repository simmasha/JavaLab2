import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int upperLet = 0;
        int lowerLet = 0;
        System.out.print("Введите имя для чтения: ");
        String fileName = in.next();
        BufferedReader fr;
        try{
            fr = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException e){
            System.out.println("ОШИБКА: Файл не существует!");
            return;
        }
        while (fr.ready()){
            String buf = fr.readLine();
            for (int i=0; i<buf.length(); i++){
                if (Character.isUpperCase(buf.charAt(i))) upperLet++;
                if (Character.isLowerCase(buf.charAt(i))) lowerLet++;
            }
        }
        fr.close();

        System.out.print("Введите имя для записи (если файла с введенным именем нет, то он создастся автоматически): ");
        fileName = in.next();
        FileWriter fw = new FileWriter(fileName);
        fw.write("Заглавных букв: " + upperLet + "\nСтрочных букв: " + lowerLet);
        System.out.println("Результат записан в файл " + fileName);
        fw.close();

    }
}

/*
    имя файла с консоли
    проверить существование
    если есть открыть на чтение
    посчитать буквы
    с консоли второй файл для записи
    создать этот файл если его нет
    записать результат в файл
 */