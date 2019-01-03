import java.sql.Array;
import java.util.Arrays;

class Urlify{

  public static String modifyString(String word) {
    StringBuilder builder = new StringBuilder();
    boolean isChanged = false;
    for (Character ch: word.toCharArray()) {
      if(ch == ' ') {
        if (!isChanged) {
          builder.append("%20");
          isChanged = true;
        }
      } else {
        builder.append(ch);
        isChanged = false;
      }
    }
    return builder.toString();
  }
  
  public static void main(String[] args) {
    System.out.println(modifyString("John    is    weak   as fuck   "));
  }
}
