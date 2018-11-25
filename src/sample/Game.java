package sample;

import javafx.util.Pair;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    private ArrayList<ArrayList<Integer>> board;
    private Integer rows = 4;
    private Integer columns = 4;

    public Game() {

        // Populate the board values
        board = new ArrayList<>();

        for (int r=0; r < rows; r++) {
            ArrayList row = new ArrayList();
            for (int c=0; c < columns; c++) {
                row.add(-1);
            }
            board.add(row);
        }
    }

    public void printGame() {
        System.out.println("#----------#");
        for (ArrayList al: board) {
            System.out.println(al);
        }
        System.out.println("#----------#");
    }

    public void printGameCoords() {
        System.out.println("#----------#");

        for (int r=0; r < board.size(); r++) {
            String row = "";
            for (int c=0; c < board.get(r).size(); c++) {
                row = row + " | " + (r + "," + c);
            }
        }
        System.out.println("#----------#");

    }

    public void shift(Move direction){
        switch (direction) {
            case left:
                shiftLeft();
                break;
            case right:
                shiftRight();
                break;
            case up:
                shiftUp();
                break;
            case down:
                shiftDown();
                break;
        }
    }

    private void shiftUp(){
        //Starting from the top of the board (First array)), shift the boiz upwards

        // For all spaces on the board
        for (Integer r=0; r < rows; r++) {
            for (Integer c=0; c < columns; c++) {
                //System.out.println("Pos: " + r + ", " + c + ": " + board.get(r).get(c));

                // If theres a square on the board
                if (board.get(r).get(c) != -1) {
                    while (isClear(new Pair(r, c), Move.up) && board.get(r).get(c) != -1) {

                        Integer value = board.get(r).get(c);

                        try {
                            board.get(r).set(c, -1); // Remove old piece
                            board.get(r - 1).set(c, value); // Move it up
                            r = r - 1;
                        } catch (ArrayIndexOutOfBoundsException e){
                            // If we cant move it out of the board
                            continue;
                        }
                    }

                    // After the move
                    // If we find a match
                    if (r != 0){
                        if (board.get(r).get(c) == board.get(r - 1).get(c)) {

                            Integer value = board.get(r).get(c);

                            board.get(r).set(c, -1);
                            board.get(r - 1).set(c, value * 2);
                        }
                    }
                }
            }
        }
    }

    private void shiftDown(){
        //Starting from the bottom of the board (Last array)), shift the boiz downwards

        // For all spaces on the board
        for (Integer r=rows-1; r >= 0; r--) {
            for (Integer c=0; c < columns; c++) {
                //System.out.println("Pos: " + r + ", " + c + ": " + board.get(r).get(c));

                // If theres a square on the board
                if (board.get(r).get(c) != -1) {
                    while (isClear(new Pair(r, c), Move.down) && board.get(r).get(c) != -1) {

                        Integer value = board.get(r).get(c);

                        try {
                            board.get(r).set(c, -1); // Remove old piece
                            board.get(r + 1).set(c, value); // Move it up
                            r = r + 1;
                        } catch (ArrayIndexOutOfBoundsException e){
                            // If we cant move it out of the board
                            continue;
                        }
                    }

                    // After the move
                    // If we find a match
                    if (r != rows - 1){
                        if (board.get(r).get(c) == board.get(r + 1).get(c)) {

                            Integer value = board.get(r).get(c);

                            board.get(r).set(c, -1);
                            board.get(r + 1).set(c, value * 2);
                        }
                    }
                }
            }
        }
    }

    private void shiftRight() {
        //Starting from the rightmost column of the board (Last index of all arrays)), shift the boiz rightwards
        // For all spaces on the board
        for (Integer r=0; r < rows; r++) {
            for (Integer c=columns - 1; c >= 0; c--) {
                //System.out.println("Pos: " + r + ", " + c + ": " + board.get(r).get(c));

                // If theres a square on the board
                if (board.get(r).get(c) != -1) {
                    while (isClear(new Pair(r, c), Move.right) && board.get(r).get(c) != -1) {

                        Integer value = board.get(r).get(c);

                        try {
                            board.get(r).set(c, -1); // Remove old piece
                            board.get(r).set(c + 1, value); // Move it up
                            c = c + 1; //Follow
                        } catch (ArrayIndexOutOfBoundsException e){
                            // If we cant move it out of the board
                            continue;
                        }
                    }

                    // After the move
                    // If we find a match
                    if (c != columns - 1){
                        if (board.get(r).get(c) == board.get(r).get(c + 1)) {

                            Integer value = board.get(r).get(c);

                            board.get(r).set(c, -1);
                            board.get(r).set(c + 1, value * 2);
                        }
                    }
                }
            }
        }
    }

    private void shiftLeft(){
        //Starting from the leftmost column of the board (First index of all arrays)), shift the boiz rightwards
        // For all spaces on the board
        for (Integer r=0; r <  rows; r++) {
            for (Integer c=0; c < columns; c++) {
                //System.out.println("Pos: " + r + ", " + c + ": " + board.get(r).get(c));

                // If theres a square on the board
                if (board.get(r).get(c) != -1) {
                    while (isClear(new Pair(r, c), Move.left) && board.get(r).get(c) != -1) {

                        Integer value = board.get(r).get(c);

                        try {
                            board.get(r).set(c, -1); // Remove old piece
                            board.get(r).set(c - 1, value); // Move it left
                            c = c - 1; // Follow
                        } catch (ArrayIndexOutOfBoundsException e){
                            // If we cant move it out of the board
                            continue;
                        }
                    }

                    // After the move
                    // If we find a match
                    if (c != 0){
                        if (board.get(r).get(c) == board.get(r).get(c - 1)) {

                            Integer value = board.get(r).get(c);

                            board.get(r).set(c, -1);
                            board.get(r).set(c - 1, value * 2);
                        }
                    }
                }
            }
        }
    }

    private Boolean isClear(Pair<Integer, Integer> position, Move direction) {

        int row = position.getKey();
        int column = position.getValue();

        try {
            switch (direction) {
                case left:
                    return board.get(row).get(column - 1) == -1;
                case right:
                    return board.get(row).get(column + 1) == -1;
                case up:
                    return board.get(row - 1).get(column) == -1;
                case down:
                    return board.get(row + 1).get(column) == -1;
            }
        } catch (Exception e) {
            // If the coords exceed an array / go off the map
            //System.out.println("Tried to move pieces off of the board: " + e + "(" + position + ", " + direction + ")");
            //System.out.println(position + " " + direction);
            return false;
        }
        // Needs for syntax?
        return false;
    }

    public void dropNew() {

        // Always drop a 2
        Integer valueToDrop = 2;

        // Find a list of free squares
        ArrayList<Pair<Integer, Integer>> choices = new ArrayList<>();

        for (Integer r=0; r < rows; r++) {
            for (Integer c=0; c < columns; c++) {
                //System.out.println("Pos: " + r + ", " + c + ": " + board.get(r).get(c));
                if (board.get(r).get(c) == -1) {
                    choices.add(new Pair(r, c));
                }
            }
        }

        // Randomly select a square
        int range = choices.size();  // Max - Min +1
        int random = (int) (Math.random() * range); // (Random * range) + min
        //System.out.println("Random selection is: " + random + " Length of Choices: " + choices.size());
        //System.out.println("The choice corresponds to: " + choices.get(random));

        // Update the square with the value
        int targetRow = choices.get(random).getKey();
        int targetColumn = choices.get(random).getValue();
        board.get(targetRow).set(targetColumn, valueToDrop);
    }

    public ArrayList<ArrayList<Integer>> getBoard() {
        return board;
    }
}
