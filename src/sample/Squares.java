package sample;

import java.util.ArrayList;
import java.util.List;

public class Squares {


    private ArrayList<Square> squares;
    private Integer rows;
    private Integer columns;

    public Squares() {
        squares = new ArrayList<>();
        rows = 4;
        columns = 4;
    }

    public void addSquare() {


        List coords = new ArrayList();

        Integer[] coordsarray = { 1, 2 };


        Square newSquare = new Square(0, 0);
        squares.add(newSquare);
    }

    public ArrayList<String> findFree(){

        ArrayList<String> places = new ArrayList<>();

        for (int r=0; r < rows; r++) {
            for (int c=0; c < columns; c++) {
                //System.out.println(r + "-" + c);
                places.add(r + "-" + c);
            }
        }

        return places;
    }

    public void moveSquare(Square square, Integer row, Integer Column){

    }


}
