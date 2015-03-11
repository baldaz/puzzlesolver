package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;
import java.util.Collections;

public class SortAlgFromBottom extends SortAlg implements Runnable {

    private boolean suspend = true;
    private int jump;
    private Vector<Piece> result = new Vector<Piece>();

    public SortAlgFromBottom(Puzzle model, int size, int jmp) {
        super(model, size);
        jump = jmp;
    }

    public void setSuspend(boolean d) {
        suspend = d;
    }

    public Vector<Piece> result() {
        return result;
    }

    private Piece firstPiece() {
        Piece[] p = puzzle().pieces().toArray(new Piece[puzzle().pieces().size()]);
        for(int i = 0; i < puzzle().pieces().size(); ++i) {
            if(p[i].south().equals("VUOTO") && p[i].east().equals("VUOTO")) {
                subOne();
                return p[i];
            }
        }
        return null;
    }

    private Piece nextInRow(Piece p) {
        Piece[] pa = puzzle().pieces().toArray(new Piece[puzzle().pieces().size()]);
        for(int i = 0; i < puzzle().pieces().size(); ++i) {
            if(pa[i].id().equals(p.west())) {
                subOne();
                return pa[i];
            }
        }
        return null;
    }

    private Piece nextInCol(Piece p) {
        Piece[] pa = puzzle().pieces().toArray(new Piece[puzzle().pieces().size()]);
        for(int i = 0; i < puzzle().pieces().size(); ++i) {
            if(pa[i].id().equals(p.north())) {
                subOne();
                return pa[i];
            }
        }
        return null;
    }

    private Vector<Piece> sortRow(Piece p) {
        Vector<Piece> ret = new Vector<Piece>();
        ret.add(p);
        Piece nxt = nextInRow(p);
        while(nxt != null) {
            ret.add(nxt); // last
            nxt = nextInRow(nxt);
        }
        return ret;
    }

    public void sort() {
        Piece first = firstPiece(); // first piece
        Vector<Piece> row = new Vector<Piece>();
        while(size() > 0) {
            Vector<Piece> tmp = sortRow(first);
            row.addAll(tmp);
            first = nextInCol(tmp.firstElement());
            System.out.println("checkbottom");
        }
        Collections.reverse(row);
        result = row;
        System.out.println("FromBottom: " + row.size());
    }

    public void run() {
        sort();
    }
}