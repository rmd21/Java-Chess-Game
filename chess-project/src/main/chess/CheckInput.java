package chess;

public class CheckInput {
	
	public static boolean checkCoordinateValidity(String input){

		if (!isValidInput(input)) {
			return false;
		}
		else if (!isValidFormat(input)) {
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean isValidInput(String input) {
		if (input instanceof String && input.length() == 2) {
			return true;
		}
		return false;
	}

	public static boolean isValidFormat(String input) {
		char[] chars = input.toCharArray();
		String validJ = "abcdefgh";

		if (Character.isDigit(chars[0]) && validJ.contains(Character.toString(chars[1]))) {
			if (Character.getNumericValue(chars[0]) <= 7 && Character.getNumericValue(chars[0]) >= 0) {
				return true;
			}
		}
		return false;
	}


}
