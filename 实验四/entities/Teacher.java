package entities;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<Course> teachingCourses = new ArrayList<>();

    public Teacher(int id, String name, String gender) {
        super(id, name, gender);
    }

    public void addTeachingCourse(Course course) {
        this.teachingCourses.add(course);
    }

    public List<Course> getTeachingCourses() {
        return teachingCourses;
    }

    // 如果需要，可以添加其他getter和setter方法
}
