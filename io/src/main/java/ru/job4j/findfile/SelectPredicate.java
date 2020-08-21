package ru.job4j.findfile;

import java.nio.file.Path;

import java.util.function.Predicate;

public class SelectPredicate {
    private final ArgFind args;
    private final String arg;

    public SelectPredicate(ArgFind args, String arg) {
        this.args = args;
        this.arg = arg;
    }

    public Predicate<Path> select() {
        Predicate<Path> predicate;
        switch (this.arg) {
            case ("-f") :
                predicate = p -> p.toFile().getName().equals(args.fileName());
                break;

            case ("-m") :
                predicate = p -> p.toFile().getName().endsWith(args.fileName());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.arg);
        }
        return predicate;
    }


}
