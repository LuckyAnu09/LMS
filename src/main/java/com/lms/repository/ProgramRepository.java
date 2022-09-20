package com.lms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.entity.Program;


@Repository
public interface ProgramRepository extends JpaRepository <Program,Long>{

	Program findByProgramID(Long programID);

}
