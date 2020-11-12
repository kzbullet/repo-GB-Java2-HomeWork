package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        // exercise #1
        RandomWords randomWords = new RandomWords();
        randomWords.go();
        System.out.println("========================");

        // exercise #2
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add(new Contact("Yekshembeyev", "+7-702-220-7070"));
        phoneBook.add(new Contact("Turakbayev", "+7-777-640-2020"));
        phoneBook.add(new Contact("Ualitkhanov", "+7-701-781-3320"));
        phoneBook.add(new Contact("Sakhauov", "+7-701-577-7070"));
        phoneBook.add(new Contact("Yekshembeyev", "+7-702-220-1010"));

        phoneBook.get("Yekshembeyev");
    }
}
