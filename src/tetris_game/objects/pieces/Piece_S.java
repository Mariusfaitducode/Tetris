package tetris_game.objects.pieces;

import tetris_game.objects.GamePieces;

import java.awt.*;
import java.util.ArrayList;

public class Piece_S extends GamePieces {

    public Piece_S(){
        setPos(new ArrayList<>(4));

        getCoords().add(new Coord(2,0));
        getCoords().add(new Coord(1,0));
        getCoords().add(new Coord(1,1));
        getCoords().add(new Coord(0,1));

        setCenter(getCoords().get(1));

        setColor(Color.LIGHT_GRAY);

        setType(Type.S);
    }
}
