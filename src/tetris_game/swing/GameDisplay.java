package tetris_game.swing;

import tetris_game.objects.Grid;
import tetris_game.objects.GamePieces;
import tetris_game.objects.ListPieces;
import tetris_game.objects.pieces.Coord;
import tetris_game.objects.pieces.Type;

import javax.swing.*;
import java.awt.*;

public class GameDisplay extends JPanel {

    public final int tabX = 80;
    public final int tabY = 80;
    public final int tabW = 300;
    public final int tabL = 600;

    public final int tabCase = 30;

    private Grid tab;
    private GamePieces piece;

    public GameDisplay(Grid grid, GamePieces piece){
        this.tab = grid;
        this.piece = piece;
    }
    public GameDisplay(){}

    public void setGrid(Grid grid){
        this.tab = grid;
    }
    public void setPiece(GamePieces piece){
        this.piece = piece;
    }

    public void paint(Graphics g)
    {
        initTab(g);
        dispTab(g);
        dispPiece(g);
    }
    public void initTab(Graphics g){
        g.setColor(Color.BLACK);
        //g.drawRect (10, 10, 200, 200);
        g.fillRect(tabX, tabY, tabW, tabL);
        //g.drawLine();
        g.setColor(Color.DARK_GRAY);

        for ( int i = 0; i <= tab.getWidth(); i++){
            int x = tabX + i * tabCase;
            int y1 = tabY;
            int y2 = y1 + tabL;
            g.drawLine(x, y1, x, y2);
        }
        for ( int i = 0; i <= tab.getLength(); i++){
            int x1 = tabX;
            int y = tabY + i * tabCase;
            int x2 = x1 + tabW;
            g.drawLine(x1, y, x2, y);
        }
        g.setColor(Color.ORANGE);
        g.drawRect(tabX, tabY, tabW, tabL);
    }
    public void dispTab(Graphics g){

        if (tab !=null){
            for ( int i = 0; i < tab.getLength(); i++){
                for ( int j = 0; j < tab.getWidth(); j++){

                    if ( !tab.getGrid()[i][j].equals(Type.EMPTY) ){

                        g.setColor(new ListPieces().getPiece(tab.getGrid()[i][j]).getColor());

                        int x = tabX + 1 + j * tabCase;
                        int y = tabY + 1 + i * tabCase;
                        g.fillRect(x, y, tabCase - 1, tabCase - 1);
                    }
                }
            }
        }
    }
    public void dispPiece(Graphics g){

        if (piece!=null){
            for (Coord c : piece.getCoords()){
                g.setColor(piece.getColor());
                int x = tabX + 1 + c.x * tabCase;
                int y = tabY + 1 + c.y * tabCase;
                g.fillRect(x, y, tabCase - 1, tabCase - 1);
            }
        }
    }
}



/*
public class DrawRectangle
{
    public static void main(String[] a)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 300, 300);
        window.getContentPane().add(new MyCanvas());
        window.setVisible(true);
    }
}*/
