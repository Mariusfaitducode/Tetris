package tetris_game.objects;

import tetris_game.objects.pieces.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class ListPieces {

    private final List<GamePieces> list;

    public ListPieces(){
        list = new ArrayList<>(7);
        list.add(new Piece_I());
        list.add(new Piece_J());
        list.add(new Piece_L());
        list.add(new Piece_O());
        list.add(new Piece_S());
        list.add(new Piece_T());
        list.add(new Piece_Z());
    }

    public GamePieces initPiece(){
        GamePieces piece;

        piece = new GamePieces(rndPiece());

        for ( int i = 0; i<4; i++){
            for (Coord c : piece.getCoords()){
                c.x += 1;
            }
        }

        return piece;
    }

    public GamePieces rndPiece(){
        GamePieces piece;
        Random rnd = new Random();
        piece = new GamePieces(list.get(rnd.nextInt(list.size())));
        return piece;
    }

    public GamePieces getPiece(Type type){

        for (GamePieces piece : this.list){
            if ( piece.getType().equals(type)){
                return piece;
            }
        }
        return null;
    }

}
