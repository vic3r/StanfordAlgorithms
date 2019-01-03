import java.util.Scanner;

class Permutation {

  public static boolean isPermutation(String word1, String word2) {
    if (word1.length() != word2.length())
      return false;
    
    int[] charValues = new int[256];
    for(Character c: word1.toCharArray()) {
      charValues[c]++;
    }
    
    for(Character c: word2.toCharArray()) {
      charValues[c]--;
    }
    for(int i = 0; i<charValues.length; i++) {
      if (charValues[i] != 0) 
        return false;
    }
    
    return true;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String word1 = in.nextLine().trim();
    String word2 = in.nextLine().trim();
    System.out.println(isPermutation(word1, word2));
    in.close();
  }
}
