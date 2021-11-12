package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("thofmann2104@gmail.com")
                .firstName("Thomas")
                .lastName("Hofmann")
                //.guardianName("Landerer")
                //.guardianEmail("clanderer@tsn.at")
                //.guardianMobile("06608150815")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("clanderer@tsn.at")
                .name("Landerer")
                .mobile("06767654321")
                .build();

        Student student = Student.builder()
                .firstName("Sack-Voll")
                .lastName("Hirschhoara")
                .emailId("sack.voll@hirschhoara.at")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }


    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = "+studentList);
    }
}