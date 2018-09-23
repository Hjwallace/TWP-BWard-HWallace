package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox parent = new VBox();
        parent.getChildren().add(new Label("Hello World"));

        HBox urlArea = new HBox(new Label("URL:"));
        TextField textField = new TextField();
        urlArea.getChildren().add(textField);

        parent.getChildren().add(urlArea);

        Button button = new Button("Press me!");
        button.setOnAction(event -> System.out.println("You pressed me"));
        parent.getChildren().add(button);

        //Scene scene = new Scene(new Label("Foo"));
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

    }
}
