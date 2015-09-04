package puzzlesolver;

import java.rmi.*;

interface RemoteListener extends Remote {
	public void remoteEvent(Object param) throws RemoteException;
}
