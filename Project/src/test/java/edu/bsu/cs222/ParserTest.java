package edu.bsu.cs222;

import jdk.internal.util.xml.impl.Input;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ParserTest {


    //STATUS: Returning Null/not being able to parse through any data
    @Test
    public void testParse() throws IOException, SAXException {
        Parser parse = new Parser();
        InputStream sampleInput = getClass().getClassLoader().getResourceAsStream("testingData.json");
        List<Revision> revisions = parse.parse(sampleInput);
        System.out.println(revisions);
        Assert.assertEquals(4, revisions.size());

    }
}
