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

    public void sort() {
        int msize = model.size();
        SortAlgFromBottom algb = new SortAlgFromBottom(model);
        SortAlgFromTop alg = new SortAlgFromTop(model, algb);
        SortAlg.setSize(msize);
        SortAlg.setHalfSize(msize / 2);
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
        // model.pieces().setSize(msize);
        System.out.println(alg.size());
    }

    public void display() {
        // view.printPuzzle(model);
        view.printPuzzleText(model);
    }
}