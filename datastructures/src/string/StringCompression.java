package string;

//https://www.geeksforgeeks.org/run-length-encoding/
//print the number of types a particular character appeared in that string. 
//For example - aabbbcc = a2b3c2
//https://practice.geeksforgeeks.org/problems/run-length-encoding/1
public class StringCompression {

	public String compressString(String str) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		int count = 0;
		while (i < str.length()) {
			char ch = str.charAt(i);
			count = 1;
			while (i < str.length() - 1 && ch == str.charAt(i + 1)) {
				count++;
				i++;
			}
			i++;
			result.append(ch);
			result.append(count);
		}
		return result.toString();
	}
}
