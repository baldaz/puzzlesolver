package puzzlesolver;

import java.rmi.*;
import java.rmi.server.*;

public class PuzzleServerController extends UnicastRemoteObject implements
IPuzzleServerController {

	/**
	 * Constructor
	 */

	public PuzzleServerController() throws RemoteException {}

	/**
	 * Sort a given puzzle by selecting a junction point near the middle of it
	 * and creating 2 thread that sort their respective part and merge them at
	 * the end of the process.
	 * @return sorted puzzle
	 * @throws RemoteException
	 */

	@Override
	public Puzzle sort(Puzzle model) throws RemoteException {
		int msize = model.size();
		int hsize = 0;
		// get the junction point
		if((msize % 2) == 0) {
			hsize = msize / 2;
		}
		else {
			hsize = (msize / 2) + 1;
		}
		// creating reference to shared object
		SharedSortStat shared = new SharedSortStat();
		// creating reference to sorting algorithm objects
		SortAlgFromBottom bot_sa = new SortAlgFromBottom(model, hsize, shared);
		SortAlgFromTop top_sa = new SortAlgFromTop(model, msize / 2, shared);
		// start sorting-from-top thread
		Thread top = new Thread(top_sa);
		// start sorting-from-bottom-thread
		Thread bot = new Thread(bot_sa);
		top.start();
		bot.start();
		try {
			top.join();
			bot.join();
		} catch(InterruptedException e) {
			System.err.println(e);
		}
		// get the resulted Vector of pieces (sorted) and merge it with the
		// second Vector of pieces.
		return model;
	}
}
