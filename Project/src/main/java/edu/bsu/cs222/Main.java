package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.stage.Stage;

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


        //Windows
        HBox mainWindow = new HBox(20);
        VBox userSide = new VBox(20);
        //User Componets
        Label title = new Label("WikiSearcher");
        Label description = new Label("Enter the word for the wiki page you want to investigate");
        TextField userField = new TextField();
        Button subButton = new Button("Submit Search");
        userSide.getChildren().addAll(title,description,userField,subButton);
        userSide.setAlignment(Pos.CENTER);
        //Output Componets
        VBox outPutWindow = new VBox();
        TextField outPut = new TextField();
        outPut.setPrefSize(700,500);
        outPutWindow.getChildren().add(outPut);
        outPutWindow.setAlignment(Pos.CENTER);


        //Set the wikiPageConnection with the button
        //subButton.setOnAction(event -> outPut.setText("Hi this button works"));

        subButton.setOnAction(event -> {
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
                System.out.println("------------------------------------");
                System.out.println("Revisor " +(i+1)+": "+wikiUserData.get(i).getUsername());
                System.out.println("Time of change: " +wikiUserData.get(i).getTimestamp());
                System.out.println("------------------------------------");
                name = wikiUserData.get(i).getUsername();
                outPut.appendText(name);

            }


            /*First Test
            for (int i = 0; i < wikiUserData.length; i++){
                System.out.println("Straight from wikiUser data " +i+": "+wikiUserData[i]);

                transfer = wikiUserData[i].toString();
                System.out.println(i + "."+transfer);
                message+=transfer;
            }
            */


        });//End of button action


        

        //Line
        Line seperator = LineBuilder.create().startX(width/2).startY(0).endX(width/2).endY(height).fill(Color.BLACK).build();
        mainWindow.getChildren().addAll(userSide,seperator,outPutWindow);

        primaryStage.setScene(new Scene(mainWindow,width,height));//Place screen dimensions
        primaryStage.show();


    }
}
