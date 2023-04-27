package com.example.connect4javaapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{
  private Controller controller;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("layout.fxml"));
        GridPane rootGridPane=loader.load();
        controller=loader.getController();
        controller.createPlayground();

        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        Pane menuPane=(Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene =new Scene(rootGridPane);
        stage.setScene(scene);
        stage.setTitle("Connect4");
        stage.setResizable(false);
        stage.show();
    }
    private MenuBar createMenu()
    {
        Menu fileMenu=new Menu("File");
        MenuItem newGame=new MenuItem("New Game");
        newGame.setOnAction(event -> resetGame() );
        MenuItem resetGame=new MenuItem("Reset Game");
        resetGame.setOnAction(event -> resetGame() );
        SeparatorMenuItem seperatorMenuItem=new SeparatorMenuItem();
        MenuItem exitGame=new MenuItem("Exit Game");
        exitGame.setOnAction(event->exitGame());
        fileMenu.getItems().addAll(newGame,resetGame,seperatorMenuItem,exitGame);

        Menu helpMenu=new Menu("Help");
        MenuItem aboutGame=new MenuItem("About Game");
        aboutGame.setOnAction(actionEvent -> aboutGame());
        SeparatorMenuItem seperatorMenuItem1=new SeparatorMenuItem();

        MenuItem aboutMe=new MenuItem("About Me");
        aboutMe.setOnAction(actionEvent -> aboutMe());
        helpMenu.getItems().addAll(aboutGame,seperatorMenuItem1,aboutMe);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Me");
        alert.setHeaderText("Ramya Sri");
        alert.setContentText("Hi! I am Ramya, a CS Undergrad at Andhra University. I love coding and playing games. This Connect4 game is a work of mine. Happy gaming!");
        alert.show();
    }

    private void aboutGame() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect4");
        alert.setHeaderText("How to Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the" +
                "top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column."+
                " The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game."+
                " The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
        controller.resetGame();
    }

}
