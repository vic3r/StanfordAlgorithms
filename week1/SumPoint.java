import java.util.Scanner;
import org.w3c.dom.Text;

public class SumPoint{

  public static String sumStrings(String left, String right) {
    if (left.equals(""))
      return right;
    if (right.equals(""))
      return left;

    StringBuilder result = new StringBuilder();
    String[] leftValues = left.split("\\.");
    for (String s: leftValues) {
      System.out.println(s);
    }
    String[] rightValues = right.split("\\.");

    int max = 0;
    boolean hasMantissa = true;
    if(leftValues.length == rightValues.length && leftValues.length == 1) {
      hasMantissa = false;
      max = leftValues[leftValues.length-1].length();
    }
    else if (leftValues.length> rightValues.length)
      max = leftValues[leftValues.length-1].length();
    else if (rightValues.length> rightValues.length)
      max = rightValues[rightValues.length-1].length();
    else
      max = leftValues[leftValues.length-1].length() >= rightValues[rightValues.length-1].length()? leftValues[leftValues.length-1].length() : rightValues[rightValues.length-1].length();
    
    int next = 0, temp = 0;
    for(int i = max-1; i>=0; i--) {
      if(rightValues[rightValues.length-1].charAt(i) != '\u0000') {
        temp = (int) leftValues[leftValues.length-1].charAt(i) + (int) rightValues[rightValues.length-1].charAt(i) + next;
        next = 0;
        if(temp >= 10) { 
          result.append(temp%10); 
          next = 1;
        }
      }
      else {
       temp = (int)leftValues[leftValues.length-1].charAt(i) + next;
       if(temp >= 10) { 
          result.append(temp%10); 
          next = 1;
        } else {
          result.append(temp);
          next = 0;
        }
      }
    }

    if(hasMantissa) {
      max = leftValues[0].length() >= rightValues[0].length()? leftValues[0].length() : rightValues[0].length();
      result.append(".");
     
      for(int i = max-1; i>=0; i--) {
        if(rightValues[0].charAt(i) != '\u0000') {
          temp = (int) leftValues[0].charAt(i) + (int) rightValues[0].charAt(i) + next;
          next = 0;
          if(temp >= 10) { 
            result.append(temp%10); 
            next = 1;
          }
        }
        else {
          temp = (int)leftValues[0].charAt(i) + next;
          if(temp >= 10) { 
            result.append(temp%10); 
            next = 1;
          } else {
            result.append(temp);
            next = 0;
          }
        }
      }
    }

    return result.reverse().toString();
  }

  public static void main(String []args) {
    Scanner in = new Scanner(System.in);
    String leftVal = in.nextLine().trim();
    String rightVal = in.nextLine().trim();
    System.out.println(sumStrings(leftVal, rightVal));
    in.close();
  }
}
