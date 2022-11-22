package udemy.ds.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

	/*
	 * public static void main(String[] args) {
	 * 
	 * int[] intArray = {20, 35, -25, 7, 55, 1, -22};
	 * 
	 * 
	 * for(int lastUnsortedIndex = intArray.length-1; lastUnsortedIndex > 0 ;
	 * lastUnsortedIndex--) {
	 * 
	 * for(int i =0 ;i<lastUnsortedIndex; i++) { if(intArray[i]<intArray[i+1]) {
	 * swap(intArray, i, i+1); } } }
	 * 
	 * for(int i=0;i<intArray.length;i++) { System.out.println(intArray[i]); } }
	 * 
	 * 
	 * 
	 * public static void swap(int[] array,int i, int j) {
	 * 
	 * if(i == j) return;
	 * 
	 * int temp = array[i]; array[i] = array[j]; array[j] = temp; }
	 */

	public static void main(String args[]) throws IOException {
		// create the ping command as a list of strings
		BubbleSort ping = new BubbleSort();
		List<String> commands = new ArrayList<String>();
		commands.add("ping");
		//commands.add("-c");
		commands.add("5");
		commands.add("www.google.com");
		ping.doCommand(commands);
	}

	public void doCommand(List<String> command) throws IOException {
		String s = null;

		ProcessBuilder pb = new ProcessBuilder(command);
		Process process = pb.start();

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

		// read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		while ((s = stdInput.readLine()) != null) {
			System.out.println(s);
		}

		// read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}
	}

}
