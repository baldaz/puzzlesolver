public class Piece {

  private String id;
  private String north;
  private String east;
  private String south;
  private String west;

  public Piece(String i, String n, String e, String s, String w){
    id = i;
    north = n;
    east = e;
    south = s;
    west = w;
  }

  public String id() {
    return id;
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

  public String toString() {
    return id + " " + north + " " + east + " " + south + " " + west;
  }
}
