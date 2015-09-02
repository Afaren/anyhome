package test.states;

import java.util.Scanner;

//import com.sun.glass.ui.Size;

/**
 * @author : Chen
 * @fileName : enum.test.EnumTest.java
 * 
 * @date: Aug 30, 2015 11:49:10 PM
 * @user: Chen
 * @version:
 * @describe :
 * 
 */
public class EnumTest_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
		String input = in.next().toLowerCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size= " + size);
		System.out.println("abbreviation= " + size.getAbbreviation());
		if (size == Size.extra_large) {
			System.out.println("Good job--you paid attention to the _.");
		}
	}
}
