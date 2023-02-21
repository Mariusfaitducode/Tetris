package tetris_game.objects.pieces;

import tetris_game.objects.GamePieces;

import java.awt.*;
import java.util.ArrayList;

public class Piece_T extends GamePieces {

    public Piece_T(){
        //super();
        setPos(new ArrayList<>(4));

        getCoords().add(new Coord(0,0));
        getCoords().add(new Coord(1,0));
        getCoords().add(new Coord(2,0));
        getCoords().add(new Coord(1,1));

        setCenter(getCoords().get(1));

        setColor(Color.GREEN);

        setType(Type.T);
    }
}
