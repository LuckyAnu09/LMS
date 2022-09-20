package com.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Long>{

	Optional<Batch> findByBatchDescription(String batchDescription);

	Batch findByBatchId(Long batchID);
	

}
