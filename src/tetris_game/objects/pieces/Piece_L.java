package tetris_game.objects.pieces;
import tetris_game.objects.GamePieces;

import java.awt.*;
import java.util.ArrayList;

public class Piece_L extends GamePieces {

    public Piece_L(){
        setPos(new ArrayList<>(4));

        getCoords().add(new Coord(0,0));
        getCoords().add(new Coord(0,1));
        getCoords().add(new Coord(0,2));
        getCoords().add(new Coord(1,2));

        setCenter(getCoords().get(1));

        setColor(Color.MAGENTA);

        setType(Type.L);
    }
}

//Variantes fonctions
/*
    Piece_L(){
        setPos(new ArrayList<>(4));

        for (int y = 0; y < 3; y ++ ){
            getPos().add(new Coord(0,y));
        }
        getPos().add(new Coord(1,2));
        setCenter(getPos().get(1));
    }
    */