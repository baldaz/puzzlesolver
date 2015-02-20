public class PieceController {

    private Piece model;
    private PieceView view;

    public PieceController(Piece m, PieceView v) {
        model = m;
        view = v;
    }

    public String north() {
        return model.north();
    }

    public String east() {
        return model.east();
    }

    public String south() {
        return model.south();
    }

    public String west() {
        return model.west();
    }

    public void display() {
        view.printPiece(model);
    }
}