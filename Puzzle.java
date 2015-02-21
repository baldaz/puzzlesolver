import java.util.Vector;
import java.util.Iterator;

public class Puzzle {

    private Vector<Piece> pieces;

    public Puzzle() {
        pieces = new Vector<Piece>();
    }

    public void addPiece(Piece p) {
        pieces.add(p);
    }

    public void sort() {

    }

    public String toString() {
        String ret = "Puzzle pieces:\n";
        Iterator it = pieces.iterator();
        while(it.hasNext())
            ret += it.next().toString() + "\n";
        return ret;
    }
}