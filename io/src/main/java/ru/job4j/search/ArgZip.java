package ru.job4j.search;

public class ArgZip {
    /**
     * list of arguments
     */

    private final String[] args;

    /**
     * Constructor
     * @param args
     */

    public ArgZip(String[] args) {
        this.args = args;
    }

    /**
     * check all arguments
     * @return boolean
     */

    public boolean valid() {
        if (this.args.length < 6) {
            throw new IllegalArgumentException("Not enough argument");
        }
        return true;
    }

    /**
     * check arg -d
     * @return root directory
     */

    public String directory() {
        String result = "";
        if (valid() && this.args[0].equals("-d")) {
            result = this.args[1];
        }
        return result;
    }

    /**
     * check arg -e
     * @return exclude file extension
     */

    public String exclude() {
        String result = "";
        if (valid() && this.args[2].equals("-e")) {
            result = this.args[3];
        }
        return result;
    }

    /**
     * check arg -o
     * @return output file name and extension
     */

    public String output() {
        String result = "";
        if (valid() && this.args[4].equals("-o")) {
            result = this.args[5];
        }
        return result;
    }
}
