package config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Fact;
import model.Recipient;

public class ResourceLoader {
	private Path recipFile;
	private Path factFile;
	private Set<Fact> factSet;
	private HashSet<Recipient> recipSet;

	public ResourceLoader(Path factFile, Path recipFile) {
		this.factFile = factFile;
		this.recipFile = recipFile;
		this.factSet = new HashSet<Fact>();
		this.recipSet = new HashSet<Recipient>();
	}
	
	
	public void init(){
		loadFacts();
		loadRecip();
	}
	private void loadFacts() {

		int id = 0;

		try {
			List<String> lines = Files.readAllLines(this.factFile);
			for (String line : lines) {
				factSet.add(new Fact(id, line, "NFL"));
				id++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadRecip() {

		int id = 0;

		try {
			List<String> lines = Files.readAllLines(recipFile);
			for (String line : lines) {
				recipSet.add(new Recipient(id, line, "NFL"));
				id++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Set<Fact> getFacts(){
		return factSet;
	}
	
	public Set<Recipient> getRecipient(){
		return recipSet;
	}

}
