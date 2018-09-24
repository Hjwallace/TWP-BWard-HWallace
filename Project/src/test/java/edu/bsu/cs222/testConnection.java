package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
//https://stackoverflow.com/questions/1402005/how-to-check-if-internet-connection-is-present-in-java

public class testConnection {

    @Test
    public void testConnectionIsPresent() throws IOException {
        //boolean connectionStatus;
        //try {
           // final URL url = new URL("http://www.google.com");
            //final URLConnection conn = url.openConnection();
            //conn.connect();
            //conn.getInputStream().close();
            //connectionStatus = true;
        //}catch (MalformedURLException e) {
          //  throw new RuntimeException(e);
        //} catch (IOException e) {
          //  connectionStatus = false;
        //}
        //Assert.assertEquals(true,connectionStatus);
        URL url = new URL("https://en.wikipedia.org");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (me@bsu.edu)");
        InputStream in = connection.getInputStream();
        Assert.assertNotNull(in);
    }
}
