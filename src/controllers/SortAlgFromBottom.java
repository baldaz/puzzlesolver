package puzzlesolver;

import java.util.Vector;
import java.util.Iterator;
import java.util.Collections;

public class SortAlgFromBottom extends SortAlg implements Runnable {

    private boolean suspend = true;
    private int jump;

    public SortAlgFromBottom(Puzzle model, int size, int jmp) {
        super(model, size);
        jump = jmp;
    }

    public void setSuspend(boolean d) {
        suspend = d;
    }

    private Piece firstPiece() {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.south().equals("VUOTO") && ret.east().equals("VUOTO")) {
                size--;
                return ret;
            }
        }
        return null;
    }

    private Piece nextInRow(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.west())) {
                size--;
                return ret;
            }
        }
        return null;
    }

    private Piece nextInCol(Piece p) {
        Iterator<Piece> it = puzzle().pieces().iterator();
        while(it.hasNext()) {
            Piece ret = it.next();
            if(ret.id().equals(p.north())) {
                size--;
                return ret;
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
        synchronized(puzzle()) {
            while(size > 0) {
                Vector<Piece> tmp = sortRow(first);
                row.addAll(tmp);
                first = nextInCol(tmp.firstElement());
                System.out.println("checkbottom");
            }
            Collections.reverse(row);
            while(suspend) {
                try {
                    puzzle().wait();
                } catch(InterruptedException e) {
                    System.err.println(e);
                }
            }
            puzzle().pieces().addAll(jump, row);
        }
        System.out.println("FromBottom: " + row.size());
    }

    public void run() {
        sort();
    }
}