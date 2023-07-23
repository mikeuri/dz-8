package org.example;

class Student {
    static int counter = 0;
    private final int id;
    private final String firstName;
    private final String secondName;

    Student (String firstName, String secondName) {
        id = ++counter;
        this.firstName = firstName;
        this.secondName = secondName;
        System.out.printf("New student %s was created\n", getFullName());
    }

    int getId() {
        return id;
    }

    String getFullName() {
        return firstName + " " + secondName;
    }
}
