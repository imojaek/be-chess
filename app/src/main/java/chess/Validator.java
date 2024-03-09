package chess;

public class Validator {

    public static boolean isValidPosition(String inputPos) {
        return inputPos.matches("[A-H][1-8]") && inputPos.length() == 2;
    }

}
