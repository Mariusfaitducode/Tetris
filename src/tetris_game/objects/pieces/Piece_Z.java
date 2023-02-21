package tetris_game.objects.pieces;

import tetris_game.objects.GamePieces;

import java.awt.*;
import java.util.ArrayList;

public class Piece_Z extends GamePieces {

    public Piece_Z(){
        setPos(new ArrayList<>(4));

        getCoords().add(new Coord(0,0));
        getCoords().add(new Coord(1,0));
        getCoords().add(new Coord(1,1));
        getCoords().add(new Coord(2,1));

        setCenter(getCoords().get(1));

        setColor(Color.CYAN);

        setType(Type.Z);
    }
}
