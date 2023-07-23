package org.example;

public class Main {
    public static void main(String[] args) {

        //creation of the students instances
        Student student1 = new Student("Joe", "Doe");
        Student student2 = new Student("Troy", "Garner");
        Student student3 = new Student("Ramona", "Gross");
        Student student4 = new Student("Cassiano", "Robson");
        System.out.println("-----------------------------------------------------------------------------");

        //creation of the group with the student group-leader and checking the number of students
        StudentsGroup group1 = new StudentsGroup(student1, "Group #1");

        //checking the leader of the group
        System.out.println(group1.getGroupName() + " leader is: " +  group1.getGroupLeader().getFullName());

        //checking the number of students
        group1.printStudentsList();
        System.out.println("-----------------------------------------------------------------------------");

        //adding students to the group and checking the number of students
        group1.addStudent(student1); //checking the case if student is already added
        group1.addStudent(student2);
        group1.addStudent(student3);
        group1.addStudent(student4);

        group1.printStudentsList();
        System.out.println("-----------------------------------------------------------------------------");

        //checking the ID of a student
        System.out.println("The ID of " + student1.getFullName() + " is " + student1.getId());
        System.out.println("The ID of " + student4.getFullName() + " is " + student4.getId());
        System.out.println("-----------------------------------------------------------------------------");

        //Setting another student as group-leader
        group1.setGroupLeader(student4);
        System.out.println(group1.getGroupName() + " leader is: " + group1.getGroupLeader().getFullName());
        System.out.println("-----------------------------------------------------------------------------");

        //removing student from the group and checking the number of students
        group1.removeStudent(student3);
        group1.printStudentsList();

        //removing previously removed student from the group and checking the number of students
        group1.removeStudent(student3);
        group1.printStudentsList();
        System.out.println("-----------------------------------------------------------------------------");

        //removing group-leader from the group and checking the number of students
        group1.removeStudent(student4);
        group1.printStudentsList();
        System.out.println("-----------------------------------------------------------------------------");

        //setting the removed person as group-leader
        group1.setGroupLeader(student3);
        System.out.println("-----------------------------------------------------------------------------");

        //setting new group-leader
        group1.setGroupLeader(student2);
        System.out.println(group1.getGroupName() + " leader is: " + group1.getGroupLeader().getFullName());
        System.out.println("-----------------------------------------------------------------------------");

        //adding tasks
        group1.addTask("Learn encapsulation");
        group1.addTask("Learn Design Patterns");
        group1.addTask("Make the homework");

        //adding task that was previously added
        group1.addTask("Learn encapsulation");
        System.out.println("-----------------------------------------------------------------------------");

        //setting tasks as done for students
        group1.setTaskDoneForStudent("Learn encapsulation", student1);
        group1.setTaskDoneForStudent("Learn encapsulation", student2);
        group1.setTaskDoneForStudent("Learn Design Patterns", student2);

        //setting invalid task as done for valid student
        group1.setTaskDoneForStudent("Design application", student2);

        //setting valid task as done for removed student
        group1.setTaskDoneForStudent("Learn Design Patterns", student3);

        //setting invalid task as done for removed student
        group1.setTaskDoneForStudent("Design application", student3);
        System.out.println("-----------------------------------------------------------------------------");

        //printing students who completed the tasks
        group1.printStudentsCompletedTheTask("Learn encapsulation");
        group1.printStudentsCompletedTheTask("Learn Design Patterns");
        group1.printStudentsCompletedTheTask("Make the homework");

        //printing students who completed the invalid task
        group1.printStudentsCompletedTheTask("Design application");
    }
}
