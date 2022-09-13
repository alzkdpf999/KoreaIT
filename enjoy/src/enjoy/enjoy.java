package enjoy;

import java.util.Arrays;

public class enjoy {

	public static void main(String[] args) {
		String[] beer = { "Kloud", "Cass", "Asahi", "Guinness", "Heineken" };
		String[] num = Arrays.copyOfRange(beer, 1, 2);
		for(int i =0; i<num.length; i++) {
			System.out.println(num[i]);			
		}

	}
}
