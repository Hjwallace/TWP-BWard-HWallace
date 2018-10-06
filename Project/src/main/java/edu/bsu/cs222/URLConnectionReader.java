package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


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
