public class CodeLine {
  private String instr;
  private int instr2;
  private boolean firstTime= true;
  public static int accum = 0;
  
  public CodeLine (String st) {
    this.instr = st.substring(0,3);
    this.instr2 = Integer.parseInt(st.substring(5));
    if (st.charAt(4)=='-') this.instr2 *= -1;
  }
  
  public String getInstr() {
    return this.instr;
  }
  
  public int getInstr2() {
    return this.instr2;
  }
  
  public String toString() {
    String s = "";
    s += this.instr + " " + this.instr2;
    return s;
  }
}