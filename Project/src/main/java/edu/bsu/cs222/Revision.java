package edu.bsu.cs222;

import com.google.gson.JsonObject;

public class Revision {

    private String username;
    private String timestamp;

    Revision(JsonObject object) {
        this.username = object.get("user").getAsString();
        this.timestamp = object.get("timestamp").getAsString();
    }

    String getUsername() {
        return username;
    }

    String getTimestamp() {
        return timestamp;
    }
}
