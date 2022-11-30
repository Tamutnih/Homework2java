package aor.example;

// В файле содержится строка с исходными данными в такой
// форме:{"name":"Ivanov","country":"Russia","city":"Moscow","age":"null"}Требуется
// на её основе построить и вывести на экран новую строку,в форме SQL
// запроса:SELECT*FROM students WHERE name="Ivanov"AND country="Russia"AND
// city="Moscow";

// Для разбора строки используйте String.split.Сформируйте новую
// строку,используя StringBuilder.Значения null не включаются в запрос.

// package aor.example;

// public class task1 {
// private static String part;

// public static void main(String[] args) {

// String input = "name = Ivan, lastName = Ivanov, age = null";

// String[] parts = input.split(",");

// for (String part : parts)
// ;
// System.out.println(part.trim());

// }
// }

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {

        String s = parseJson("txt.json");
        String[] text;
        text = s.split(",");
        StringBuilder sqlText = new StringBuilder();
        sqlText.append("SELECT * FROM students WHERE ");
        for (int i = 0; i < text.length; i++) {
            text[i] = text[i].replaceFirst("\"", "");
            text[i] = text[i].replaceFirst("\"", "");
            if (!(text[i].contains("null"))) {
                text[i] = text[i].replace(":", " = ");
                sqlText.append(text[i]);
                if (i != 2) {
                    sqlText.append(" AND ");
                }
                System.out.println(text[i]);
            }
        }
        System.out.println(sqlText.toString());
    }

    private static String parseJson(String path) {

        try (FileReader fr = new FileReader(path);) {
            Scanner scan = new Scanner(fr);
            StringBuilder build = new StringBuilder();
            String s = "";
            while (scan.hasNextLine()) {
                build.append(scan.nextLine());
            }
            s = build.toString();
            fr.close();
            s = s.replace(" ", "");
            s = s.replace("{", "");
            s = s.replace("}", "");
            System.out.println(s + "\n");
            return s;
        } catch (FileNotFoundException ex2) {
            System.out.println(ex2.getMessage());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return "";
    }
}