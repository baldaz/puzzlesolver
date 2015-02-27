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

    public Vector<Piece> pieces() {
        return pieces;
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

    public Vector<Piece> sortRow(Piece first) {
        Vector<Piece> ret = new Vector<Piece>();
        ret.add(first);
        Piece nxt = find(first.east());
        while(nxt != null) {
            ret.add(nxt);
            nxt = findNext(nxt);
        }
        return ret;
    }

    public void sort() {
        Piece first = firstPiece();
        Vector<Piece> row = sortRow(first);
        Piece tmp = find(row.firstElement().south());
        for(int i = 0; i < 2; ++i) {
            Vector<Piece> rowtmp = sortRow(tmp);
            row.addAll(rowtmp);
            tmp = find(tmp.south());
        }
        pieces = row;
    }

    public String toString() {
        String ret = "Puzzle pieces:\n";
        Iterator it = pieces.iterator();
        while(it.hasNext())
            ret += it.next().toString() + "\n";
        return ret;
    }
}