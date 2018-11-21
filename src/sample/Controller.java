package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<ArrayList<Label>> labels;


    @FXML
    GridPane mainGridPane;

    @FXML
    public void initialize(){

        labels = new ArrayList<>();

        for (int r=0; r < 4; r++) {
            ArrayList<Label> row = new ArrayList<>();
            for (int c=0; c < 4; c++) {
                Label l = new Label("text");
                mainGridPane.add(l, r, c);
            }
            labels.add(row);
        }
    }



    public static void update(ArrayList<ArrayList<Integer>> board){
        for (int r=0; r < board.size(); r++) {
            for (int c=0; r < board.get(r).size(); c++) {
                labels.get(r).get(c).setText(board.get(r).get(c).toString());
            }
        }
    }
}
