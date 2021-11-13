package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseGit = Course.builder()
                .title("Git")
                .credit(10)
                .build();

        Course courseSpringBoot = Course.builder()
                .title("SpringBoot")
                .credit(1234)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Claudio")
                .lastName("Landerer")
                //.courses(List.of(courseGit, courseSpringBoot))
                .build();

        teacherRepository.save(teacher);
    }
}