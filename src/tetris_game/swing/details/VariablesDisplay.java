package tetris_game.swing.details;

import javax.swing.*;
import java.awt.*;

public class VariablesDisplay extends JPanel {

    public void setDisplay(FuturePieceDisplay futurePieces, LabelDisplay label, ButtonDisplay button )
    {
        setBackground(Color.DARK_GRAY);
        setLayout(new GridLayout(3,1, 20,20));

        add(futurePieces);
        add(label);
        add(button);
    }
}
