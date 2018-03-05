
public class KaratsubaMultiplication {
	public static int makeEqualLength(String str1, String str2) {
	    int len1 = str1.length();
	    int len2 = str2.length();
	    if (len1 < len2) {
	        for (int i = 0; i < (len2 - len1); i++) {
	        	str1 = '0' + str1;
	        }
	        return len2;
	    }
	    else if (len1 > len2) {
	        for (int i = 0; i < (len1 - len2); i++)
	            str2 = '0' + str2;
	    }
	    return len1;
	}
}