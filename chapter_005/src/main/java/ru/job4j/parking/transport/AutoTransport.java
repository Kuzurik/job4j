package ru.job4j.parking.transport;

/**
 * @author Aliaksandr Kuzura (vorota-24@bk.ru)
 * @version $Id$
 * @since 0.1
 */


public abstract class AutoTransport {
    /**
     * transport name
     */
    private final String name;

    /**
     * transport size for parking
     */
    private final int size;

    /**
     * Constructor
     * @param name transport name
     * @param size transport size
     */
    public AutoTransport(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AutoTransport{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
