package ru.geekbrains;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<Integer, Contact> contactList = new HashMap<>();
    private int id;

    public void add(Contact contact) {
        id++;
        contactList.put(id, contact);
    }

    public void get(String name) {
        ArrayList<String> phoneList = new ArrayList<>();

        for (Map.Entry<Integer, Contact> contact : contactList.entrySet()) {
            if (name.equals(contact.getValue().getName())) {
                phoneList.add(contact.getValue().getPhoneNumber());
            }
        }

        if (!phoneList.isEmpty()) {
            System.out.println(name + ":");
            for (String phone : phoneList) {
                System.out.println(phone);
            }
        } else {
            System.out.println("Contact: " + name + " not found.");
        }
    }

    public void printList() {
        for (Integer key : contactList.keySet()) {
            System.out.println(key + ". " + contactList.get(key));
        }
    }
}
