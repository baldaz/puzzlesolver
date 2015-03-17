package puzzlesolver;

/**
 * MVC Pattern piece model representing a piece of a text puzzle, formed by an ID, the character it represents, and nearby
 * pieces informations at his four cardinal points, provided with getters.
 */

public class Piece implements IPiece {

  private String id;
  private String ch;
  private String north;
  private String east;
  private String south;
  private String west;

  /**
   * Constructor
   * @param i ID of the piece.
   * @param c character the piece represent.
   * @param n local information of the piece at north of the current, represent his ID.
   * @param e local information of the piece at east of the current, represent his ID.
   * @param s local information of the piece at south of the current, represent his ID.
   * @param w local information of the piece at west of the current, represent his ID.
   */

  public Piece(String i, String c, String n, String e, String s, String w) {
    id = i;
    ch = c;
    north = n;
    east = e;
    south = s;
    west = w;
  }

  // getter method for ID

  public String id() {
    return id;
  }

  /**
   * Check if a given piece is the north piece of the current one
   * @param p piece of the puzzle that could be at north of the current one
   * @return returns true if the given piece p is at north of the current one, else false
   */

  public boolean northSide(IPiece p) {
    Piece pp = (Piece) p;
    return (pp.id().equals(north));
  }

  /**
   * Check if a given piece is the east piece of the current one
   * @param p piece of the puzzle that could be at east of the current one
   * @return returns true if the given piece p is at east of the current one, else false
   */

  public boolean eastSide(IPiece p) {
    Piece pp = (Piece) p;
    return (pp.id().equals(east));
  }

  /**
   * Check if a given piece is the south piece of the current one
   * @param p piece of the puzzle that could be at south of the current one
   * @return returns true if the given piece p is at south of the current one, else false
   */

  public boolean southSide(IPiece p) {
    Piece pp = (Piece) p;
    return (pp.id().equals(south));
  }

  /**
   * Check if a given piece is the west piece of the current one
   * @param p piece of the puzzle that could be at west of the current one
   * @return returns true if the given piece p is at west of the current one, else false
   */

  public boolean westSide(IPiece p) {
    Piece pp = (Piece) p;
    return (pp.id().equals(west));
  }

  /**
   * Check if the current piece has "VUOTO" on his north side
   * @return returns true if the current piece has "VUOTO" on his north side, otherwise returns false
   */

  public boolean northBorder() {
    return north.equals("VUOTO");
  }

  /**
   * Check if the current piece has "VUOTO" on his east side
   * @return returns true if the current piece has "VUOTO" on his east side, otherwise returns false
   */

  public boolean eastBorder() {
    return east.equals("VUOTO");
  }

  /**
   * Check if the current piece has "VUOTO" on his south side
   * @return returns true if the current piece has "VUOTO" on his south side, otherwise returns false
   */

  public boolean southBorder() {
    return south.equals("VUOTO");
  }

  /**
   * Check if the current piece has "VUOTO" on his west side
   * @return returns true if the current piece has "VUOTO" on his west side, otherwise returns false
   */

  public boolean westBorder() {
    return west.equals("VUOTO");
  }

  /**
   * toString override
   * @return returns the character that represent current piece
   */

  public String toString() {
    return ch;
  }

}
