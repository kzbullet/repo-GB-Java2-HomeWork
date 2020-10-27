package ru.geekbrains;

public interface Participant {
    void run(RunTrack runTrack);
    boolean canRun(RunTrack runTrack);
    void jump(Wall wall);
    boolean canJump(Wall wall);
}
