package ru.geekbrains;

import java.util.ArrayList;

public class Competition {
    private ArrayList<Participant> participants = new ArrayList<>();
    private ArrayList<Obstacle> obstacles = new ArrayList<>();

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public void go() {
        for (Participant participant : participants) {
            for (Obstacle obstacle: obstacles) {
                if (obstacle instanceof RunTrack) {
                    if (participant.canRun((RunTrack)obstacle)) {
                        participant.run((RunTrack)obstacle);
                    } else {
                        participant.run((RunTrack)obstacle);
                        break;
                    }
                } else {
                    if (participant.canJump((Wall)obstacle)) {
                        participant.jump((Wall)obstacle);
                    } else {
                        participant.jump((Wall)obstacle);
                        break;
                    }
                }
            }
            System.out.println("===============================");
        }
    }
}
