package ru.geekbrains;

public class FloatArrayTest {

    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;

    public static void main(String[] args) {
	    methodA();
	    methodB();
    }

    public static void methodA() {
        float[] arr = getFloatArray();
        long a = System.currentTimeMillis();
        fillFloatArray(arr);
        System.out.println("Method A milliseconds: " + (System.currentTimeMillis() - a));
    }

    public static void methodB() {
        float[] arr = getFloatArray();
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        long a1 = System.currentTimeMillis();

        new Thread(() -> fillFloatArray(arr1));
        new Thread(() -> fillFloatArray(arr2));
        long a2 = System.currentTimeMillis();

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println("Method B milliseconds step 1: " + (a2 - a1));
        System.out.println("Method B milliseconds step 2: " + (System.currentTimeMillis() - a2));
    }

    private static float[] getFloatArray() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        return arr;
    }

    private static void fillFloatArray(float[] arr) {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
