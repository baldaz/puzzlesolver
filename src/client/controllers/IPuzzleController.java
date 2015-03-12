package puzzlesolver;

import java.rmi.*;

public interface IPuzzleController {
    // sorting method
    public void sort(String host);
    // display method
    public void display();
}