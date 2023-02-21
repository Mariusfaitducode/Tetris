package tetris_game.swing.details;

import tetris_game.objects.GameTimer;
import tetris_game.StartGame;
import tetris_game.swing.Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDisplay extends JPanel implements ActionListener {

    Actions keyActions;

    StartGame game;
    JToggleButton pause;
    JButton level;

    int speed;
    public enum Level {EASY, MEDIUM, HARD, IMPOSSIBLE}

    Level levelType;

    boolean pauseTime;


    public ButtonDisplay(StartGame game){

        this.speed = 350;
        this.game = game;
        //this.time = time;
    }

    public void setDisplay(Actions key)
    {
        this.keyActions = key;

        setBackground(Color.DARK_GRAY);

        add(game.getStartButton());

        pause = new JToggleButton("Pause");
        pause.addActionListener(this);
        pause.addKeyListener(keyActions);
        add(pause);

        levelType = Level.MEDIUM;
        speed = 350;
        level = new JButton(""+levelType);
        level.addKeyListener(keyActions);
        level.addActionListener(this);
        add(level);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        java.util.Timer timer = new java.util.Timer();


        if (e.getSource() == pause){

            if (!pauseTime){
                pauseTime = true;
                System.out.println("PAUSE");

                game.getTask().cancel();
            }
            else {
                timer.schedule( new GameTimer(game.piece, game.grid, game.var, speed), 1000, speed);
                pauseTime = false;
            }
        }
        if (e.getSource() == level){

            if (levelType == Level.MEDIUM){
                levelType = Level.HARD;
                this.speed = 250;
            }
            else if (levelType == Level.HARD){
                levelType = Level.IMPOSSIBLE;
                this.speed = 100;
            }
            else if (levelType == Level.IMPOSSIBLE){
                levelType = Level.EASY;
                this.speed = 500;
            }
            else if (levelType == Level.EASY){
                levelType = Level.MEDIUM;
                this.speed = 350;
            }
            game.setSpeed(this.speed);
            level.setText(""+levelType);
        }

    }
}
