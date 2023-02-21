package tetris_game.objects.pieces;
import tetris_game.objects.GamePieces;

import java.awt.*;
import java.util.ArrayList;

public class Piece_I extends GamePieces {

    public Piece_I(){
        setPos(new ArrayList<>(4));

        getCoords().add(new Coord(0,0));
        getCoords().add(new Coord(0,1));
        getCoords().add(new Coord(0,2));
        getCoords().add(new Coord(0,3));

        setCenter(getCoords().get(1));

        setColor(Color.PINK);

        setType(Type.I);
    }
}