import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	//public double[][] readFile(File) {}
	//public void writeToFile(double[][] array, File file) {}
	public static double getTotal(double[][] array) {
		if (array.length == 0)
			return 0;
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				total += array[i][j];
			}
		}
		return total;
	}
	public static double getAverage(double[][] array) {
		if (array.length == 0)
			return 0;
		double length = 0.0;
		for (int i =0; i < array.length; i++)
			length += array[i].length + 1;
		return getTotal(array) / length;
	}
	public static double getColumnTotal(double[][] array, int i) {
		
		if (array.length == 0)
			return 0;
		double total = 0;
		for (int j = 0; j < array.length; j++) {
			if (i < array[j].length)
				total += array[j][i];
		}
		return total;
		
	}
	public static double getHighestInColumn(double[][] array, int i ) {////////////////////////
		if (array.length == 0)
			return 0;
		double highest;
		int a = i;
		while (a > array[0].length - 1) {
			a--;
		}
		highest = array[0][a];
		for (int j = 1; j < array.length; j++) {
			if (i < array[j].length) {
			if (array[j][i] > highest) { 
					highest = array[j][i];
			}}
		}
		return highest;
	}
	
	public static int getHighestInColumnIndex(double[][] array, int i ) {
		if (array.length == 0)
			return 0;
		double highest = array[0][i];
		int highestIndex = 0;
		for (int j = 1; j < array.length; j++) {
			if (array[j][i] > highest) {
				highest = array[j][i];
				highestIndex = j;
			}
		}
		return highestIndex;
	}
	
	public static double getLowestInColumn(double[][] array, int i ) {
		if (array.length == 0)
			return 0;
		double lowest;
		int a = i;
		while (a > array[0].length - 1) {
			a--;
		}
		lowest = array[0][a];
		for (int j = 1; j < array.length; j++) {
			if (i < array[j].length) {
			if (array[j][i] < lowest) {
				lowest = array[j][i];
			} }
		}
		return lowest;
	}
	public static int getLowestInColumnIndex(double[][] array, int i ) {
		if (array.length == 0)
			return 0;
		double lowest = array[0][i];
		int lowestIndex = 0;
		for (int j = 1; j < array.length; j++) {
			if (array[j][i] < lowest) {
				lowest = array[j][i];
				lowestIndex = j;
			}
		}
		return lowestIndex;
	}
	public static double getHighestInArray(double[][] array) {
		if (array.length == 0)
			return 0;
		double highest = array[0][0];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (highest < array[i][j]) {
					highest = array[i][j];
				}
			}
		}
		return highest;
	}
	public static double getLowestInArray(double[][] array) {
		if (array.length == 0)
			return 0;
		double lowest = array[0][0];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (lowest > array[i][j]) {
					lowest = array[i][j];
				}
			}
		}
		return lowest;
	}
	public static double getRowTotal(double[][] array, int i) {
		if (array.length == 0)
			return 0;
		double total = 0;
		for (int j = 0; j < array[i].length; j++) {
			total += array[i][j];
		}
		return total;
	}
	public static double getHighestInRow(double[][] array, int i ) {
		if (array.length == 0)
			return 0;
		double highest = array[i][0];
		for (int j = 1; j < array[i].length; j++) {
			if(array[i][j] > highest)
				highest = array[i][j];
		}
		return highest;
	}
	public static int getHighestInRowIndex(double[][] array, int i ) {
		
		double highest = array[i][0];
		int highestIndex = 0;
		for (int j = 1; j < array[i].length; j++) {
			if(array[i][j] > highest) {
				highest = array[i][j];
				highestIndex = j;
			}
		}
		return highestIndex;
	}
	public static double getLowestInRow(double[][] array, int i ) {
		if (array.length == 0)
			return 0;
		double lowest = array[i][0];
		for (int j = 1; j < array[i].length; j++) {
			if(array[i][j] < lowest)
				lowest = array[i][j];
		}
		return lowest;
	}
	public static int getLowestInRowIndex(double[][] array, int i ) {
		double lowest = array[i][0];
		int lowestIndex = 0;
		for (int j = 1; j < array[i].length; j++) {
			if(array[i][j] < lowest) {
				lowest = array[i][j];
				lowestIndex = j;
			}
		}
		return lowestIndex ;
	}
	public static double[][] readFile(File file) throws FileNotFoundException { //WORKS!!/////////////
		
		
		char ch;
		//try
        //{
			Scanner scanner = new Scanner(file);
        //}
        //catch (FileNotFoundException fe)
        //{
        //    System.out.println("File not found");
        //}
		String[] lines = new String[10];
		int lineCount = 0;
		while (scanner.hasNextLine()) {
			lines[lineCount] = scanner.nextLine();
			lineCount++;
		}
		String[][] outputWithNulls = new String[lineCount][10];
		//TwoDimRaggedArrayUtility.printArray(lines);
		int numCount = 0;
		int[] numCounts = new int[lineCount];
		String numAsString;
		String line;
		for (int i = 0; i < lineCount; i++) {
			line = lines[i];
			numAsString = "";
			for (int j = 0; j < line.length(); j++) {
				ch = line.charAt(j);
				
				if (ch ==' ') {
					//System.out.println(numAsString);
					outputWithNulls[i][numCount] = numAsString;
					numCount++;
					numAsString = "";
				}
				else
					numAsString += ch;
			}
			numCounts[i] = numCount + 1;
			outputWithNulls[i][numCount] = numAsString;
			//System.out.println(numAsString);
			numCount = 0;
		}
		//TwoDimRaggedArrayUtility.printArray(outputWithNulls); 
		int a;
		double[][] outputWithNullsDouble = new double[lineCount][10];
		for (int i = 0; i < lineCount; i++) {
			for (int j = 0; j < numCounts[i]; j++) {
				outputWithNullsDouble[i][j] = Double.parseDouble(outputWithNulls[i][j]);
			}
		}
		
		//TwoDimRaggedArrayUtility.printArray(outputWithNullsDouble);/////////////////
		double[][] output = new double[lineCount][];
		double[] lineAsArray;
		for (int i = 0; i < lineCount; i++) {
			lineAsArray = new double[numCounts[i]];
			for (int j = 0; j < numCounts[i]; j++) {
				lineAsArray[j] = outputWithNullsDouble[i][j];
			}
			output[i] = lineAsArray;
		}
		//TwoDimRaggedArrayUtility.printArray(output);
		scanner.close();
		
		return output;
	}

	public static void writeToFile(double[][] array, File file) throws FileNotFoundException {
		FileWriter writer;
		try {
			
			writer = new FileWriter(file);
			String line = "";
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					line += array[i][j];
					if (j != array[i].length - 1) {
						line += ' ';
					//System.out.print(line);
					}
					//System.out.println(line);
				}
				writer.write(line + "\n");
				line = "";
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void printArray(double[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Row " + i);
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
	}
	public static void printArray(double[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]);
	}
	public static void printArray(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Row " + i);
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
	}
	public static void printArray(String[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i]);
	}
}
