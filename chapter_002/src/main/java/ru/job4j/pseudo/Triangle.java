package ru.job4j.pseudo;

/**
 * @author Andrey Shulgin
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   0\n");
        pic.append("  000\n");
        pic.append(" 00000\n");
        pic.append("0000000");
        return pic.toString();
    }
}