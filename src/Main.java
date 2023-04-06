import java.io.*;
import java.util.HashMap;
import java.util.Map;
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

        Map<Character, Integer> count = new HashMap<Character, Integer>();
        while (fr.ready()){
            String buf = fr.readLine();
            for (int j = 0; j < buf.length(); j++)
            {
                if (Character.isLetter(buf.charAt(j)))
                {
                    Integer freq = (Integer) count.get(buf.charAt(j));

                    count.put(buf.charAt(j), (freq == null) ? 1 : freq + 1);
                }
            }


        }
        fr.close();

        System.out.print("Введите имя для записи (если файла с введенным именем нет, то он создастся автоматически): ");
        fileName = in.next();
        FileWriter fw = new FileWriter(fileName);

        for (char i='A'; i<='Z'; i++){
            int res;
            if (count.get(i) == null) res = 0;
            else res = count.get(i);
            fw.write(i + " - " + res + "\n");
        }
        for (char i='a'; i<='z'; i++){
            int res;
            if (count.get(i) == null) res = 0;
            else res = count.get(i);
            fw.write(i + " - " + res + "\n");
        }

//        fw.write("Заглавных букв: " + upperLet + "\nСтрочных букв: " + lowerLet);
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