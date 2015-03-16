package puzzlesolver;

public class PuzzleController implements IPuzzleController {

    private IPuzzleView view;

    public PuzzleController(IPuzzleView v) {
        view = v;
    }

    public void sort() {
        SortAlg alg = new SortAlgSeq(view.puzzle());
        alg.sort();
    }

    public void output() {
        view.outputPuzzle();
    }
}