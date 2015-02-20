public class PieceTest {
  public static void main(String args[]) {
    Piece model = new Piece("A1", "B2", "C1", "D2", "_1");
    PieceView view = new PieceView();
    PieceController controller = new PieceController(model, view);
    controller.display();
  }
}
