public class Main {
    public static void main(String[] args) {


        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };


        try {
            ArrayException.twoDimensionalArray(correctArray);
        } catch (MyArraySizeExceptoin | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }
}
