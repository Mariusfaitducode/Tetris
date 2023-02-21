package tetris_game.objects;

import tetris_game.StartGame;

import java.util.TimerTask;

public class GameTimer2 extends TimerTask {

    StartGame game;


    public GameTimer2 (StartGame game){
        this.game = game;
    }

    @Override
    public void run() {
        if (game.getStart() ){
            game.startGame();
            System.out.println("run ?");
            game.setStart(false);
        }
    }
}
