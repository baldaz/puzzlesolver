package puzzlesolver;

import java.rmi.*;

public interface IPuzzleServerController extends Remote {
    public Puzzle sort(Puzzle model) throws RemoteException;
}