package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static edu.bsu.cs222.URLConnectionReader.URLtoInputStream;

public class Main extends Application {
    //HBOX = Horizontal organization
    //VBOX = Verticle organization


    @Override
    public void start(Stage primaryStage) throws Exception {
        int width = 900;
        int height = 600;
        Connection connection = new Connection();
        boolean connectionStatus = connection.findConnection();


        //Windows
        HBox mainWindow = new HBox(20);
        VBox userSide = new VBox(20);
        //User Componets
        Label title = new Label("WikiSearcher");
        Label description = new Label("Enter the word for the wiki page you want to investigate");
        TextField userField = new TextField();
        Button subButton = new Button("Submit Search");
        Label connectionTextBox = new Label("I am a label");

        //------------Color Loop------------
        if (connectionStatus){
            connectionTextBox.setText("Connection is Present");
            connectionTextBox.setTextFill(Color.color(0.0,1.0,0.0));
        }
        else {
            connectionTextBox.setText("Connection is not Present");
            connectionTextBox.setTextFill(Color.color(1.0,0.0,0.0));
        }
        //--------------------------------

        userSide.getChildren().addAll(title,description,userField,subButton,connectionTextBox);
        userSide.setAlignment(Pos.CENTER);
        //Output Componets
        VBox outPutWindow = new VBox();
        TextArea outPut = new TextArea();
        outPut.setPrefSize(500,500);
        outPutWindow.getChildren().add(outPut);
        outPutWindow.setAlignment(Pos.CENTER);


        //Set the wikiPageConnection with the button
        //subButton.setOnAction(event -> outPut.setText("Hi this button works"));

        subButton.setOnAction(event -> {

            outPut.clear();
            final String wordToSearch = userField.getText();
            System.out.println(wordToSearch);

            InputStream wikiPageData = null;
            try {
                wikiPageData = URLtoInputStream(wordToSearch);
                System.out.println(wikiPageData);
            } catch (IOException e) {
                e.printStackTrace();
            }

            RevisionParser parser = new RevisionParser();
            List<Revision> wikiUserData = parser.parse(wikiPageData);
            //String[] wikiUserData = (parser.parse(wikiPageData)).toArray(new String[0]);

            System.out.println(wikiUserData);
            String name;
            String time;

            for (int i = 0; i< wikiUserData.size();i++){
                /*
                System.out.println("------------------------------------");
                System.out.println("Revisor " +(i+1)+": "+wikiUserData.get(i).getUsername());
                System.out.println("Time of change: " +wikiUserData.get(i).getTimestamp());
                System.out.println("------------------------------------");
                */
                name = wikiUserData.get(i).getUsername();
                time =wikiUserData.get(i).getTimestamp();
                outPut.appendText("---------------"+(i+1)+"-------------------------\n");
                outPut.appendText("Revisor " + i +": "+name+"\n");
                outPut.appendText("Time of change: "+time+"\n");
                outPut.appendText("-----------------------------------------\n");


            }


        });//End of button action


        

        //Line
        Line seperator = LineBuilder.create().startX(width/2).startY(0).endX(width/2).endY(height).fill(Color.BLACK).build();
        mainWindow.getChildren().addAll(userSide,seperator,outPutWindow);

        primaryStage.setScene(new Scene(mainWindow,width,height));//Place screen dimensions
        primaryStage.show();


    }
}
