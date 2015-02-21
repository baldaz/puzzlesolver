// This class will contain sorting logic of the puzzle

public class PuzzleController {

    private Puzzle model;
    private PuzzleView view;

    public PuzzleController(Puzzle m, PuzzleView v) {
        model = m;
        view = v;
    }

    public void sort() {
        Puzzle ret = new Puzzle();
        ret.addPiece(model.firstPiece());
        model = ret;
    }

    public void display() {
        view.printPuzzle(model);
    }

}