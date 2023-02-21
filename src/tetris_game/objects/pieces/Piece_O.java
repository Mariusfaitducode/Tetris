package tetris_game.objects.pieces;

import tetris_game.objects.GamePieces;

import java.awt.*;
import java.util.ArrayList;

public class Piece_O extends GamePieces {

    public Piece_O(){
        setPos(new ArrayList<>(4));

        getCoords().add(new Coord(0,0));
        getCoords().add(new Coord(1,0));
        getCoords().add(new Coord(0,1));
        getCoords().add(new Coord(1,1));

        setCenter(null);

        setColor(Color.RED);

        setType(Type.O);
    }
}
