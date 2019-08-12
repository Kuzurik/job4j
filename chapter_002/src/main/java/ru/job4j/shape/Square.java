package ru.job4j.shape;

/**
 * Iimplementation interface Shape.
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */

public class Square implements Shape {
    
    /**
     * draw Square. 
     * @return Square to String.
     */
    
    @Override
    public String draw() {
    StringBuilder pic = new StringBuilder();
    pic.append("++++");
    pic.append("+  +");
    pic.append("+  +");
    pic.append("++++");
    return pic.toString();
    }
}
