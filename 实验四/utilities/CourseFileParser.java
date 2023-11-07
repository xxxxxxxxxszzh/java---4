package utilities;

import entities.Course;
import entities.Teacher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseFileParser {

    public List<Course> parseCoursesFromFile(String fileName) {
        List<Course> courses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] courseData = line.split(",");
                if (courseData.length == 5) {
                    int id = Integer.parseInt(courseData[0].trim());
                    String courseName = courseData[1].trim();
                    String location = courseData[2].trim();
                    String time = courseData[3].trim();

                    Teacher teacher = new Teacher(0, "未知", "未知");

                    Course course = new Course(id, courseName, location, time, teacher);
                    courses.add(course);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
