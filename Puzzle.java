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

    public Piece find(String id) {
        Iterator<Piece> it = pieces.iterator();
        while(it.hasNext()) {
            Piece p = it.next();
            if(p.id() == id) return p;
        }
        return null;
    }

    public Piece findNext(Piece p)  {
        Iterator<Piece> it = pieces.iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.east())) return ret;
        }
        return null;
    }

    public Piece findNextInCol(Piece p) {
        Iterator<Piece> it = pieces.iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.south())) return ret;
        }
        return null;
    }

    public void sort() {
        Vector<Piece> ret = new Vector<Piece>();
        Piece first = firstPiece();
        ret.add(first);
        Piece nxt = find(first.east());
        while(nxt != null) {
            ret.add(nxt);
            nxt = findNext(nxt);
        }
        Vector<Piece> ret2 = new Vector<Piece>();
        Iterator<Piece> it = ret.iterator();
        while(it.hasNext()) {
            nxt = findNextInCol(it.next());
            while(nxt != null) {
                ret2.add(nxt);
                nxt = findNextInCol(nxt);
            }
        }
        ret.addAll(ret2);
        pieces = ret;
    }

    public String toString() {
        String ret = "Puzzle pieces:\n";
        Iterator it = pieces.iterator();
        while(it.hasNext())
            ret += it.next().toString() + "\n";
        return ret;
    }
}