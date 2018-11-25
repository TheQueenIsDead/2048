package sample;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    private static ArrayList<ArrayList<Label>> labels;

    private static HashMap colourMap = new HashMap<Integer, Color>()
    {{
        put(-1, Color.DARKGREY);
        put(2, Color.RED);
        put(4, Color.BLUE);
        put(8, Color.GREEN);
        put(16, Color.YELLOW);
        put(32, Color.PINK);
        put(64, Color.MEDIUMPURPLE);
    }};


    @FXML
    GridPane mainGridPane;

    @FXML
    public void initialize(){

        labels = new ArrayList<>();

        for (int r=0; r < 4; r++) {
            ArrayList<Label> row = new ArrayList<>();
            for (int c=0; c < 4; c++) {
                Label l = new Label(r + ", " + c);

                l.setFont(Font.font("Comic Sans Ms", 20));
                l.setAlignment(Pos.CENTER);
                GridPane.setHalignment(l, HPos.CENTER);
                GridPane.setValignment(l, VPos.CENTER);

                row.add(l);
                mainGridPane.add(l, c, r);
            }
            System.out.println(row);
            labels.add(row);
        }
    }



    static void update(ArrayList<ArrayList<Integer>> board){

        for (int r=0; r < board.size(); r++) {
            for (int c=0; c < board.get(r).size(); c++) {
                Label displaylLabel = labels.get(r).get(c);
                Integer squareValue = board.get(r).get(c);
                if (squareValue.equals(-1)) {
                    displaylLabel.setText(" ");
                } else {
                    displaylLabel.setText(squareValue.toString());
                }

                /*
                    layout.setBackground(new Background(new BackgroundFill(Color.rgb(r, g, b), CornerRadii.EMPTY, Insets.EMPTY)));
                 */
                displaylLabel.setBackground(new Background(new BackgroundFill((Paint) colourMap.get(squareValue), new CornerRadii(25), Insets.EMPTY)));
                displaylLabel.setMinWidth(28);
//                Color squareColour = (Color) colourMap.get(squareValue);
//                StringBuilder colourStyle = new StringBuilder()
//                        .append("-fx-background-color: rgb(")
//                        .append(squareColour.getRed()).append(',')
//                        .append(squareColour.getGreen()).append(',')
//                        .append(squareColour.getBlue())
//                        .append(");");
//                System.out.println(colourStyle);
//
//                displaylLabel.setStyle(colourStyle.toString());
            }
        }
    }
}
