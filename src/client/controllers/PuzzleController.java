package puzzlesolver;

// This class will contain sorting logic of the puzzle
import java.util.Vector;
import java.rmi.*;

public class PuzzleController implements IPuzzleController {

    private Puzzle model;
    private IPuzzleView view;

    public PuzzleController(Puzzle m, IPuzzleView v) {
        model = m;
        view = v;
    }

    public void sort(String host) {
        try {
            IPuzzleServerController psc = (IPuzzleServerController) Naming.lookup("rmi://" + host + "/Resolve");
            model = psc.sort(model);
        }catch(ConnectException e) {
            System.out.println("Connection problems");
        }catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    public void display() {
        view.printPuzzleText(model);
        view.updatePuzzle(model);
        view.outputPuzzle();
    }
}