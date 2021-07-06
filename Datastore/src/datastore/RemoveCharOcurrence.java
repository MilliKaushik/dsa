package datastore;

public class RemoveCharOcurrence {

	public String removeOccurence(String str, char ch) {
		return removeOccurenceHelper(str, ch, 0, 1, str.length());
	}

	private String removeOccurenceHelper(String str, char ch, int currIndex, int counter, int size) {
		if (counter == size)
			return str;
		if (str.charAt(currIndex) == ch) {
			String substr1 = str.substring(0, currIndex);
			String subStr2 = str.substring(currIndex + 1, str.length());
			str = substr1 + subStr2;
		}
		return removeOccurenceHelper(str, ch, currIndex + 1, counter + 1, size);
	}
}
