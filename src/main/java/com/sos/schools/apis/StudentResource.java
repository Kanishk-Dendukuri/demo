package com.sos.schools.apis;

import com.sos.schools.model.Student;
import com.sos.schools.model.CreateStudentModel;
import com.sos.schools.model.UpdateStudentModel;
import com.sos.schools.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentResource {
    Logger logger = (Logger) LoggerFactory.getLogger(StudentResource.class);
    @Autowired
    private StudentService studentService;

//    @PostMapping
//    public Student addStudent(@RequestBody @Valid CreateStudentModel createStudentModel){
//        return studentService.addStudent(createStudentModel);
//    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody CreateStudentModel createStudentModel){

        logger.info("INFO Creating Student");
        return new ResponseEntity<>(studentService.addStudent(createStudentModel), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody @Valid UpdateStudentModel updateStudentModel){
        logger.info("INFO Updating Student");
        return new ResponseEntity<>(studentService.updateStudent(updateStudentModel),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        logger.info("INFO Getting Students");
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable int studentId){
        logger.info("INFO Getting Student With ID " + studentId);
        return ResponseEntity.ok(studentService.getStudent(studentId));
    }

//    @PutMapping("/{studentId}")
//    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student){
//        return studentService.updateStudent(studentId,student);
//    }
//    @PutMapping("/{studentId}/updateName/{firstName}/{lastName}")
//    public Student updateStudentName(@PathVariable int studentId, @PathVariable String firstName,@PathVariable String lastName){
//        return studentService.updateStudentName(studentId,firstName,lastName);
//    }
//    @PutMapping("/{studentId}/updateName/{firstName}")
//    public Student updateStudentName(@PathVariable int studentId, @PathVariable String firstName){
//        return studentService.updateStudentName(studentId,firstName);
//    }
//    @PutMapping("/{studentId}/updateEmail/{email}")
//    public Student updateStudentEmail(@PathVariable int studentId, @PathVariable String email){
//        return studentService.updateStudentEmail(studentId,email);
//    }




    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId){
        logger.warn("WARN Deleting Student");
        studentService.deleteStudent(studentId);
    }


}
