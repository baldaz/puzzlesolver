package puzzlesolver;

// This class will contain sorting logic of the puzzle
import java.util.Vector;

public class PuzzleController implements IPuzzleController {
    private IPuzzleView view;

    public PuzzleController(IPuzzleView v) {
        view = v;
    }

    public void sort() {
        int jump = 0;
        int msize = view.puzzle().size();
        int hsize = 0;
        if((msize % 2) == 0) {
            hsize = msize / 2;
            jump = hsize;
        }
        else {
            hsize = (msize / 2) + 1;
            jump = hsize - 2;
        }
        SortAlgFromBottom algb = new SortAlgFromBottom(view.puzzle(), hsize);
        SortAlgFromTop alg = new SortAlgFromTop(view.puzzle(), msize / 2);
        Thread top = new Thread(alg);
        Thread bot = new Thread(algb);
        top.start();
        bot.start();
        try {
            top.join();
            bot.join();
        } catch(InterruptedException e) {
            System.err.println(e);
        }
        System.out.println(alg.size());
        System.out.println(algb.size());
        Vector<Piece> end = alg.result();
        end.addAll(algb.result());
        view.puzzle().setPieces(end);
    }

    public void display() {
        view.printPuzzleText(view.puzzle());
        view.outputPuzzle();
    }
}