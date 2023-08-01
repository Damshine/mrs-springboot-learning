package com.github.mrs.mapper;

import com.github.mrs.pojo.Course;
import com.github.mrs.pojo.Student;
import com.github.mrs.vo.StudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * description:
 * date: 2023/7/20 14:38
 * author: MR.孙
 */
@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    /* 普通对象转换 */
    @Mappings({
            @Mapping(source = "gender.name", target = "gender"),
            @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    StudentVO studentToStudentVo(Student student);

    /* List对象转换 */
    List<StudentVO> studentToListStudentVo(List<Student> student);

    /* 多个对象转换为一个对象 */
    @Mapping(source = "student.gender.name", target = "gender")
    @Mapping(source = "student.birthday", target = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "course.courseName", target = "course")
    StudentVO studentAndCourseToStudentVO(Student student, Course course);

}
