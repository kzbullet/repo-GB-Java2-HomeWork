package ru.geekbrains;

public class Main {

    public static void main(String[] args) {

		Competition challenge27Oct = new Competition();

		challenge27Oct.addParticipant(new Human("John",40,2));
		challenge27Oct.addParticipant(new Human("Mike",120,10));
		challenge27Oct.addParticipant(new Human("Gary",80,0));
		challenge27Oct.addParticipant(new Robot("RoboAngel", 200,1));
		challenge27Oct.addParticipant(new Robot("SciBot", 500,50));
		challenge27Oct.addParticipant(new Cat("Lucy", 70,20));

		challenge27Oct.addObstacle(new RunTrack(50));
		challenge27Oct.addObstacle(new Wall(1));
		challenge27Oct.addObstacle(new RunTrack(100));
		challenge27Oct.addObstacle(new Wall(5));

		challenge27Oct.go();
    }
}
