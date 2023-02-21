package tetris_game.objects.pieces;

import tetris_game.objects.GamePieces;

import java.awt.*;
import java.util.ArrayList;

public class Piece_J extends GamePieces {

    public Piece_J(){
        setPos(new ArrayList<>(4));

        getCoords().add(new Coord(1,0));
        getCoords().add(new Coord(1,1));
        getCoords().add(new Coord(1,2));
        getCoords().add(new Coord(0,2));

        setCenter(getCoords().get(1));

        setColor(Color.ORANGE);

        setType(Type.J);
    }
}
