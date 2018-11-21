package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        //primaryStage.show();
    }


    public static void main(String[] args) {
        // Yos
        Game mygame = new Game();

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

        // Read all ws separated strings from stdin
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            //System.out.println(sc.next());
            switch(sc.next()){
                case "left":
                    mygame.shift(Move.left);
                    break;
                case "right":
                    mygame.shift(Move.right);
                    break;
                case "up":
                    mygame.shift(Move.up);
                    break;
                case "down":
                    mygame.shift(Move.down);
                    break;
                default:
                    System.out.println("Unknown");
            }

            mygame.dropNew();
            mygame.printGame();
        }

        //launch(args);
    }
}
