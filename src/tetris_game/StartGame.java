package tetris_game;

import tetris_game.objects.*;
import tetris_game.swing.Actions;
import tetris_game.swing.GameDisplay;
import tetris_game.swing.details.FuturePieceDisplay;
import tetris_game.swing.details.LabelDisplay;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class StartGame implements ActionListener {

    JFrame f;

    FuturePieceDisplay nextPieces;
    LabelDisplay label;

    GameDisplay tabDisplay;
    Actions keyActions;

    public Grid grid;
    public GamePieces piece;
    public GameVariables var;

    int speed;
    boolean endGame = false;
    boolean startGame = false;

    JButton start;

    TimerTask task;

    public StartGame(JFrame f, FuturePieceDisplay nextPieces, LabelDisplay label, GameDisplay tabDisplay, Actions keyActions, Grid grid, int speed){

        this.f = f;
        this.nextPieces = nextPieces;
        this.label = label;
        this.tabDisplay = tabDisplay;
        this.keyActions = keyActions;
        this.grid = grid;
        this.speed = speed;


        start = new JButton(" Start ");
        start.addActionListener(this);
        start.addKeyListener(keyActions);
    }

    public void setSpeed (int speed){
        this.speed = speed;
    }

    public JButton getStartButton(){
        return start;
    }

    public TimerTask getTask(){return task;}

    public boolean getStart(){return startGame;}
    public void setStart(boolean start){this.startGame = start;}

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == start){
            start.setText("Restart");
            this.startGame = true;
        }
    }

    public void startGame(){

        grid.initGrid();

        f.repaint();

        var = new GameVariables();
        label.setDisplay(var);

        java.util.Timer timer = new java.util.Timer();

        GamePieces piece1 = new GamePieces(new ListPieces().initPiece());
        GamePieces piece2 = new GamePieces(new ListPieces().initPiece());
        GamePieces piece3 = new GamePieces(new ListPieces().initPiece());

        while ( !endGame ){

            this.piece = piece1;
            piece1 = piece2;
            piece2 = piece3;
            piece3 = new GamePieces(new ListPieces().initPiece());

            nextPieces.setListPiece(piece1, piece2, piece3);

            keyActions.setPiece(piece);
            tabDisplay.setPiece(piece);

            task = new GameTimer(piece, grid, var, speed);
            timer.schedule(task, 1000, speed);

            while(!piece.isStopped(grid)){

                label.setTime();
                f.repaint();
            }
            //System.out.println("piece down");

            grid.addPiece(piece);

            int lines = grid.cleanTab();

            var.countLines(lines);
            var.setScore(lines);

            //System.out.println(var.getLines());

            label.setText();

            f.repaint();//making the frame visible

            this.piece = null;

            endGame = grid.checkEndGame();
        }
    }
}
