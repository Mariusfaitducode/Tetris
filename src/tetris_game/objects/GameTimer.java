package tetris_game.objects;

import java.util.TimerTask;

public class GameTimer extends TimerTask {

    public static float time = 1;

    Grid grid;
    GamePieces piece;
    GameVariables var;
    int speed;

    public GameTimer(GamePieces piece, Grid grid, GameVariables var, int speed){
        this.piece = piece;
        this.grid = grid;
        this.speed = speed;
        this.var = var;
    }


    public void run() {

        time += (float)speed / 1000;

        //System.out.println("time : "+ (int)time);

        var.setTime((int)time);

        piece.fall();

        if(piece.isStopped(grid)) {

            //System.out.println("Stop calling");
            time += 1;
            cancel();

        }
    }
}


