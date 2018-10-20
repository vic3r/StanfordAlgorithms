import java.util.Arrays;

public class WiggleSort{

  public static int[] wiggleSort(int[] arr) {
    Arrays.sort(arr);
    for(int i = 1; i< arr.length; i+=2){
      int tempNext = arr[i];
      arr[i] = arr[i+1];
      arr[i+1] = tempNext;
    }

    return arr;
  }
  public static void main(String[] args) {
      int[] wiggleArr = wiggleSort(new int[]{2,3,4,0,9});
      for (int element: wiggleArr) {
        System.out.print(element+" ");
      }
  }
}
