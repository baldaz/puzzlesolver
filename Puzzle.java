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

    public Piece firstPiece() {
        Iterator<Piece> it = pieces.iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.north().equals("VUOTO") && ret.west().equals("VUOTO")) return ret;
        }
        return null;
    }

    public Piece findNext(Piece p)  {
        Iterator<Piece> it = pieces.iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.id())) return ret;
        }
        return null;
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