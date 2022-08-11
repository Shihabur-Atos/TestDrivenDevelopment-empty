package com.qa.testdrivendevelopment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Questions {

	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		return "Hi " + name;
	}

	/**
	 * Given a string, return a string where for every char in the original string,
	 * there are three chars.<br>
	 * <br>
	 * 
	 * For Example:<br>
	 * multChar("The") → "TTThhheee"<br>
	 * multChar("AAbb") → "AAAAAAbbbbbb"<br>
	 * multChar("Hi-There") → "HHHiii---TTThhheeerrreee"
	 */
	public String multiChar(String input) {
		StringBuilder result = new StringBuilder();
		char[] chars = input.toCharArray();
		for(int i = 0; i < input.length(); i++) {
			for(int n = 0; n < 3; n++) {
				result.append(chars[i]);
			}
		}
		return result.toString();
	}

	/**
	 * Return the string (backwards) that is between the first and last appearance
	 * of "bread" in the given string, or return the empty string "" if there is not
	 * 2 occurances of "bread". Ignore Case<br>
	 * <br>
	 * For Example: sandwichFilling("breadclivebread") → "evilc"<br>
	 * sandwichFilling("xxbreadfridgebreadyy") → "egdirf"<br>
	 * sandwichFilling("xxBreadfridgeBReAdyy") → "egdirf"<br>
	 * sandwichFilling("xxbreadyy") → "" sandwichFilling("xxbreADyy") → ""<br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */

	public String sandwichFilling(String sandwich) {
		final String POINT = "bread";
		sandwich = sandwich.toLowerCase();
		StringBuilder output = new StringBuilder();

		if(sandwich.contains(POINT)) {
			sandwich = sandwich.substring(sandwich.indexOf(POINT), sandwich.lastIndexOf(POINT))
						.replaceAll(POINT,"");
			for(int i = sandwich.length() - 1; i >= 0; i--) {
				output.append(sandwich.charAt(i));
			}
			return output.toString();
		}
		return "";
	}

	/**
	 * Given three ints, a b c, one of them is small, one is medium and one is
	 * large. Return true if the three values are evenly spaced, so the difference
	 * between small and medium is the same as the difference between medium and
	 * large. Do not assume the ints will come to you in a reasonable order.<br>
	 * <br>
	 * For Example:<br>
	 * evenlySpaced(2, 4, 6) → true<br>
	 * evenlySpaced(4, 6, 2) → true<br>
	 * evenlySpaced(4, 6, 3) → false<br>
	 * evenlySpaced(4, 60, 9) → false
	 */
	public boolean evenlySpaced(int a, int b, int c) {
		int[] arr = {a, b, c};
		Arrays.sort(arr);
		return arr[2] - arr[1] == arr[1] - arr[0];
	}

	/**
	 * Given a string and an int n, return a string that removes n letters from
	 * the'middle' of the string. The string length will be at least n. The input
	 * string will have an odd number of letters. n will always be an odd
	 * number.<br>
	 * <br>
	 * For Example:<br>
	 * nMid("Hello", 3) → "Ho"<br> 5 / 2 = 2.5
	 * nMid("Chocolate", 3) → "Choate"<br>
	 * nMid("Chocolate", 1) → "Choclate"<br>
	 */

	public String nMid(String input, int n) {
		// 0 1 2 3 4 5 6 7 8
		// c h o c o l a t e
		StringBuilder builder = new StringBuilder(input);
		for(int i = 0; i < n; i++) {
			int mid = builder.length() / 2;
			builder.deleteCharAt(mid);
		}
		return builder.toString();
	}


	/**
	 * Given a string, return the boolean True if it ends in "java" and False if
	 * does not end in "java". Ignore Case.<br>
	 * <br>
	 * For Example: <br>
	 * endsJava("ilovejava") → true <br>
	 * endsJava("iloveJaVa") → true <br>
	 * endsJava("welovejava") → true <br>
	 * endsJava("welovejavamoreeveryday") → false <br>
	 * endsJava("javaiscool") → false <br>
	 * endsJava("pythoniscool") → false <br>
	 */

	public boolean endsJava(String input) {
		input = input.toLowerCase();
		return input.endsWith("java");
	}

	/**
	 * Given a string, return the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same, do not ignore case.<br>
	 * <br>
	 * For Example: superBlock("hooopplla") → 3 <br>
	 * superBlock("abbCCCddDDDDeeEEE") → 4 <br>
	 * superBlock("abbCCCCC")) → 5 <br>
	 * superBlock("") → 0 <br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */
	public int superBlock(String input) {
		int count = 0;
		ArrayList<Integer> counts = new ArrayList<>();
		if(input.isEmpty()) {
			return 0;
		}
		for(int i = 0; i < input.length(); i++) {
			if(i+1 > input.length() - 1) {
				counts.add(count);
				break;
			}
			if(input.charAt(i) == input.charAt(i+1)) {
				if(count == 0) {
					count += 2;
				} else {
					count++;
				}
			} else {
				if(count != 0) {
					counts.add(count);
					count = 0;
				}
			}
		}
		return Collections.max(counts);
	}

	/**
	 * Given a string - return the number of times "am" appears in the String
	 * ignoring case - BUT ONLY WHEN the word "am" appears without being followed or
	 * preceded by other letters <br>
	 * <br>
	 * For Example: <br>
	 * amISearch("Am I in Amsterdam") → 1 <br>
	 * amISearch("I am in Amsterdam am I?") → 2 <br>
	 * amISearch("I have been in Amsterdam") → 0 <br>
	 * <br>
	 * HINT: String.toLowerCase
	 */
	public int amISearch(String sentence) {
		int count = 0;
		sentence = sentence.toLowerCase();
		String[] words = sentence.split(" ");
		for(String word : words) {
			if(word.equals("am")) {
				count++;
			}
		}
    	return count;
	}

	/**
	 * Given a number if this number is divisible by 3 return "fizz" if this number
	 * is divisible by 5 return "buzz" if this number is divisible by both 3 and 5
	 * return "fizzbuzz" if this number is not divisible by 3 or 5 return null<br>
	 * <br>
	 * For Example: <br>
	 * fizzBuzz(3) → "fizz" <br>
	 * fizzBuzz(10) → "buzz" <br>
	 * fizzBuzz(15) → "fizzbuzz" <br>
	 * fizzBuzz(8) → null
	 */

	public String fizzBuzz(int number) {
		if (number % 3 == 0 && number % 5 ==0) { // if this is true return fizzbuzz
			return "fizzbuzz";
		} else if(number % 3 == 0) { // if the previous condition is not true try this condition now
			return "fizz";
		} else if (number % 5 == 0) {
			return "buzz";
		} else { // if none of these conditions are true always return null
			return null;
		}
	}

	/**
	 * Given a string, split the string into the individual numbers present then add
	 * each digit of each number to get a final value for each number <br>
	 * <br>
	 * String example = "55 72 86"<br>
	 * <br>
	 * "55" will = the integer 10 <br>
	 * "72" will = the integer 9 <br>
	 * "86" will = the integer 14 <br>
	 * <br>
	 * You then need to return the highest vale <br>
	 * <br>
	 * For Example: <br>
	 * largest("55 72 86") → 14 <br>
	 * largest("15 72 80 164") → 11 <br>
	 * largest("555 72 86 45 10") → 15 <br>
	 * <br>
	 * HINT: Integer.parseInt
	 */

	public int largest(String input) {
    	String[] nums = input.split(" ");
		ArrayList<Integer> values = new ArrayList<>();
		for(String num : nums) {
			int value = 0;
			for(int n = 0; n < num.length(); n++) {
				value += Integer.parseInt(String.valueOf(num.charAt(n)));
			}
			values.add(value);
		}
		Collections.sort(values);
		return values.get(values.size() - 1);
	}

	/**
	 * Given a string, int and a char, return a boolean value if the 'nth'
	 * (represented by the int provided) char of the String supplied is the same as
	 * the char supplied. The int provided will NOT always be less than than the
	 * length of the String. Ignore case and Whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * compares("The",2,'h') → true <br>
	 * compares("AAbb",1,'b') → false <br>
	 * compares("Hi-There",10,'e') → false <br>
	 * <br>
	 * HINT: String.charAt
	 */
	public boolean compares(String word, int index, char letter) {
		if(index < word.length()) {
			return word.charAt(index) == letter;
		}
    	return false;
	}
}
