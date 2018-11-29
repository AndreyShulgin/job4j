package ru.job4j.pseudo;

/**
 * @author Andrey Shulgin
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++").append(System.lineSeparator());
        pic.append("++++");
        return pic.toString();
    }
}