package com.lms.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lms.dto.BatchRequest;
import com.lms.entity.Batch;
import com.lms.entity.Program;
import com.lms.exception.BatchNotFoundException;
import com.lms.exception.ProgramNotFoundException;
import com.lms.pojo.BatchProgramID;
import com.lms.repository.BatchRepository;
import com.lms.repository.ProgramRepository;

@Service
public class BatchService {

	@Autowired
	BatchRepository br;
	
	@Autowired
	ProgramRepository pr;
	
	public List<Batch> getBatches() {
		
		return br.findAll();
	}
	public Batch getBatchbyID(Long batchId) throws BatchNotFoundException {
		
		Batch batch = br.getById(batchId);
		if(batch!=null)
		{		
		return batch;
		}
		else
		{
			throw new BatchNotFoundException("Batch not found with ID: " + batchId);
		}
	}
	public Batch createBatch(@Valid BatchRequest newBatchRequest) throws ProgramNotFoundException {
		
		Program program = pr.findByProgramID(newBatchRequest.getBatchProgramId());
		if (program != null) {
		Batch newBatch = new Batch
				(newBatchRequest.batchName,newBatchRequest.batchDescription,newBatchRequest.batchStatus,
						newBatchRequest.getBatchProgramId(),program,newBatchRequest.batchNoOfClasses);
		
		return br.save(newBatch);
		}
		
		else
		{
			throw new ProgramNotFoundException("Program not found with ID : " + newBatchRequest.getBatchProgramId());
		}
			
	}
	public Optional<Batch> getBatchByDescription(String batchDescription) {
		
		return br.findByBatchDescription(batchDescription);
	}
	public Batch deleteBatch(Long batchID) throws BatchNotFoundException {
		
		Batch batch = br.getById(batchID);
		if(batch!=null)
		{
			 br.deleteById(batchID);
			 return batch;
		}
	
		else
			{
			throw new BatchNotFoundException("Batch with given ID Not found : "+ batchID);
			
			}
	}
	public Batch updateBatch(@Valid BatchRequest updateBatch , Long batchID) throws BatchNotFoundException, ProgramNotFoundException {
		
		Batch batch = br.findByBatchId(batchID);
		Program program = pr.findByProgramID(updateBatch.getBatchProgramId());
		if(batch!=null)
		{
			if(program!=null)
			{
				batch.setBatchName(updateBatch.getBatchName());
				batch.setBatchDescription(updateBatch.getBatchDescription());
				batch.setBatchStatus(updateBatch.getBatchStatus());
				batch.setBatchNoOfClasses(updateBatch.getBatchNoOfClasses());
				batch.setBatchProgramId(updateBatch.getBatchProgramId());
				batch.setUpdatedTime(updateBatch.getUpdatedTime());
				return br.save(batch);
			}
			
			else
				
			{
				throw new ProgramNotFoundException("Program Not found with batch_program_id: "+ updateBatch.getBatchProgramId() );
			}
		}
		
		else
		{
			throw new BatchNotFoundException("Batch not found with ID: "+batchID);
		}
		
		
		
	}
	
	
/*	public Batch saveBatch(BatchProgramID batchProgram) {
	
		Program program = pr.findByProgramID(batchProgram.getBatchProgramId());
		
		
		Batch newBatch = new Batch();
		
		newBatch.setBatchName(batchProgram.getBatchName());
		newBatch.setBatchDescription(batchProgram.getBatchDescription());
		newBatch.setBatchNoOfClasses(batchProgram.getBatchNoOfClasses());
		newBatch.setBatchStatus(batchProgram.getBatchStatus());
		newBatch.setProgram(program);
		
		return br.save(newBatch);
		
	}
*/
}
