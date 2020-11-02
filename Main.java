package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        String[][] arr = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = "1";
            }
        }
        arr[2][2] = "H";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        try {
            System.out.println(convertStringToInt(arr));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.println("Array must be of size [4][4]");
        } catch (MyArrayDataException ignored) {

        }

    }

    private static int convertStringToInt(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Wrong size of array.");
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    findCellWithWrongData(arr);
                }
            }
        }
        return sum;
    }

    private static void findCellWithWrongData(String[][] arr) throws MyArrayDataException {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j].length() > 1) {
                    System.out.println("Wrong data in array [" + i +"][" + j +"]");
                    throw new MyArrayDataException();
                } else if (!Character.isDigit(arr[i][j].charAt(0))) {
                    System.out.println("Wrong data in array [" + i +"][" + j +"]");
                    throw new MyArrayDataException();
                }
            }
        }
    }
}
