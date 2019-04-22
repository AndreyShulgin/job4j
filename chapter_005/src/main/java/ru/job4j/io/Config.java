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

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            String line = reader.readLine();
            char[] array;
            while (line != null) {
                if (line.contains("##")) {
                    line = reader.readLine();
                } else {
                    array = line.toCharArray();
                    char[] key;
                    char[] value;
                    for (int index = 0; index != array.length; index++) {
                        if (array[index] == '=') {
                            key = new char[index + 1];
                            value = new char[array.length - index - 1];
                            System.arraycopy(array, 0, key, 0, index);
                            System.arraycopy(array, index + 1, value, 0, array.length - index - 1);
                            values.put(new String(key), new String(value));
                        }
                    }
                    line = reader.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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

/*    public static void main(String[] args) {
        //      System.out.println(new Config("app.properties"));
        Config c = new Config("app.properties");
        c.load();
        System.out.println(c.value("hibernate.dialect"));
    }*/
}