package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;


public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод добавляет данные в Map.
     * Если в строке есть символ "=", то ключем будет часть строки до знака, а значением, часть строки после знака.
     */
    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains("##")) {
                    line = reader.readLine();
                } else {
                    int number = line.indexOf("=");
                    if (number > 0) {
                        values.put(line.substring(0, number), line.substring(number + 1));
                    }
                    line = reader.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод поиска значения по ключу.
     *
     * @param key - ключ
     * @return если ключ есть в Map, то возвращает значение, если нет, возвращает null.
     */
    public String value(String key) {
        String result = null;
        for (Map.Entry<String, String> x : values.entrySet()) {
            if (x.getKey().equals(key)) {
                result = x.getValue();
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config c = new Config("app.properties");
        c.load();
        System.out.println(c.value("hibernate.dialect"));
    }
}