package edu.bsu.cs222;

import jdk.internal.util.xml.impl.Input;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ParserTest {

    @Test
    public void testParse(){
        Parser parse = new Parser();
        InputStream sampleInput = getClass().getClassLoader().getResourceAsStream("testData.json");
        List<Revision> revisions = parse.parse(sampleInput);
        Assert.assertEquals(4, revisions.size());

    }
}
