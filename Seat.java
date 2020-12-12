public class Seat {
  private int rows;
  private int cols;
  private String code;
  private int id;
  
  public Seat(String str) {
    this.code = str;
    String brows = str.substring(0,7);
    String bcols = str.substring(7);
    int br = 0;
    int bc = 0;
    for (int i = 0; i < brows.length(); i++){
      br += (brows.charAt(brows.length()-i-1)=='B'?1:0)* (int)Math.pow(2,i);
    }
    for(int i = 0; i < bcols.length(); i++){
      bc += (bcols.charAt(bcols.length()-i-1)=='R'?1:0)* (int)Math.pow(2,i);
    }
    this.rows = br;
    this.cols = bc;
    this.id = (rows * 8) + cols;
  }
  
  public String toString() {
    String st = "";
    st += code + " rows : " + this.rows + " cols : " + this.cols + " seat id : " + this.id;
    return st;
  }
  
}