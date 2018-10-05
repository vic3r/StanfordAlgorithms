import java.util.Scanner;

public class Points {
  private int x, y;

  public Points(int x, int y) {
    this.x = x;
    this.y = y; 
  }

  public static int determinant(int x1, int y1, int x2, int y2, int x3, int y3) {
    return (x1 *(y3 - y2)) + (x2 * (y3 -y1)) + (x3 * (y1 - y2));
  }

  public static int calculateTriangles(Points[] points) {
    int numberTriangles = 0;
    for (int i=0; i<points.length; i++) {
      for(int j= i+1; j<points.length; j++) {
        for(int k = j+1; k<points.length; k++) {
          if(determinant(points[i].x, points[i].y, points[j].x, points[j].y, points[k].x, points[k].y) != 0 ) {
            numberTriangles++;
          }
        }
      }
    }
    return numberTriangles;
  }
  
  public static void main(String []args) {
    Scanner in = new Scanner(System.in);
    int n  = in.nextInt();
    Points[] points = new Points[n];
    for (int i = 0; i<n; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      points[i] = new Points(x, y);
    }
    System.out.println(calculateTriangles(points));
    in.close();
  }
}
