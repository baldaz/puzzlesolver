package puzzlesolver;

// This class will contain sorting logic of the puzzle
import java.util.Vector;
import java.rmi.*;
import java.rmi.server.*;

public class PuzzleServerController extends UnicastRemoteObject implements
IPuzzleServerController {

	/**
	 * Constructor
	 */

	public PuzzleServerController() throws RemoteException {}

	/**
	 * @override
	 * Sort a given puzzle by selecting a junction point near the middle of it
	 * and creating 2 thread that sort their respective part and merge them at
	 * the end of the process.
	 * @return sorted puzzle
	 * @throws RemoteException
	 */

	public Puzzle sort(Puzzle model) throws RemoteException {
		/* int jump = 0; */
		int msize = model.size();
		int hsize = 0;
		// get the junction point
		if((msize % 2) == 0) {
			hsize = msize / 2;
			/* jump = hsize; */
		}
		else {
			hsize = (msize / 2) + 1;
			/* jump = hsize - 2; */
		}
		// creating reference to sorting algorithm objects
		SortAlgFromBottom botres = new SortAlgFromBottom(model, hsize);
		SortAlgFromTop topres = new SortAlgFromTop(model, msize / 2);
		// start sorting-from-top thread
		Thread top = new Thread(topres);
		// start sorting-from-bottom-thread
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
		// get the resulted Vector of pieces (sorted) and merge it with the
		// second Vector of pieces.
		Vector<IPiece> end = topres.result();
		end.addAll(botres.result());
		model.setPieces(end);
		return model;
	}
}
