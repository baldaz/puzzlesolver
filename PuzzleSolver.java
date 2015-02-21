public class PuzzleSolver {
  public static void main(String args[]) {
    Puzzle puzzle = new Puzzle();
    // ABC
    Piece p1 = new Piece("A1", "A", "VUOTO", "B1", "VUOTO", "VUOTO");
    Piece p2 = new Piece("B1", "B", "VUOTO", "C1", "VUOTO", "A1" );
    Piece p3 = new Piece("C1", "C", "VUOTO", "VUOTO", "VUOTO", "B1" );
    // Populate puzzle
    puzzle.addPiece(p1);
    puzzle.addPiece(p2);
    puzzle.addPiece(p3);
    // View, will save to file after controller operation of sorting
    PuzzleView view = new PuzzleView();
    PuzzleController controller = new PuzzleController(puzzle, view);
    controller.display();
    controller.sort();
    controller.display();
  }
}
