package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

//https://github.com/bsu-cs222-fall2018-dll/TWP_nabartling-jeshallcross-mwilliams16/blob/master/src/main/java/edu/bsu/cs222/URLConnectionReader.java

public class URLConnectionReader {

    static InputStream URLtoInputStream(String wikiSearch) throws IOException{
        System.out.println("Searching "+wikiSearch+" on Wikipedia");
        wikiSearch = URLEncoder.encode(wikiSearch, "UTF16");
        String wikiResult = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + wikiSearch + "&rvprop=timestamp|user&rvlimit=25&redirects";
        URL url = new URL(wikiResult);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (me@bsu.edu)");
        return connection.getInputStream();

    }
}
