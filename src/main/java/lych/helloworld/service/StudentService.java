package lych.helloworld.service;

import lych.helloworld.model.Student;

import java.util.List;


/**
 * Interface for work with Student Service
 */
public interface StudentService {

    /**
     * Implementation addition Student to Data Base
     *
     * @param student
     * @return "Message about successful work"
     */
    Student addStudent(Student student);

    /**
     * Implementation renewal Student in Data Base
     *
     * @param student
     * @return "Message about successful work"
     */
    Student updateStudent(Student student);

    /**
     * Implementation delete Student from Data Base by Id
     *
     * @param id
     */
    void removeStudent(Integer id);

    /**
     * Display Student from Data Base by Id
     *
     * @param id
     * @return object of Student class
     */
    Student getStudentById(Integer id);

    /**
     * Display all Students from Data Base
     *
     * @return List objects of Student class
     */
    List<Student> listStudents();
}
