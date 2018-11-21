package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.awt.event.KeyListener;
import java.util.Scanner;

public class Main extends Application {

    private static Game mygame;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        primaryStage.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ESCAPE:
                    break;
                case SPACE:
                    break;
                case LEFT:
                    mygame.shift(Move.left);
                    break;
                case UP:
                    mygame.shift(Move.up);
                    break;
                case RIGHT:
                    mygame.shift(Move.right);
                    break;
                case DOWN:
                    mygame.shift(Move.down);
                    break;
                default:
                    break;
            }
        });
    }


    public static void main(String[] args) {
        // Yos
        mygame = new Game();

        // 4x4
        mygame.printGame();
        mygame.dropNew();
        mygame.dropNew();
        mygame.dropNew();
        mygame.dropNew();
        mygame.dropNew();
        mygame.dropNew();
        mygame.dropNew();
        mygame.dropNew();
        mygame.printGame();

        System.out.println("### SHIFT LEFT ###");

        mygame.shift(Move.left);

        mygame.printGame();

        System.out.println("### SHIFT RIGHT ###");
        mygame.shift(Move.right);

        mygame.printGame();

        Squares mysquares = new Squares();

        System.out.println(mysquares.findFree());


//            mygame.dropNew();
//            mygame.printGame();
//        }


        launch(args);
    }
}
