package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsGroup {
    private Student groupLeader;
    private final String groupName;
    private final List<Student> studentsList = new ArrayList<>();
    private final HashMap<String, List<Student>> taskList = new HashMap<>();

    StudentsGroup(Student groupLeader, String groupName) {
        this.groupLeader = groupLeader;
        studentsList.add(groupLeader);
        this.groupName = groupName;
        System.out.printf("'%s' was created and %s was appointed group-leader\n", this.groupName,
                this.groupLeader.getFullName());
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupLeader(Student student) {
        if (studentsList.contains(student)) {
            groupLeader = student;
            System.out.printf("%s was appointed the group-leader\n", groupLeader.getFullName());
        } else {
            System.out.printf("ERROR: Student %s is not in the group and cannot be appointed group-leader\n",
                    student.getFullName());
            System.out.println("INFO: The group-leader is still: " + groupLeader.getFullName());
        }
    }

    public Student getGroupLeader() {
        return groupLeader;
    }

    public void addStudent(Student student) {
        if (!studentsList.contains(student)) {
            studentsList.add(student);
            System.out.println("Student " + student.getFullName() + " was added to the group");
        } else {
            System.out.println("ERROR: Student " + student.getFullName() + " is already in the group and cannot be " +
                    "added again");
        }
    }

    public void removeStudent(Student student) {
        if (student == groupLeader) {
            System.out.println("ERROR: " + student.getFullName() + " cannot be removed from the group " +
                    "because he/she is a group-leader");
            System.out.println("INFO: To remove current group-leader, another person should be appointed before");
        } else if (studentsList.contains(student)) {
            studentsList.remove(student);
            System.out.println("Student " + student.getFullName() + " was removed from the group");
        } else {
            System.out.println("ERROR: Student " + student.getFullName() + " is not in the group and cannot be " +
                    "removed again");
        }
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public List<String> getStudentNamesList() {
        return studentsList.stream().map(Student::getFullName).collect(Collectors.toList());
    }

    public void printStudentsList() {
        String linkingVerb;
        String pluralForm;

        if (studentsList.size() == 1) {
            linkingVerb = "is";
            pluralForm = "student";
        } else {
            linkingVerb = "are";
            pluralForm = "students";
        }
        System.out.printf("There %s %s %s in '%s': %s\n",
                linkingVerb,
                this.getStudentsList().size(),
                pluralForm,
                this.getGroupName(),
                this.getStudentNamesList());
    }

    public void addTask(String task) {
        if (!taskList.containsKey(task)) {
            List <Student> studentsCompletedTheTask = new ArrayList<>();
            taskList.put(task, studentsCompletedTheTask);
            System.out.println("Task '" + task + "' was assigned to the group");
        } else {
            System.out.println("ERROR: Task '" + task + "' is already assigned to the group and cannot be added again");
        }
    }

    public void setTaskDoneForStudent(String task, Student student) {
        if (taskList.containsKey(task) && studentsList.contains(student)) {
            List <Student> studentsCompletedTheTask = taskList.get(task);
            studentsCompletedTheTask.add(student);

            taskList.put(task, studentsCompletedTheTask);
            System.out.println("Task '" + task + "' was set to done for student " + student.getFullName());
        } else if (!taskList.containsKey(task)) {
            System.out.println("ERROR: Task '" + task + "' is not in the list of available tasks for group");
        } else {
            System.out.println("ERROR: Student " + student.getFullName() + " is not in the list of available students in " +
                    "the group");
        }
    }

    public void printStudentsCompletedTheTask(String task) {
        if (taskList.containsKey(task)) {
            List<String> studentsCompletedTheTaskNames = new ArrayList<>();
            List <Student> studentsCompletedTheTask = taskList.get(task);
            studentsCompletedTheTask.forEach((studentItem) -> studentsCompletedTheTaskNames.add(studentItem.getFullName()));
            System.out.printf("Students who completed the task '%s' are: %s\n", task, studentsCompletedTheTaskNames);
        } else {
            System.out.printf("ERROR: The task '%s' is not in the list of assigned tasks", task);
        }
    }
}
