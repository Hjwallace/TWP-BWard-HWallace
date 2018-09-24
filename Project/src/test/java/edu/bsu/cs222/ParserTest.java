
package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.security.Key;

public class ParserTest {

    @Test
    public void testParse() {
        RevisionParser revisionParser = new RevisionParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sampledata.json");
        String userResult = revisionParser.parse(inputStream).get(0).getUsername();
        Assert.assertEquals("SemiHypercube", userResult);

    }
