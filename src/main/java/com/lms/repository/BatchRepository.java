package com.lms.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lms.dto.BatchProgram;
import com.lms.entity.Batch;
import com.lms.entity.Program;


@Repository
public interface BatchRepository extends JpaRepository<Batch,Long>{

	Optional<Batch> findByBatchDescription(String batchDescription);

	public Batch findByBatchId(Long batchID);
	
	
	
	/*@org.springframework.data.jpa.repository.Query(nativeQuery = true,value="select ba.batch_id,ba.batch_name,ba.batch_description, pro.program_name\r\n"
			+ "from tbl_lms_batch ba\r\n"
			+ "join tbl_lms_program pro\r\n"
			+ "ON pro.program_id = ba.batch_program_id where ba.batch_program_id = :batch_program_id" )
	public List<BatchProgram> findByBatchProgramId (@Param("batch_program_id")Long batch_program_id);
*/
	List<Batch> findByBatchProgramId(Long batch_program_id);
	

}
