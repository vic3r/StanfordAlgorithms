import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Uber {

  public static int[] traverseArray(int[] arr) {
    int total = 1;
    for(Integer i: arr) {
     total *=i;
    }

    for(int i = 0; i < arr.length; i++) {
      arr[i] =  (int)(total *Math.pow(arr[i], -1));  
    }

    return arr;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5};
    arr = traverseArray(arr);
    for(Integer i: arr) {
      System.out.print(i+ " ");
    }
  }
}
