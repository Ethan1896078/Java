package pers.ethan.homework;

public class ShowByString implements PalindromeNumberShow {

	public void showPalindromeNumber(int endNumber) {
		for (int i = 0; i < endNumber; i++) {
			String str = String.valueOf(i);
			char[] charArray = str.toCharArray();
			int iLength = charArray.length;
			for (int j = 0; j < iLength; j++) {
				if (j >= iLength - 1 - j) {
					System.out.println(i);
					break;
				}
				if (charArray[j] != charArray[iLength -1 - j]) {
					break;
				}
			}
		}
	}

}
