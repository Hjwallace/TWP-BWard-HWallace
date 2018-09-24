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

public class Main extends Application {
    //HBOX = Horizontal organization
    //VBOX = Verticle organization


    @Override
    public void start(Stage primaryStage) throws Exception {
        int width = 700;
        int height = 400;



        //Windows
        HBox mainWindow = new HBox(20);
        VBox userSide = new VBox(20);
        //User Componets
        Label title = new Label("I am a title");
        Label description = new Label("Put Text below me");
        TextField textField = new TextField();
        Button subButton = new Button("Click me to do something");
        userSide.getChildren().addAll(title,description,textField,subButton);
        userSide.setAlignment(Pos.CENTER);
        //Output Componets
        VBox outPutWindow = new VBox();
        TextField outPut = new TextField();
        outPutWindow.getChildren().add(outPut);
        outPutWindow.setAlignment(Pos.CENTER);
        subButton.setOnAction(event -> outPut.setText("Hi this button works"));
        //Line
        Line seperator = LineBuilder.create().startX(width/2).startY(0).endX(width/2).endY(height).fill(Color.BLACK).build();
        mainWindow.getChildren().addAll(userSide,seperator,outPutWindow);

        primaryStage.setScene(new Scene(mainWindow,width,height));//Place screen dimensions
        primaryStage.show();

    }
}
