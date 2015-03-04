package puzzlesolver;

// This class will contain sorting logic of the puzzle
import java.util.Vector;
import java.util.Iterator;

public class PuzzleController implements IPuzzleController {

    private Puzzle model;
    private IPuzzleView view;

    public PuzzleController(Puzzle m, IPuzzleView v) {
        model = m;
        view = v;
    }

    // public void sort() {
    //     boolean loop = true;
    //     Piece first = firstPiece(); // first piece
    //     Vector<Piece> row = sortRow(first); // first row
    //     Piece tmp = nextInCol(row.firstElement()); // first column
    //     while(loop) {
    //         Vector<Piece> rowtmp = sortRow(tmp);
    //         row.addAll(rowtmp);
    //         if(tmp.south().equals("VUOTO")) loop = false;
    //         else tmp = nextInCol(tmp);
    //     }
    //     model.setPieces(row);
    // }
    public void sort() {
        boolean loop = true;
        SortAlg alg = new SortAlgSeq(model);
        Piece first = alg.firstPiece(); // first piece
        Vector<Piece> row = alg.sortRow(first); // first row
        Piece tmp = alg.nextInCol(row.firstElement()); // first column
        while(loop) {
            Vector<Piece> rowtmp = alg.sortRow(tmp);
            row.addAll(rowtmp);
            if(tmp.south().equals("VUOTO")) loop = false;
            else tmp = alg.nextInCol(tmp);
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

    // private Piece firstPiece() {
    //     Iterator<Piece> it = model.pieces().iterator();
    //     while(it.hasNext()) {
    //         Piece ret = it.next();
    //         if(ret.north().equals("VUOTO") && ret.west().equals("VUOTO")) return ret;
    //     }
    //     return null;
    // }

    // private Piece nextInCol(Piece p) {
    //     Iterator<Piece> it = model.pieces().iterator();
    //     while(it.hasNext()) {
    //         Piece ret = it.next();
    //         if(ret.id().equals(p.south())) return ret;
    //     }
    //     return null;
    // }

    // private Piece nextInRow(Piece p)  {
    //     Iterator<Piece> it = model.pieces().iterator();
    //     while(it.hasNext()) {
    //         Piece ret = it.next();
    //         if(ret.id().equals(p.east())) return ret;
    //     }
    //     return null;
    // }

    // private Vector<Piece> sortRow(Piece first) {
    //     Vector<Piece> ret = new Vector<Piece>();
    //     ret.add(first);
    //     Piece nxt = nextInRow(first);
    //     while(nxt != null) {
    //         ret.add(nxt);
    //         nxt = nextInRow(nxt);
    //     }
    //     return ret;
    // }
}