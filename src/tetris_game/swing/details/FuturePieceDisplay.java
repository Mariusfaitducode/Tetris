package tetris_game.swing.details;

import tetris_game.objects.GamePieces;
import tetris_game.objects.pieces.Coord;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FuturePieceDisplay extends JPanel {

    public final int tabX = 0;
    public final int tabY = 20;
    public final int tabW = 310;
    public final int tabL = 150;

    public final int tabCase = 30;


    private List<GamePieces> list;
    //GamePieces piece;


    public void setListPiece(GamePieces piece1, GamePieces piece2, GamePieces piece3){
        list = new ArrayList<>(3);
        list.add(piece1);
        list.add(piece2);
        list.add(piece3);
    }

    public void paint(Graphics g)
    {
        initTab(g);
        dispPiece(g);
    }
    public void initTab(Graphics g){
        g.setColor(Color.BLACK);
        //g.drawRect (10, 10, 200, 200);
        g.fillRect(tabX, tabY, tabW, tabL);
        //g.drawLine();
        g.setColor(Color.DARK_GRAY);

        g.setColor(Color.ORANGE);
        g.drawRect(tabX, tabY, tabW, tabL);
    }

    public void dispPiece(Graphics g){

        int newX = 0;

        if (list != null){
            for(GamePieces piece : list){

                int posX = -4 * tabCase + 10 + newX;

                for (Coord c : piece.getCoords()){
                    g.setColor(piece.getColor());
                    int x = posX + 1 + c.x * tabCase;
                    int y = tabY + 1 + c.y * tabCase + 10;
                    g.fillRect(x, y, tabCase - 1, tabCase - 1);

                    if (x + tabCase > newX){
                        newX = x + tabCase;
                    }
                }
            }
        }
    }
}
