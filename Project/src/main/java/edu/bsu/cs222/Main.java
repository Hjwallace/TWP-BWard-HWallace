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

        //Step 1: Make Grandparent
        HBox mainWindow = new HBox();
        //Step 2: Make User Side of window
        VBox userSide = new VBox();
        //Step 3: Add componets to userSide
        Label title = new Label("I am a title");
        Label description = new Label("Put Text below me");
        TextField textField = new TextField();
        Button subButton = new Button("Click me to do something");
        userSide.getChildren().addAll(title,description,textField,subButton);

        primaryStage.setScene(new Scene(userSide));//Place screen dimensions
        primaryStage.show();

    }
}
