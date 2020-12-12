import java.util.ArrayList;
public class Bag {
  private String name;
  private ArrayList<Bag> content;
  
  public Bag (String name) {
    this.name = name;
    content = new ArrayList<>();
  }
  
  public void addContent (Bag b) {
    content.add(b);
  }
  
  public void addContent (Bag b, int n) {
    for (int i = 0; i< n; i++) {
      content.add(b);
    }
  }
  
  
}