# java---4
# JAVA 类继承与文件保存实验报告

## 一、实验目的

- 探索类的继承机制以及如何通过继承简化代码和增强复用性。
- 使用`super()`调用父类构造方法，保证属性正确初始化。
- 学习Java的访问修饰符，掌握其在类属性和方法可见性中的应用。
- **实现学生选课信息的持久化保存，深入理解文件I/O操作。（要求1：实现文本文件的格式读写）**

## 二、设计思路

通过创建基础的`Person`类作为`Student`和`Teacher`类的父类，本实验旨在通过继承机制共享属性和方法。在此基础上，实现学生的课程选择功能，**并将选择结果持久化到文件中保存，以此来理解和掌握Java的文件I/O操作。**

## 三、类的设计

### Course类

课程信息类，关联特定的教师对象。

### Person类（父类）

定义通用属性如`id`，`name`和`gender`，是`Student`和`Teacher`类的基类。

### Student类（子类）

从`Person`类继承，增加管理选课信息的功能。

### Teacher类（子类）

从`Person`类继承，增加管理授课信息的功能。

## 四、实验内容与步骤

1. 定义`Person`类以及其子类`Student`和`Teacher`。
2. 实现`Course`类，并建立与`Teacher`的关联。
3. 子类通过`super()`调用父类构造方法。
4. **实现`saveCourseSelection`方法，将选课信息写入文件。**
5. 在测试类中模拟学生选课流程，并观察结果。

## 五、实验结果
---
学生编号：1001
学生姓名：李四
---

- 课程名称：Java编程
- 上课地点：教学楼A201
- 上课时间：周三 3-5节
- 授课教师：张三

---

- 课程名称：Python编程
- 上课地点：教学楼B202
- 上课时间：周四 4-6节
- 授课教师：李华

---
学生编号：1002
学生姓名：王五
---
- 课程名称：Java编程
- 上课地点：教学楼A201
- 上课时间：周三 3-5节
- 授课教师：张三

---

- 课程名称：Web开发
- 上课地点：教学楼C203
- 上课时间：周五 5-7节
- 授课教师：张三

---


## 六、文件保存实现

**通过实现`saveCourseSelection`方法，本实验不仅在控制台输出了学生的选课信息，也将这些信息写入了以学生ID命名的文本文件。这一过程展示了如何在Java中结合继承和文件操作，实现数据的持久化。**

```java
public static void saveCourseSelection(Student student) {
    String fileName = "student_" + student.getId() + "_courses.txt";
    // Creating content to save
    StringBuilder contentBuilder = new StringBuilder();
    contentBuilder.append("学生编号：").append(student.getId()).append("\n");
    contentBuilder.append("学生姓名：").append(student.getName()).append("\n");

    for (Course c : student.getSelectedCourses()) {
        contentBuilder.append("课程名称：").append(c.getCourseName()).append("\n");
        contentBuilder.append("上课地点：").append(c.getLocation()).append("\n");
        contentBuilder.append("上课时间：").append(c.getTime()).append("\n");
        contentBuilder.append("授课教师：").append(c.getTeacher().getName()).append("\n");
        contentBuilder.append("----\n");
    }
    
    // Writing to file 写入文件
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        writer.write(contentBuilder.toString());
        System.out.print(contentBuilder.toString()); // Also print to console 输出到控制台
        writer.flush();
    } catch (IOException e) {
        e.printStackTrace(); // Handle potential IO exceptions in a real-world scenario
    }
}
```

## 七、实验总结

通过本实验，我们不仅加深了对Java继承机制的理解，还学习了如何使用Java进行文件操作。通过实践，我们认识到了继承如何简化代码设计，**以及如何利用文件I/O将数据持久化，**这在的应用程序开发中非常重要。
