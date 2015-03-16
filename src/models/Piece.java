package puzzlesolver;

/**
 * MVC Pattern piece model representing a piece of a text puzzle, formed by an ID, the character it represents, and nearby
 * pieces informations at his four cardinal points, provided with getters.
 */

public class Piece {

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

  public Piece(String i, String c, String n, String e, String s, String w){
    id = i;
    ch = c;
    north = n;
    east = e;
    south = s;
    west = w;
  }

  public String id() {
    return id;
  }

  public String ch() {
    return ch;
  }

  public String north() {
    return north;
  }

  public String east() {
    return east;
  }

  public String south() {
    return south;
  }

  public String west() {
    return west;
  }
}
