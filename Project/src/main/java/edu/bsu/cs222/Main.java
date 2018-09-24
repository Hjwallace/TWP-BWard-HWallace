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

public class Main extends Application {
    //HBOX = Horizontal organization
    //VBOX = Verticle organization


    @Override
    public void start(Stage primaryStage) throws Exception {
        int width = 700;
        int height = 400;

        //VBox parent = new VBox();
        //parent.getChildren().add(new Label("Hello World"));

        //HBox urlArea = new HBox(new Label("URL:"));
        //TextField textField = new TextField();
        //urlArea.getChildren().add(textField);

        //parent.getChildren().add(urlArea);

        //Button button = new Button("Press me!");
        //button.setOnAction(event -> System.out.println("You pressed me"));
        //parent.getChildren().add(button);
        //Line middleLine = LineBuilder.create().startX(350).startY(0).endX(350).endY(400).fill(Color.BLACK).build();
        //parent.getChildren().add(middleLine);

        //Scene scene = new Scene(new Label("Foo"));
        //parent.setSpacing(50);
        //parent.setAlignment(Pos.CENTER_LEFT);
        //primaryStage.setScene(new Scene(parent,700,400));
        //primaryStage.show();

        HBox mainWindow = new HBox(20);

        VBox userSide = new VBox(20);

        Label title = new Label("I am a title");
        Label description = new Label("Put Text below me");
        TextField textField = new TextField();
        Button subButton = new Button("Click me to do something");
        userSide.getChildren().addAll(title,description,textField,subButton);
        userSide.setAlignment(Pos.CENTER);

        VBox outPutWindow = new VBox();

        TextField outPut = new TextField();
        outPutWindow.getChildren().add(outPut);
        outPutWindow.setAlignment(Pos.CENTER);

        subButton.setOnAction(event -> outPut.setText("Hi this button works"));

        Line seperator = LineBuilder.create().startX(width/2).startY(0).endX(width/2).endY(height).fill(Color.BLACK).build();

        mainWindow.getChildren().addAll(userSide,seperator,outPutWindow);

        primaryStage.setScene(new Scene(mainWindow,width,height));//Place screen dimensions
        primaryStage.show();

    }
}
