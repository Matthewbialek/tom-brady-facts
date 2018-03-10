package test.java.Configuration;

import main.java.config.ResourceLoader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;


/**
 * Created by mattbialek on 2/19/17.
 */
public class ResourceLoaderTest {
    ResourceLoader test;

    @Before
    public void setupTest() {
        this.test = new ResourceLoader(Paths.get("/Users/matthewbialek/dev/git/tom-brady-facts/src/main/resource/facts.txt"), Paths.get("/Users/matthewbialek/dev/git/tom-brady-facts/src/main/resource/recipient.txt"));
    }


    @After
    public void tearDown() {
        this.test = null;
    }

    @Test
    public void fileLoadFacts() {
        Assert.assertTrue(!this.test.getFacts().isEmpty());
    }

    @Test
    public void fileLoadRecipients() {
        Assert.assertTrue(!this.test.getRecipient().isEmpty());
    }


}
