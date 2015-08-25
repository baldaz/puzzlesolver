package puzzlesolver;

import java.rmi.*;

public interface IPuzzleServerController extends Remote {
	// remote sorting method
    public Puzzle sort(Puzzle model) throws RemoteException;
}
