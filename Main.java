import java.util.ArrayList;
import java.io.*;
class Main {
  public static int round = 1;
  public static void main(String[] args) throws IOException, FileNotFoundException {
    
    
    String fname = "AiC.txt";
    
    File file = new File(fname);

    BufferedReader br = new BufferedReader(new FileReader(file)); 
    
    
  String st;
  String text = "";
  while ((st = br.readLine()) != null) {
  text += st + "\n";

  } 
    
    
    String[] inpArr = text.split("\n");
    char[][] seats = new char[inpArr.length][inpArr[0].length()];
    for (int i = 0; i < inpArr.length; i++){
      for (int j = 0; j < inpArr[0].length();j++) {
        seats[i][j] = inpArr[i].charAt(j);
      }
    }
    int totalSeats = seats.length * seats[0].length;
    //printMap(seats);
    while(true){
      seats = nextRound(seats);
      round++;
      //printMap(seats);
      if(round==5000) break;
    }
    
    int occup = seatsOcc(seats);
    int frees = seatsFree(seats);
    System.out.println("Seats occupied : " + occup + " - " + ((double)((double)occup / (double)totalSeats)* 100) +"%");
    System.out.println("Seats free : " + frees + " - " + ((double)((double)frees/(double)totalSeats)*100)+ "%");
  }
  
  public static void printMap(char[][] m) {
    System.out.println("Round " + round);
    for (int i=0;i<m.length;i++){
      for (int j=0;j<m[0].length;j++){
        System.out.print(m[i][j]+(j==m[0].length-1?"\n":""));
      } 
    }
  }
  
  public static char[][] nextRound(char[][] s1){
    char[][] copym = cloneMap(s1);
    
    for (int i=0;i<s1.length;i++){
      for (int j=0;j<s1[0].length;j++){
        if (s1[i][j]=='L' && countOccSeats(s1, i, j)==0) copym[i][j]='#';
        if (s1[i][j]=='#' && (countOccSeats(s1, i, j)>3 )) copym[i][j]='L';
      } 
    }
    return copym;
  }
  
  public static int countOccSeats(char[][] s, int r, int c) {
    int count=0;
    int rows = s.length;
    int cols = s[0].length;
    char[][] big = new char[rows + 2][cols + 2];
    //make bigger map 
    for (int i=0;i<rows+2;i++){
      for (int j=0;j<cols+2;j++){
        big[i][j]='.';
      } 
    }
    //put smaller map inside
    for (int i=1;i<rows+1;i++){
      for (int j=1;j<cols+1;j++){
        big[i][j]=s[i-1][j-1];
      } 
    }
    
    //count occupied seats
    // attention ! 0, 0 is 1,1 in the bigger map 
    r++;
    c++;
    for(int i=0;i<3;i++){
      for(int j=0;j<3;j++){
        if (!(i==1 && j==1)){
          if (big[r-1+i][c-1+j]=='#') count++;
        }
      }
    }
    return count;
  }
  
  public static boolean allSeatsOcc(char[][] s){
    for (int i=0;i<s.length;i++){
      for (int j=0;j<s[0].length;j++){
        if(s[i][j]=='L') return false;
      } 
    }
    return true;
  }
  
  public static char[][] cloneMap(char[][] m1){
    char[][] m1c = new char[m1.length][m1[0].length];
    for (int i=0;i<m1.length;i++){
      for (int j=0;j<m1[0].length;j++){
        m1c[i][j]=m1[i][j];
      } 
    }
    return m1c;
  }
  
  public static int seatsOcc(char[][] m) {
    int count = 0;
     for (int i=0;i<m.length;i++){
      for (int j=0;j<m[0].length;j++){
        if(m[i][j]=='#') count++;
      } 
    }
    return count;
  }
  
  public static int seatsFree(char[][] m) {
    int count = 0;
     for (int i=0;i<m.length;i++){
      for (int j=0;j<m[0].length;j++){
        if(m[i][j]=='L') count++;
      } 
    }
    return count;
  }
}