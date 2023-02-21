package tetris_game.objects.pieces;

public class Coord {

    public int x;
    public int y;

    public Coord(int x, int y){
        if (x >= 0 && x < 10 && y >= 0 && y < 20){
            this.x = x;
            this.y = y;
        }
    }
}
