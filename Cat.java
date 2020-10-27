package ru.geekbrains;

public class Cat implements Participant {
    private String name;
    private int runLimit;
    private int jumpLimit;

    public Cat(String name, int runLimit, int jumpLimit) {
        this.name = name;
        if (runLimit >= 0) {
            this.runLimit = runLimit;
        }
        if (jumpLimit >= 0) {
            this.jumpLimit = jumpLimit;
        }
    }

    @Override
    public boolean canRun(RunTrack runTrack) {
        return runLimit >= runTrack.getLength();
    }

    @Override
    public void run(RunTrack runTrack) {
        if (canRun(runTrack)) {
            System.out.println(name + " successfully ran " + runTrack.getLength() + " m.");
        } else {
            System.out.println(name + " couldn't make it, and finishes competition.");
        }
    }

    @Override
    public boolean canJump(Wall wall) {
        return jumpLimit >= wall.getHeight();
    }

    @Override
    public void jump(Wall wall) {
        if (canJump(wall)) {
            System.out.println(name + " successfully jumped " + wall.getHeight() + " m.");
        } else {
            System.out.println(name + " couldn't make it, and finishes competition.");
        }
    }
}
