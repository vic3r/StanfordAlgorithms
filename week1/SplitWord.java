import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SplitWord {

  public static boolean knapsack(int n,int max, int min) {
    if(n%min == 0 || n%max == 0)
      return true;
    while(n>=0) {
      n-=min;
      if(n < 0)
        return false;
      if(n%max == 0)
        return true;
    }
    return false;
  }

  public static void wCount(String word,int p, int q) {
    int max = p>q? p:q;
    int min = p<q? p:q;
    boolean isValid = knapsack(word.length(),max,min);
    if(!isValid) {
      System.out.println(-1);
      return;
    }
    StringBuilder builder = new StringBuilder(word);
    List<String> list = new ArrayList<>();
    while(builder.length() > 0) {
      if(builder.length() % p == 0) {
        list.add(builder.substring(0,p));
        builder.replace(0,p,"");
      }
      else if(builder.length() % q == 0) {
        list.add(builder.substring(0,q));
        builder.replace(0,q,"");
      }
      else {
        list.add(builder.substring(0,min));
        builder.replace(0,min,"");
      }
    }
    System.out.println(list.size());
    list.forEach((e) -> System.out.println(e));
  }
  
  public static void main(String []args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int p = in.nextInt();
    int q = in.nextInt();
    in.nextLine();
    String word = in.nextLine().trim();
    wCount(word, p, q);
    in.close();
  }
}
