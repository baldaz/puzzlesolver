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
        SortAlgFromTop alg = new SortAlgFromTop(model);
        SortAlgFromBottom algb = new SortAlgFromBottom(model);
        Thread t = new Thread(alg);
        Thread t2 = new Thread(algb);
        t2.start();
        t.start();
        try {
            t.join();
            t2.join();
        } catch(InterruptedException e) {
            System.err.println(e);
        }
        System.out.println(alg.size());
    }

    public void display() {
        view.printPuzzle(model);
        view.printPuzzleText(model);
    }
}