package ru.job4j.search;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;


public class Search {

	public static void main(String[] args) throws Exception {
		Path startDir = Paths.get("/home/alex/project/job4j/io");
		search(startDir, t -> t.toFile().getName().endsWith("html")).forEach(System.out::println);
	}
	
	public static List<Path> search(Path root, Predicate<Path> condition) throws Exception  {
		SearchFiles searcher = new SearchFiles(condition);
		Files.walkFileTree(root, searcher);
		return searcher.getPaths();
	}

}
