package utilities; // 确保包名与目录结构相匹配

import entities.Course;
import java.util.List; // 导入 List 接口

public class Main {
    public static void main(String[] args) {
        CourseFileParser parser = new CourseFileParser(); // 正在使用 CourseFileParser
        List<Course> courses = parser.parseCoursesFromFile("D:/demo/java实验/实验四/utilities/courses.txt");


        // 打印课程信息以验证它们是否被正确解析
        for (Course course : courses) {
            System.out.println("课程ID: " + course.getId());
            System.out.println("课程名称: " + course.getCourseName());
            // ...打印所需的其他细节
        }
    }
}
