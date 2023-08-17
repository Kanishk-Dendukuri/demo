package com.sos.schools.service;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.sos.schools.apis.StudentResource;
import com.sos.schools.dao.studentDAO;
import com.sos.schools.exception.StudentNotFoundException;
import com.sos.schools.model.Student;
import com.sos.schools.model.CreateStudentModel;
import com.sos.schools.model.UpdateStudentModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
@Service
public class StudentService {
    Logger logger = (Logger) LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    private studentDAO repository;

    private int studentIdCount = 1;

    private List<Student> studentList = new CopyOnWriteArrayList<>();


    public Student addStudent(CreateStudentModel createStudentModel){
//        student.setStudentId(studentIdCount);
//        studentList.add(student);
//        studentIdCount++;
//        return student;
        Student student = new Student (createStudentModel.getFirstName(),
                            createStudentModel.getLastName(), createStudentModel.getEmail());


        return repository.save(student);
    }

    public List<Student> getStudents() {
        return repository.findAll();
//        return studentList;
    }

    public Student getStudent(int studentId){
        Student student = repository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found - " + studentId));
        return student;
//        return student.get();
//        return studentList.get(studentID);
//        return studentList
//                .stream()
//                .filter(d -> d.getStudentId()==studentId)
//                .findFirst().get();
    }

//    public Student updateStudentName(int studentId,String firstName, String lastName) {
//        Student student = repository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found - " + studentId));
//        student.setStudentFirstName(firstName);
//        student.setStudentLastName(lastName);
//        return repository.save(student);
//    }
//
//    public Student updateStudentName(int studentId,String firstName) {
//        Student student = repository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found - " + studentId));
//        student.setStudentFirstName(firstName);
//        return repository.save(student);
//    }
//    public Student updateStudentEmail(int studentId,String email) {
//        Student student = repository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found - " + studentId));
//        student.setStudentEmail(email);
//        return repository.save(student);
//    }

//    public Student updateStudent(int studentId, Student student){
//        student.setStudentId(studentId);
//        return repository.save(student);
//        studentList
//                .stream()
//                .forEach(d -> {
//                    if(d.getStudentId() == studentId) {
//                        d.setStudentFirstName(student.getStudentFirstName());
//                        d.setStudentLastName(student.getStudentLastName());
//                        d.setStudentEmail(student.getStudentEmail());
//                    }
//                });
//        // return studentList.get(studentID);
//        return studentList
//                .stream()
//                .filter(d -> d.getStudentId() == studentId)
//                .findFirst() //.orElseThrow();
//                .orElseThrow(() -> new IllegalArgumentException("No student found with this id"));
//    }

    public Student updateStudent(@Valid UpdateStudentModel updateStudentModel){
        Student student = repository.findById(updateStudentModel.getId()).orElseThrow(() -> new StudentNotFoundException("Student id not found - " + updateStudentModel.getId()));
        student.setFirstName(updateStudentModel.getFirstName());
        student.setLastName(updateStudentModel.getLastName());
        student.setEmail(updateStudentModel.getEmail());
        return repository.save(student);
    }


    public void deleteStudent(int studentId){
        try {
            repository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found - " + studentId));
            repository.deleteById(studentId);
        }catch (StudentNotFoundException w){
            logger.error("Student with ID " + studentId + " not Found");
        }

//        studentList
//                .stream()
//                .forEach(d -> {
//                    if(d.getStudentId() == studentId) {
//                        studentList.remove(d);
//                    }
//                });
    }


}
