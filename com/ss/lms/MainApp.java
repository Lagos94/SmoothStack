package com.ss.lms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class MainApp extends Application {

    /**
     * launch MainApp
     */
    public static void main(String[] args) {
        launch(MainApp.class, args);
    }

    /**
     * @param primaryStage to run
     */
    @Override
    public void start(Stage primaryStage) {

        LMSTab lmsTab = new LMSTab(primaryStage);
        TabPane tabPane = new TabPane(lmsTab);
        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Smoothstack");
        primaryStage.show();

        // Bind the tab width to the screen width
        tabPane.prefWidthProperty().bind(primaryStage.widthProperty());
    }
}
