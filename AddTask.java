package ru.geekbrains;

public class AddTask {
    public static void main(String[] args) {

        try {
            int[][] numArray = new int[5][5];
            circleBack(numArray);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error!");
        }
    }

    private static void circleBack(int[][] arr) {
        int row = arr[0].length;
        int col = arr.length;

        int[][] numArr = new int[row][col];

        int fillNum = 1;

        while (arrContainsZero(numArr)) {
            // fill in by column down
            // finding starting point
            int colS = startPoint(numArr)[0];
            int rowS = startPoint(numArr)[1];
            // find how many zero's
            int repeatByColDown = countZeroByColDown(numArr, colS);

            while (repeatByColDown > 0) {
                numArr[rowS][colS] = fillNum;
                rowS++;
                fillNum++;
                repeatByColDown--;
            }

            // fill in by row right
            // reset the starting point
            colS++;
            rowS--;

            int repeatByRowRight = countZeroByRowRight(numArr, rowS);

            while (repeatByRowRight > 0) {
                numArr[rowS][colS] = fillNum;
                colS++;
                fillNum++;
                repeatByRowRight--;
            }

            // fill in by column up
            colS--;
            rowS--;

            int repeatByColUp = countZeroByColUp(numArr, colS);

            while (repeatByColUp > 0) {
                numArr[rowS][colS] = fillNum;
                rowS--;
                fillNum++;
                repeatByColUp--;
            }

            // fill in by row left

            colS--;
            rowS++;

            int repeatByRowLeft = countZeroByRowLeft(numArr, rowS);

            while (repeatByRowLeft > 0) {
                numArr[rowS][colS] = fillNum;
                colS--;
                fillNum++;
                repeatByRowLeft--;
            }
        }
        printArray(numArr);
    }

    private static void printArray (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j ++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int[] startPoint (int[][] arr) {
        int[] coord = new int[2];

        outerLoop: for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j ++) {
                if (arr[i][j] == 0) {
                    coord[0] = i;
                    coord[1] = j;
                    break outerLoop;
                }
            }
        }

        return coord;
    }

    private static boolean arrContainsZero (int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j ++) {
                if (arr[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int countZeroByColDown (int[][] arr, int column) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][column] == 0) {
                count++;
            }
        }
        return count;
    }

    private static int countZeroByRowRight (int[][] arr, int row) {
        int count = 0;
        for (int i = 0; i < arr[row].length; i++) {
            if (arr[row][i] == 0) {
                count++;
            }
        }
        return count;
    }

    private static int countZeroByColUp (int[][] arr, int column) {
        int count = 0;
        for (int i = arr.length - 1; i > -1 ; i--) {
            if (arr[i][column] == 0) {
                count++;
            }
        }
        return count;
    }

    private static int countZeroByRowLeft (int[][] arr, int row) {
        int count = 0;
        for (int i = arr[row].length - 1; i > -1 ; i--) {
            if (arr[row][i] == 0) {
                count++;
            }
        }
        return count;
    }
}
