package tetris_game.swing.details;

import tetris_game.objects.GameVariables;

import javax.swing.*;
import java.awt.*;

public class LabelDisplay extends JPanel {

    GameVariables var;

    JLabel time;
    JLabel lines;
    JLabel score;
    JLabel topScore;

    public void setDisplay(GameVariables var)
    {
        this.var = var;

        setBackground(Color.DARK_GRAY);
        setLayout(new GridLayout(2,2, 50,50));

        //add(new JLabel("Next Pieces :"));

        //add(futurePieces);

        this.time = new JLabel("Time : " + var.getTime() / 60 +":"+ var.getTime() % 60);

        this.time.setFont(new Font("Arial", Font.BOLD, 20));
        this.time.setForeground(Color.BLACK);
        add(this.time);

        this.topScore = new JLabel("Top Score :");
        this.topScore.setFont(new Font("Arial", Font.BOLD, 20));
        this.topScore.setForeground(Color.BLACK);
        add(this.topScore);

        this.lines = new JLabel("Lines :" + var.getLines());
        this.lines.setFont(new Font("Arial", Font.BOLD, 20));
        this.lines.setForeground(Color.BLACK);
        add(this.lines);

        this.score = new JLabel("Score :" + var.getScore());
        this.score.setFont(new Font("Arial", Font.BOLD, 20));
        this.score.setForeground(Color.BLACK);
        add(this.score);

        //add(new JToggleButton("RESTART"));

        //add(new JToggleButton("Pause"));
    }

    public void setTime(){
        this.time.setText("Time : " + var.getTime() / 60 +":"+ var.getTime() % 60);
    }

    public void setText(){

        this.lines.setText("Lines :" +var.getLines());
        this.score.setText("Score :" +var.getScore());
    }
}
