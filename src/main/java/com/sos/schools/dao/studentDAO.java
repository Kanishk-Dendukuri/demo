package com.sos.schools.dao;

import com.sos.schools.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface studentDAO extends JpaRepository<Student,Integer> {


}
