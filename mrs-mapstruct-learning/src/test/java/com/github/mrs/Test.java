package com.github.mrs;

import com.github.mrs.mapper.StudentMapper;
import com.github.mrs.pojo.Course;
import com.github.mrs.pojo.GenderEnum;
import com.github.mrs.pojo.Student;
import com.github.mrs.vo.StudentVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Test {

    public static void main(String[] args) {
        Student student = Student.builder().name("小明").age(6).gender(GenderEnum.Male).height(121.1).birthday(new Date()).build();
        System.out.println(student);
        StudentVO studentVO = StudentMapper.INSTANCE.studentToStudentVo(student);
        System.out.println(studentVO);

        System.out.println("==========List对象转换=============");

        ArrayList<Student> students = new ArrayList<>();
        Student student2 = Student.builder().name("小芳").age(6).gender(GenderEnum.Female).height(121.1).birthday(new Date()).build();
        students.add(student);
        students.add(student2);
        List<StudentVO> studentVOS = StudentMapper.INSTANCE.studentToListStudentVo(students);
        System.out.println(studentVOS);

        System.out.println("==========多个对象转换=============");
        Course course = Course.builder().id(1L).courseName("语文").build();
        StudentVO studentVO2 = StudentMapper.INSTANCE.studentAndCourseToStudentVO(student, course);
        System.out.println(studentVO2);


    }

}
