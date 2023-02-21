package tetris_game.objects;
import tetris_game.objects.pieces.Coord;
import tetris_game.objects.pieces.Type;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class GamePieces {

    private List <Coord> coords;
    private Type type;
    private Coord center;
    private Color color;

    //Constructor

    public GamePieces(){

    }  //super(); in extends class

    public GamePieces(GamePieces piece){
        this.coords = piece.getCoords();
        this.type = piece.getType();
        this.center = piece.getCenter();
        this.color = piece.color;
    }

    //Instantiate

    public void rndSpawn(Grid grid){
        Random rnd = new Random();
        for (int i = 0; i < rnd.nextInt(grid.getWidth()); i++){
            right(grid);
        }
    }

    //Affichage

    public void display(){
        for (Coord piece : this.coords){
            System.out.println("x:"+ piece.x +", y:"+ piece.y);
        }
    }

    //Getters setters

    public List <Coord> getCoords(){
        return this.coords;
    }
    public void setPos(List <Coord> position){
        this.coords = position;
    }

    public Coord getCenter(){
        return this.center;
    }
    public void setCenter(Coord position){
        this.center = position;
    }

    public void setType(Type type){
        this.type = type;
    }
    public Type getType(){
        return this.type;
    }

    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return this.color;
    }

    public String getStringType(){
        String st;
        st = ""+this.type;
        return st;
    }

    //Mouvement

    public void fall(){
        for (Coord c : this.coords){
            c.y += 1;
        }
    }

    public void right(Grid grid){

        if (!blockedRight(grid)){
            for (Coord c : this.coords){
                c.x += 1;
            }
        }
    }

    public void left(Grid grid){

        if (!blockedLeft(grid)){
            for (Coord c : this.coords){
                c.x -= 1;
            }
        }
    }

    public void rotate(){

        int center_x = center.x;
        int center_y = center.y;

        int tmp;
        for (Coord c : this.coords){
            c.x -= center_x;
            c.y -= center_y;

            tmp = c.x;
            c.x = -c.y;
            c.y = tmp;

            c.x += center_x;
            c.y += center_y;

            System.out.println("x : "+c.x+ "   y :"+c.y);
        }
        if (isOut()){
            rotate();
        }
    }

    //Check position

    public boolean isOut(){

        for (Coord c : this.coords){
            if (c.x < 0 || c.x >= 10 || c.y < 0 || c.y >= 20) {
                return true;
            }
        }
        return false;
    }

    public boolean isOut(int x, int y) { return x < 0 || x >= 10 || y < 0 || y >= 20;}

    public boolean isPiece(int x, int y){
        for (Coord c : this.coords){

            if (c.x == x && c.y == y){
                return true;
            }
        }
        return false;
    }

    public boolean isStopped(Grid grid){
        return touchDown() || blockedDown(grid);
    }

    public boolean touchDown(){

        //boolean stopped = false;

        for (Coord c : this.coords){  //Touche le sol
            if (c.y + 1 >= 20) {
                return true;
            }
        }
        return false;
    }

    public boolean blockedLeft(Grid grid){

        for (Coord c : this.coords){
            if (!isPiece(c.x-1, c.y)){

                if ( c.x - 1 < 0){
                    return true;
                }
                if (!grid.getGrid()[c.y][c.x - 1].equals(Type.EMPTY)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean blockedRight(Grid grid){

        for (Coord c : this.coords){
            if (!isPiece(c.x+1, c.y)){

                if ( c.x + 1 >= 10){
                    return true;
                }
                if (!grid.getGrid()[c.y][c.x + 1].equals(Type.EMPTY)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean blockedDown(Grid grid){

        for (Coord c : this.coords){

            if (!isPiece(c.x, c.y + 1)){

                if (!isOut(c.x, c.y+1)){
                    if (!grid.getGrid()[c.y + 1][c.x].equals(Type.EMPTY)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
