import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class KthNumber {

  public static boolean checkArr(int []arr, int k) {
    Set<Integer> mySet = new HashSet<>();
    for (Integer i: arr) {
      int diff = k - i;
      if(mySet.contains(k - diff)){
          return true;
      }
      mySet.add(diff);    
    }

    return false;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{10,15,3,7};
    int k = 17;
    System.out.println(checkArr(arr, k));
  }
}
