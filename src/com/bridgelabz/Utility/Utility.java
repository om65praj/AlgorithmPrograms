package com.bridgelabz.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.FileSystemNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author OmPrajapati
 *
 */
public class Utility {

	Scanner scanner = new Scanner(System.in);
	BufferedReader br;

	/**
	 * constructor to initialize bufferedReader
	 */
	public Utility() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * take input word
	 */
	public String inputString() {
		try {
			return br.readLine();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return "";
	}

	/**
	 * Take Integer Input
	 *
	 */
	public int inputInteger() {
		try {
			try {
				return Integer.parseInt(br.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return 0;
	}

	/**
	 * Take Double Input
	 */
	public double inputDouble() {
		try {
			try {
				return Double.parseDouble(br.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return 0.0;
	}

	
	/**
	 * @param input year
	 * @return boolean
	 */
	public boolean leapYearCheaker(int year) {
		if (year > 1000) {
			if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
				return true;
			}
		}
		return false;
	}


	/**
	 * @param integer
	 * @return integer
	 */
	public int poworOfTwo(int integer) {
		int power = 1;
		while (integer != 0) {
			power = 2 * power;
			integer--;
		}
		return power;
	}

	/**
	 * @param input number
	 * @param create a method HarmonicNumber
	 * @return double
	 */
	public double harmonicNumber(int number) {
		double sum = 0.0;
		for (int i = 1; i <= number; i++) {
			sum = sum + (1.0 / i);
		}
		return sum;
	}

	/**
	 * 
	 */
	/**
	 * @param input number
	 * @param create a method of prime number
	 * @return boolean
	 */
	public boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	/**
	 * @param input limit
	 * @return create a method to String[] prime
	 */
	public String[] checkPrime(int limit) {
		String[] arry = new String[limit];
		int position=0;
		for(int i=2; i < limit; i++) {
             if(isPrime(i)){
            	arry[position] = String.valueOf(i);
				position++;
             }
		}
        String[] array1 = new String[position];
 		for (int k = 0; k < position; k++) {
 			array1[k] = arry[k];
 		}
 		return array1;      
	}
	

	/**
	 * @param input number
	 * @param create a method to check palindrome
	 * @return boolean
	 */
	public boolean palindromeNumber(int number) {
		int rem, sum = 0, temp;
		temp = number;
		while (number != 0) {
			rem = number % 10;
			sum = sum * 10 + rem;
			number = number / 10;
		}
		if (sum == temp)
			return true;
		return false;
	}

	/**
	 * @param input First string
	 * @param input Second string
	 * @param  create a method to Anagram
	 * @return boolean
	 */
	public boolean checkAnagram(String string1, String string2)
	{
		if (string1.length() != string2.length()) {
			return false;
		}
		char[] charArray1 = string1.toCharArray();
		Arrays.sort(charArray1);
		char[] charArray2 = string2.toCharArray();
		Arrays.sort(charArray2);
		for (int i = 0; i < charArray1.length; i++) {
			if (charArray1[i] != charArray2[i]) {
				if(charArray1[i]!=charArray2[i]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param input number
	 * @return String Array
	 */
	public String[] prime(int number) 
	{
		String[] array = new String[1000];
		int position = 0;
		for (int i = 2; i <= number; i++)
		{
			boolean b = true;
			for (int j = 2; j <= i / 2; j++) 
			{
				if ((i % j) == 0) 
				{
					b = false;
					break;
				}
			}
			if (b) {
				array[position] = String.valueOf(i);
				position++;
			}
		}
		String[] array1 = new String[position];
		for (int k = 0; k < position; k++) {
			array1[k] = array[k];
		}
		return array1;
	}

	/**
	 * @param input String 
	 * @param create a method to check and print Palindrome number
	 * @return boolean
	 */
	public boolean palindrome(String s) {
		if (s.length() < 2) {
			return false;
		}
		char[] c = s.toCharArray();
		int n = c.length;
		for (int i = 0; i < n; i++) {
			if (c[i] != c[n - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return integer Array
	 */
	public int[][] readArrayInt() {
		System.out.println("Enter M of rows : ");
		int m = scanner.nextInt();
		System.out.println("Enter N of coloms : ");
		int n = scanner.nextInt();

		System.out.println("Enter " + m * n + " of elements : ");
		int a[][] = new int[m][n];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = scanner.nextInt();
			}
		}
		return a;
	}


	/**
	 * @param input integer array
	 */
	public void displayInt(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + Utility.padRight(" ", 10));
			}
			System.out.println();
		}
	}

	/**
	 * @param create a read method for Double 2D array
	 * @return double array
	 */
	public double[][] readArrayDouble() {
		System.out.println("Enter M of rows : ");
		int m = scanner.nextInt();
		System.out.print("Enter N of coloms : ");
		int n = scanner.nextInt();

		System.out.println("Enter " + m * n + " of elements : ");
		double a[][] = new double[m][n];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = scanner.nextDouble();
			}
		}
		return a;
	}

	/**
	 * @param double integer array
	 * @param create a display method for Double 2D array
	 */
	public void displayDouble(double a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + Utility.padRight(" ", 10));
			}
			System.out.println();
		}
	}

	/**
	 * @param input String 
	 * @param input number
	 * @param create methods for Right padding
	 * @return String
	 */
	public static String padRight(String string, int number) {
		return String.format("%1$-" + number + "s", string);
	}

	/**
	 * @param input String 
	 * @param input number
	 * @param create methods for Left padding
	 * @return String
	 */
	public static String padLeft(String string, int number) {
		return String.format("%1$" + number + "s", string);
	}

	/**
	 * @return boolean array
	 */
	public boolean[][] readArrayBoolean() {

		System.out.println("Enter M of rows : ");
		int m = scanner.nextInt();
		System.out.print("Enter N of coloms : ");
		int n = scanner.nextInt();

		System.out.println("Enter " + m * n + " of elements : ");
		boolean a[][] = new boolean[m][n];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = scanner.nextBoolean();
			}
		}
		return a;
	}

	/**
	 * @param input boolean array
	 */
	public void displayBoolean(boolean a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + Utility.padRight(" ", 5));
			}
			System.out.println();
		}
	}

	/**
	 * @param input integer array
	 * @param create a method sum of three integer number is zero
	 * @return integer
	 */
	public int sumofthree(int a[]) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				for (int k = j; k < a.length; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						System.out.println(a[i] + " " + a[j] + " " + a[k]);
						count++;
					}
				}
			}
		}
		return count;
	}

	/**
	 * @param create a method read an Array
	 * @return integer array
	 */
	public int[] readArray() {
		System.out.print("Enter the size of array");
		int n = scanner.nextInt();
		int a[] = new int[n];
		System.out.print("Enter the " + n + " elements ");
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		return a;
	}

	/**
	 * @param input integer array
	 * @param create a method display an Array
	 */
	public void display(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * create a permute method
	 */
	public void permute(String st, int start, int end) {
		if (start == end) {
			System.out.println(st);
		} else {
			for (int i = start; i <= end; i++) {
				st = swap(st, start, i);
				permute(st, start + 1, end);
				st = swap(st, start, i);
			}
		}
	}
	
	/**
	 * @param input string st
	 * @param input number a
	 * @param input number b
	 * @param create a method to swap the string
	 * @return String 
	 */
	public String swap(String st, int a, int b) {
		char[] ch = st.toCharArray();
		char temp = ch[a];
		ch[a] = ch[b];
		ch[b] = temp;
		return String.valueOf(ch);
	}

	/**
	 * Simulate Stop watch Program
	 */
	long startTime = 0;
	long stopTime = 0;
	boolean running = false;
	
	public void start() {
		this.startTime = System.currentTimeMillis();
		this.running = true;
	}

	public void stop() {
		this.stopTime = System.currentTimeMillis();
		this.running = false;
	}

	/**
	 * @return boolean
	 */
	public long getElapsedTime() {
		long elapsed;
		if (running) {
			elapsed = (System.currentTimeMillis() - startTime);
		} else {
			elapsed = (stopTime - startTime);
		}
		return elapsed;
	}

	/**
	 * @param input integer firstnumber
	 * @param input integer secondnumber
	 * @param create a power function
	 * @return integer
	 */
	public int powerFunction(int firstnumber, int secondnumber) {
		if (secondnumber == 0) {
			return 1;
		}
		return (firstnumber * powerFunction(firstnumber, secondnumber - 1));
	}

	/**
	 * @param input integer a
	 * @param input integer b
	 * @param input integer c
	 * @param create a method to find root
	 */
	public void findRoot(int a, int b, int c) {
		double delta, root1, root2;
		delta = Math.pow(b, 2) - 4 * a * c;
		System.out.println(delta);
		root1 = (-1 * b + Math.sqrt(delta)) / (2 * a);
		root2 = (-1 * b - Math.sqrt(delta)) / (2 * a);
		System.out.println("Frist Root of the question is : " + root1);
		System.out.println("Second Root of the question is : " + root2);
	}

	/**
	 * @param input integer t
	 * @param input integer v
	 * @param create a method of calculateWindChill
	 */
	public void calculateWindChill(int t, int v) {
		double windChill;
		if (t > 50) {
			System.out.println("Temperature should not be greater than 50 ");
			calculateWindChill(t, v);
			return;
		}
		if ((v > 120) || (v < 3)) {
			System.out.println("Velocity should be greater than 3 and less than 120 ");
			calculateWindChill(t, v);
			return;
		}
		windChill = 35.74 + 0.6215 * t + (0.4275 * t - 53.75) * (Math.pow(v, 0.16));
		System.out.println("WindChill : " + windChill);
	}

	/**
	 * @param input integer valueOfx
	 * @param  input integer valueOfy
	 * @param create a method distance between two origin
	 */
	public void distance(int valueOfx, int valueOfy) {
		int powerofx = powerFunction(valueOfx, 2);
		System.out.println("Power of number x is :" + powerofx);
		int powerofy = powerFunction(valueOfy, 2);
		System.out.println("Power of number y is :" + powerofy);
		int distance = (powerofx + powerofy);
		System.out.println("Distance between two origin is  : " + Math.sqrt(distance));
	}

	/**
	 * create a method to remove space in a string
	 */
	public String removeSp(String string) {
		char ch[] = string.toCharArray();
		string = "";
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != ' ') {
				string = string + ch[i];
			}
		}
		return string;
	}

	/**
	 * create a method to convert upper case to lower case
	 */
	public String toLower(String string) {
		char ch[] = string.toCharArray();
		string = "";
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] > 'A' && ch[i] < 'Z') {
				string = string + (ch[i] + 32);
			} else {
				string = string + ch[i];
			}
		}
		return string;
	}

	/**
	 * create a method to sort a string
	 */
	public String sortString(String string) {
		char ch[] = string.toCharArray();
		string = "";
		for (int i = 0; i < ch.length; i++) {
			for (int j = i; j < ch.length; j++) {
				if (ch[i] > ch[j]) {
					char t = ch[i];
					ch[i] = ch[j];
					ch[j] = t;
				}
			}
			string = string + ch[i];
		}
		return string;
	}

	/**
	 * create a method to check both string is same or not
	 */
	public boolean chechStr(String string1, String string2) {
		char ch1[] = string1.toCharArray();
		char ch2[] = string2.toCharArray();

		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i] != ch2[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param input integer  n
	 * @param string representing binary of number
	 * @return String
	 */
	public String toBinary(int n) {
		if (n == 0) {
			return "0";
		}
		String binary = "";
		while (n > 0) {
			int rem = n % 2;
			binary = rem + binary;
			n = n / 2;
		}
		return binary;
	}

	/**
	 * reverse string
	 */
	public String reverseString(String str) {
		char ch[] = str.toCharArray();
		String string = "";
		for (int i = ch.length - 1; i >= 0; i--) {
			string = string + ch[i];
		}
		return string;
	}

	/**
	 *
	 * @returns square root of the number
	 * 
	 * @param Math.abs(t-
	 *            c/t) > epsilon*t where epsilon = ​ 1e-15​ epsilon =
	 * @param Math.pow(2.71828,
	 *            -15)
	 */
	public double sqrt(double c, double t) {
		t = ((c / t) + t) / 2;
		if (Math.abs(t - (c / t)) > (Math.pow(2.71828, -15) * t)) {
			return t;
		}
		return sqrt(c, t);
	}

	/**
	 * @param create
	 *            a function of catalan number Cn=2n!/(n+1)!n!;
	 * 
	 */
	public void catalanNumber(int n) {
		int Cn = fact(2 * n) / (fact(n + 1) * fact(n));
		System.out.println("Number Of Binary Search Tree : " + Cn);
	}

	/**
	 * 
	 * @param create
	 *            a function of factorial number
	 * 
	 */
	public int fact(int number) {

		if (number > 1) {
			return (number * fact(number - 1));
		}
		return 1;
	}

	/**
	 * @param create
	 *            method of regular Expression
	 * @throws IOException
	 * 
	 */
	public void regularExpression() {
		File file = new File("/home/bridgelabz/Public/file/regularExpression.txt");
		try {
			FileReader filereader = new FileReader(file);
			int length = (int) file.length();
			char[] charArray = new char[length];
			filereader.read(charArray);
			String string = new String(charArray);
			System.out.print("Enter your first name: ");
			String firstName = scanner.nextLine();
			System.out.print("Enter your full name: ");
			String fullName = scanner.nextLine();
			System.out.print("Enter your contact number: ");
			String contactNumber = scanner.nextLine();
			System.out.print("Enter date in dd/mm/yyyy format: ");
			String date = scanner.nextLine();
			string = string.replaceAll("<<name>>", firstName);
			string = string.replaceAll("<<full name>>", fullName);
			string = string.replaceAll("xxxxxxxxxx", contactNumber);
			string = string.replaceAll("01/01/2016", date);
			System.out.println(string);
		} catch (FileSystemNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * create a method to sort a string array
	 * 
	 */
	public String[] sortArrayString(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings.length - 1; j++) {
				if (strings[j].compareTo(strings[j + 1]) > 0) {
					String temp = strings[j];
					strings[j] = strings[j + 1];
					strings[j + 1] = temp;
				}
			}
		}
		return strings;
	}

	/**
	 * Binary Search for integer
	 */
	public int binarySearch(int[] a, int key) {
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == a[mid]) {
				return mid;
			}
			if (key < a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * Binary Search for String
	 */

	public int binarySearchString(String[] names, String key) {
		int first = 0;
		int last = names.length;
		while (first < last) {
			int mid = (first + last) / 2;
			if (key.compareTo(names[mid]) < 0) {
				last = mid;
			} else if (key.compareTo(names[mid]) > 0) {
				first = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/*
	 * Bubble Sort for Integer
	 */
	public int[] bubbleSort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < (a.length - i); j++) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

	/**
	 * Bubble Sort for String
	 */
	public String[] bubbleSortString(String ch[]) {
		for (int i = 0; i < ch.length; i++) {
			for (int j = 1; j < (ch.length - i); j++) {
				if (ch[j - 1].compareTo(ch[j]) < 0) {
					String temp = ch[j - 1];
					ch[j - 1] = ch[j];
					ch[j] = temp;
				}
			}
		}
		return ch;
	}

	/**
	 * Insertion sort
	 */
	public int[] insertionSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if ((a[j] - a[j - 1]) < 0) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				} else
					break;
			}
		}
		return a;
	}

	/**
	 * Insertion sort for String array
	 */
	public String[] insertionSortString(String a[]) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j].compareTo(a[j - 1]) < 0) {
					String temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				} else
					break;
			}
		}
		return a;
	}

	public int[] input1DArray(int arraySize) {
		int array[] = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			System.out.println("Enter array[" + i + "] : ");
			array[i] = scanner.nextInt();
		}
		return array;
	}

	public String[] input1DStringArray(int arraySize) {
		String array[] = new String[arraySize];
		for (int i = 0; i < arraySize; i++) {
			System.out.println("Enter array[" + i + "] : ");
			array[i] = scanner.nextLine();
		}
		return array;
	}

	public void print1DArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public void print1DStringArray(String array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	/**
	 * m - month of the year d - day of the month y - year day of the week
	 */
	public int dayOfWeek(double M, double D, double Y) {
		double y0 = Y - ((14 - M) / 12);
		double x = y0 + (y0 / 4) - (y0 / 100) + (y0 / 400);
		double m0 = M + 12 * ((14 - M) / 12) - 2;
		double d0 = (D + x + (31 * m0 / 12)) % 7;
		return (int) d0;
	}

	/**
	 * temperature - temperature to be converted unit - given temperature's unit
	 * converted temperature
	 */
	public double tempConvert(double temperature, String unit) {
		if (unit.equals("f")) {
			return ((double) temperature - 32) * 5 / 9;
		} else {
			return (((double) temperature * 9 / 5) + 32);
		}
	}

	/**
	 * 
	 * monthly payment from given P, Y & R values
	 */
	public int monthlyPayment(double P, double Y, double R) {
		double r = R / (12 * 100);
		double n = -1 * 12 * Y;
		double payment = (P * r) / (1 - Math.pow((1 + r), n));
		return (int) payment;
	}

	/**
	 * create a method to find Number
	 */
	public void findNumber(int low, int high) {
		if (low == high) {
			System.out.println("Your number is : " + low);
			System.out.println("Intermediary numbers is " + (low - 1) + " and " + (low + 1));
			return;
		}

		int mid = (low + high) / 2;
		System.out.println("Press 1 : " + low + " - " + mid);
		System.out.println("Press 2 : " + (mid + 1) + " - " + high);

		int ch = new Utility().inputInteger();
		if (ch == 1) {
			findNumber(low, mid);
		} else {
			findNumber(mid + 1, high);
		}
	}

	/**
	 * create a method for merge sort
	 */
	public String[] mergeSort(String[] array) {
		if (array.length == 1) {
			return array;
		}
		String first[] = new String[array.length / 2];
		String last[] = new String[array.length - (array.length / 2)];
		for (int i = 0; i < first.length; i++) {
			first[i] = array[i];
		}
		int j = 0;
		for (int i = first.length; i < array.length; i++) {
			last[j] = array[i];
			j++;
		}
		first = mergeSort(first);
		last = mergeSort(last);

		String[] returnArray = new String[array.length];
		int firstPos = 0, lastPos = 0;
		for (int i = 0; i < returnArray.length; i++) {
			if (lastPos == last.length) {
				returnArray[i] = first[firstPos];
				firstPos++;
			} else if (firstPos == first.length) {
				returnArray[i] = last[lastPos];
				lastPos++;
			} else if (first[firstPos].compareTo(last[lastPos]) > 0) {
				returnArray[i] = last[lastPos];
				lastPos++;
			} else {
				returnArray[i] = first[firstPos];
				firstPos++;
			}
		}
		return returnArray;
	}

	/**
	 * Function for Calculating the notes
	 */

	static int i = 0;
	static int total = 0;
	static int money;
	public int calculate(int money, int[] notes) {

		if (money == 0) {
			return -1;
		} else {
			if (money >= notes[i]) {
				int calNotes = money / notes[i];
				int rem = money % notes[i];
				money = rem;
				total = total + calNotes;
				System.out.println(notes[i] + " Notes ---> " + calNotes);

			}
			i++;
			// System.out.println("Total Number of Notes are :"+total);
			return calculate(money, notes);
		}
	}

}
