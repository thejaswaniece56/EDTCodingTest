package com.practice;

/**
 * This program moves the robotic arm and save the string to the two 
 * dimensional array as per the command input.
 * 
 * The input command is hard coded.
 *
 * @author  Thejaswani
 * @version 1.0
 * @since   2018-03-13 
 */

public class RoboticArmImpl {

	public static String[][] boxesArray = new String[5][10];
	public static String[] colArray = new String[]{"A", "B", "C", "D", "E"};
	public static int indexI = -1;
	public static int indexJ = 0;

	public static void main(String[] args) {
		String inputCmd = "FD{foo}FFD{bar}RFFD{FOO}RFFD{WORLD}";
		/*
		 * Splits the command input and for each command, simulate the arm
		 */
		String[] inputCmds = inputCmd.split("}");
		for (int i=0; i<inputCmds.length; i++) {
			simulateArm(inputCmds[i]);
		}

		/*
		 * Prints the result to the standard console output
		 */
		String colName = "";
		String result = "";
		for (int j=0; j<colArray.length; j++) {
			colName = colArray[j];
			for (int k=0; k<10; k++) {
				if (null != boxesArray[j][k]) {
					result = result + boxesArray[j][k] +",";
				}
			}
			if (result.endsWith(",")) {
				result = result.substring(0, result.length()-1);
			}
			System.out.println(colName + " ===> [" +result + "]");
			result = "";
		}

	}

	/*
	 * This method decides the position of the arm by reading each character from
	 * the command string and saves the value accordingly
	 */
	public static void simulateArm(String commandInput) {
		try {
			commandInput = commandInput + "}" ;
			int startIndex = commandInput.indexOf("{");
			int endIndex = commandInput.indexOf("}");
			String command = commandInput.substring(0,startIndex);
			String loadValue = commandInput.substring(startIndex+1, endIndex);
			char[] charArray = command.toCharArray();
			for (char c : charArray) {
				if (c == 'F') {
					indexI++;
				}
				if (c == 'R') {
					indexI = -1;
					indexJ = 0;
				}
				if (c == 'D') {

					for (int m =0; m < 10; m++) {
						if (null == boxesArray[indexI][m]) {
							indexJ = m;
							break;
						} 
					}
					boxesArray[indexI][indexJ] = loadValue;
					indexI++;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Unable to move the robotic arm : "+e.getMessage());
		}
	}

}
