package ru.job4j.findfile;

public class ArgFind {
    private final String[] args;

    public ArgFind(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (this.args.length != 7) {
            throw new IllegalArgumentException("Illegal arguments " +
                    "-d start Directory " +
                    "-n file name or mask" +
                    "-m find mask -f filename" +
                    "-o output file ");
        }
        return true;
    }

    public String directory() {
        return this.args[1];
    }

    public String fileName() {
        return this.args[3];
    }

    public String getMatch() {
        return this.args[4];
    }

    public String output() {
        return args[6];
    }
}
