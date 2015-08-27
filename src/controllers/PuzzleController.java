package puzzlesolver;

import java.util.Vector;

/**
 * Controller class, implementation of IPuzzleController interface.
 */

public class PuzzleController implements IPuzzleController {

    private IPuzzleView view;

    /**
     * Constructor
     * @param v IPuzzleView type representing a puzzle view, provides input and output features.
     */

    public PuzzleController(IPuzzleView v) {
        view = v;
    }

    /**
	 * @override
     * Sorting method, sorts the puzzle using SortAlg type object.
     */

    public void sort() {
        int m_size = view.puzzle().size();
        int h_size = 0;
        if((m_size % 2) == 0) {
            h_size = m_size / 2;
        }
        else {
            h_size = (m_size / 2) + 1;
        }
        SortAlgFromBottom bot_sa = new SortAlgFromBottom(view.puzzle(), h_size);
        SortAlgFromTop top_sa = new SortAlgFromTop(view.puzzle(), m_size / 2);
        Thread top = new Thread(top_sa);
        Thread bot = new Thread(bot_sa);
        top.start();
        bot.start();
        try {
            top.join();
            bot.join();
        } catch(InterruptedException e) {
            System.err.println(e);
        }
        System.out.println(top_sa.size());
        System.out.println(bot_sa.size());
        Vector<IPiece> end = top_sa.result();
        end.addAll(bot_sa.result());
        view.puzzle().setPieces(end);
    }

    /**
	 * @override
     * Output sorted puzzle to the view.
     */

    public void output() {
        view.outputPuzzle();
    }
}
