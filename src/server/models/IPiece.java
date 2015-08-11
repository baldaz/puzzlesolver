package puzzlesolver;

/**
 * MVC Pattern, Piece interface representing a generic piece of an ordinable puzzle
 */

public interface IPiece {

    // true if p is the north piece of the current piece

    public boolean northSide(IPiece p);

    // true if p is the east piece of the current piece

    public boolean eastSide(IPiece p);

    // true if p is the south piece of the current piece

    public boolean southSide(IPiece p);

    // true if p is the west piece of the current piece

    public boolean westSide(IPiece p);

    // true if current piece has "VUOTO" on the north side

    public boolean northBorder();

    // true if current piece has "VUOTO" on the east side

    public boolean eastBorder();

    // true if current piece has "VUOTO" on the south side

    public boolean southBorder();

    // true if current piece has "VUOTO" on the west side

    public boolean westBorder();

    // toString override

    public String toString();
}