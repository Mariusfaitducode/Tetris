package tetris_game;

import tetris_game.objects.*;
import tetris_game.swing.*;
import tetris_game.swing.details.ButtonDisplay;
import tetris_game.swing.details.FuturePieceDisplay;
import tetris_game.swing.details.LabelDisplay;
import tetris_game.swing.details.VariablesDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class Game {

     public static JFrame f;
     public final static int windowWidth = 840;
     public final static int windowLength = 800;


     public void frameDisplay(){

     }

     public void start(){

          Grid grid = new Grid();

          GameVariables var = new GameVariables();

          int speed = 350;


          //Swing affichage

          f = new JFrame("Tetris Game");//creating instance of JFrame
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          f.setLayout(new GridLayout(1,2));

          f.setSize(windowWidth, windowLength);//400 width and 500 height
          f.setBounds(100, 0, windowWidth, windowLength);

          f.getContentPane().setBackground(Color.DARK_GRAY);
          //f.setForeground(Color.BLUE);


          //Init swing class

          GameDisplay tabDisplay = new GameDisplay(); //display class
          tabDisplay.setGrid(grid);

          Actions keyActions = new Actions();  //actions class
          keyActions.setGrid(grid);

          FuturePieceDisplay futurePieces = new FuturePieceDisplay();
          //futurePieces.setListPiece(piece1, piece2, piece3);

          LabelDisplay label = new LabelDisplay();
          //label.setDisplay(var);


          StartGame game = new StartGame(f, futurePieces, label, tabDisplay, keyActions, grid, speed);

          ButtonDisplay button = new ButtonDisplay(game);

          button.setDisplay(keyActions);

          VariablesDisplay varDisplay = new VariablesDisplay();
          varDisplay.setDisplay(futurePieces, label, button);


          f.add(tabDisplay);

          f.addKeyListener(keyActions);

          f.add(varDisplay);

          //JEU

          f.setVisible(true);//making the frame visible

          java.util.Timer timer = new java.util.Timer();

          TimerTask task = new GameTimer2(game);
          timer.schedule(task, 1000, 100);
     }

     public static void main (String[] args) {

          Game game = new Game();
          game.start();

     }
}
