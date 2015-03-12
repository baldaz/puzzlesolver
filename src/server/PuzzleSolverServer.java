import puzzlesolver.*;
import java.rmi.*;

public class PuzzleSolverServer {
    private static final String HOST = "localhost";

    public static void main(String args[]) throws Exception {
        String host = args[0];
        String rmiObjName = "rmi://" + HOST + "/" + host+ "/Resolve";
        IPuzzleServerController contRef = new PuzzleServerController();
        Naming.rebind(rmiObjName, contRef);
        System.out.println("Server ready");
    }
}
