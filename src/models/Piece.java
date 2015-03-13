package puzzlesolver;

public class Piece implements IPiece {

  private String id;
  private String ch;
  private String north;
  private String east;
  private String south;
  private String west;

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
