package main.java.config;

import main.java.model.Fact;
import main.java.model.Recipient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResourceLoader {
    private final Path recipFile;
    private final Path factFile;
    private final Set<Fact> factSet;
    private final HashSet<Recipient> recipSet;

    public ResourceLoader(Path factFile, Path recipFile) {
        this.factFile = factFile;
        this.recipFile = recipFile;
        this.factSet = new HashSet<Fact>();
        this.recipSet = new HashSet<Recipient>();
        init();
    }


    private void init() {
        loadFacts();
        loadRecip();
    }

    private void loadFacts() {

        int id = 0;

        try {
            List<String> lines = Files.readAllLines(this.factFile);
            lines.stream().map(line -> line.split("/+")).forEach(array -> this.factSet.add(new Fact(this.factSet.size() + 1, array[0])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadRecip() {

        int id = 0;

        try {
            List<String> lines = Files.readAllLines(this.recipFile);

            lines.stream().map(line -> line.split("/+")).forEach(array -> this.recipSet.add(new Recipient(this.recipSet.size() + 1, array[0])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Fact> getFacts() {
        return this.factSet;
    }

    public Set<Recipient> getRecipient() {
        return this.recipSet;
    }

}
