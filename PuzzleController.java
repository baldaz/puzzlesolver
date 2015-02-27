// This class will contain sorting logic of the puzzle
import java.util.Vector;
import java.util.Iterator;

public class PuzzleController {

    private Puzzle model;
    private PuzzleView view;

    public PuzzleController(Puzzle m, PuzzleView v) {
        model = m;
        view = v;
    }

    public void sort() {
        boolean loop = true;
        Piece first = firstPiece();
        Vector<Piece> row = sortRow(first);
        Piece tmp = find(row.firstElement().south());
        while(loop) {
            Vector<Piece> rowtmp = sortRow(tmp);
            row.addAll(rowtmp);
            if(tmp.south().equals("VUOTO")) loop = false;
            else tmp = find(tmp.south());
        }
        model.setPieces(row);
    }

    public void display() {
        view.printPuzzle(model);
        view.printPuzzleText(model);
    }

    /**
    * private methods to sort
    **/

    private Piece firstPiece() {
        Iterator<Piece> it = model.pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.north().equals("VUOTO") && ret.west().equals("VUOTO")) return ret;
        }
        return null;
    }

    private Piece find(String id) {
        Iterator<Piece> it = model.pieces().iterator();
        while(it.hasNext()) {
            Piece p = it.next();
            if(p.id() == id) return p;
        }
        return null;
    }

    private Piece findNext(Piece p)  {
        Iterator<Piece> it = model.pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.east())) return ret;
        }
        return null;
    }

    private Vector<Piece> sortRow(Piece first) {
        Vector<Piece> ret = new Vector<Piece>();
        ret.add(first);
        Piece nxt = find(first.east());
        while(nxt != null) {
            ret.add(nxt);
            nxt = findNext(nxt);
        }
        return ret;
    }
}