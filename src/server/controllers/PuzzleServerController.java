package puzzlesolver;

// This class will contain sorting logic of the puzzle
import java.util.Vector;
import java.rmi.*;
import java.rmi.server.*;

public class PuzzleServerController extends UnicastRemoteObject implements IPuzzleServerController {

    public PuzzleServerController() throws RemoteException {}

    public Puzzle sort(Puzzle model) throws RemoteException {
        int jump = 0;
        int msize = model.size();
        int hsize = 0;
        if((msize % 2) == 0) {
            hsize = msize / 2;
            jump = hsize;
        }
        else {
            hsize = (msize / 2) + 1;
            jump = hsize - 2;
        }
        SortAlgFromBottom botres = new SortAlgFromBottom(model, hsize);
        SortAlgFromTop topres = new SortAlgFromTop(model, msize / 2);
        Thread top = new Thread(topres);
        Thread bot = new Thread(botres);
        top.start();
        bot.start();
        try {
            top.join();
            bot.join();
        } catch(InterruptedException e) {
            System.err.println(e);
        }
        // model.pieces().setSize(msize);
        System.out.println(topres.size());
        System.out.println(botres.size());
        Vector<IPiece> end = topres.result();
        end.addAll(botres.result());
        model.setPieces(end);
        return model;
    }
}