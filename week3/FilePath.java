public class FilePath {
  
  public static int longestFilePath(String filePath) {
    int maxLength = 0; // if there are no files we must return 0
    String[] files = filePath.split("\n"); // Separate our files after every space
    int[] dirsLength = new int[files.length +1]; // We need to have n+1 levels to avoid a possible out of bounds exception
    dirsLength[0] = 0; // Initiate in 0 len

    for (String file:files) {
      int fileLevel = file.lastIndexOf("\t") + 1; // #t's -1 becasuse it begins in 0, if there is no '\t' we add + 1 to have 0 as our level (main level)
      int actualLength = (dirsLength[fileLevel] + file.length() - fileLevel) +1; // the actual directory + len(actual file word) - #'/t's + '/' at the end
      dirsLength[fileLevel +1 ] = actualLength; // this length will be modified after the directory is closed and we have moved to the next one
      if (file.contains(".")) maxLength = Math.max(maxLength,actualLength-1); // -1 because is a file and a file does not have '/' at the end
    }
    return maxLength;
  }
  
  public static void main(String[] args) {
    System.out.println(longestFilePath( "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
  }
}
