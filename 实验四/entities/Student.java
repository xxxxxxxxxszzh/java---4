package entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private List<Course> selectedCourses = new ArrayList<>();

    public Student(int id, String name, String gender) {
        super(id, name, gender);
    }

    public void addSelectedCourse(Course course) {
        this.selectedCourses.add(course);
    }

    // Getter for selectedCourses
    public List<Course> getSelectedCourses() {
        return selectedCourses;
    }

    // Assuming getters for id and name are defined in Person class
}
