package ru.job4j.findfile;

public class ArgFind {
    private final String[] args;

    public ArgFind(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (this.args.length != 7) {
            throw new IllegalArgumentException("Illegal arguments");
        }
        return true;
    }

    public String directory() {
        if (valid() && this.args[0].equals("-d")) {
            return this.args[1];
        }
        return "";
    }

    public String fileName() {
        if (valid() && this.args[2].equals("-n")) {
            return this.args[3];
        }
        return "";
    }

    public String getMatch() {
        return this.args[4];
    }

    public String output() {
        if (valid() && this.args[5].equals("-o")) {
            return args[6];
        }
        return "";
    }
}
