package ru.geekbrains;

public class RunTrack implements Obstacle {
    private int length;

    public RunTrack(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
