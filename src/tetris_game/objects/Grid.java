package tetris_game.objects;

import tetris_game.objects.pieces.Coord;
import tetris_game.objects.pieces.Type;

public class Grid {

    private final Type[][] grid;
    private final int width = 10;
    private final int length = 20;

    public Grid(){
        this.grid = new Type[length][width];
        initGrid();
    }

    //Getters
    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public Type[][] getGrid() {
        return grid;
    }

    //Basic actions

    public void initGrid(){
        for (int i = 0; i < length; i++){
            for (int j = 0; j < width; j++){

                this.grid[i][j] = Type.EMPTY;
            }
        }
    }

    public void displayGrid(){
        for (int i = 0; i < length; i++){
            System.out.println();
            for (int j = 0; j < width; j++){
                if (grid[i][j] == Type.EMPTY){
                    System.out.print("| "+ "_" +" ");
                }
                else{
                    System.out.print("| "+ grid[i][j] +" ");
                }
            }
            System.out.print("|");
        }
    }

    public void addPiece(GamePieces p){

        for (Coord c : p.getCoords()){
            this.grid[c.y][c.x] = p.getType();
        }
    }

    //Checks

    public int checkLines(){

        boolean isLine;
        for (int i = length -1; i >= 0; i--){  //On parcourt le tableau en partant du bas
            isLine = true;

            for (int j = 0; j < width; j++){

                if (grid[i][j].equals(Type.EMPTY)) {
                    //System.out.println("not line"+i);
                    isLine = false;
                    break;
                }
            }
            if (isLine){
                return i;
            }
        }
        return -1;
    }

    public int cleanTab(){

        int count = 0;

        while (checkLines() != -1){
            count++;
            int line = checkLines();

            for (int i = line; i >= 1; i--) {
                System.arraycopy(grid[i - 1], 0, grid[i], 0, width);
            }
        }
        return count;
    }

    public boolean checkEndGame(){
        for (int j=0; j<width; j++){
            if (!grid[0][j].equals(Type.EMPTY)){
                return true;
            }
        }
        return false;
    }
}
