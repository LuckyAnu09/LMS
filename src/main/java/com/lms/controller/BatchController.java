package com.lms.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dto.BatchRequest;
import com.lms.entity.Batch;
import com.lms.exception.BatchNotFoundException;
import com.lms.exception.ProgramNotFoundException;
import com.lms.dto.BatchProgram;

import com.lms.service.BatchService;

@RestController
public class BatchController {

	@Autowired
	BatchService batchService;
	
	//Get Batches
	@GetMapping("/batch")
	public List<Batch> getBatches()
	{
		return batchService.getBatches();
	}
	
	//get Batch by ID
	
	@GetMapping("/batch/{id}")
	public Batch getBatchbyID(@PathVariable(value="id") Long batchId) throws BatchNotFoundException{
		return batchService.getBatchbyID(batchId);
		
	}
	
	//post or create batch
	@PostMapping("/batch")
	public Batch createBatch(@Valid @RequestBody BatchRequest newBatchRequest) throws ProgramNotFoundException
	{
		return batchService.createBatch(newBatchRequest);
	}
	
	//updateExistingBatch
	@PutMapping("/batch/{id}")
	public Batch updateBatch(@Valid @RequestBody BatchRequest updateBatch , @PathVariable(value="id") Long batchID) throws BatchNotFoundException, ProgramNotFoundException
	{
		return batchService.updateBatch(updateBatch,batchID);
	}
	//Delete Batch
	@DeleteMapping("/batch/{id}")
	public Batch deleteBacth(@PathVariable(value="id") Long batchID) throws BatchNotFoundException
	{
		return batchService.deleteBatch(batchID);
	}
	
	@GetMapping("batchProgram/{batch_program_id}")
	public List<BatchProgram> getBatchByProgram(@PathVariable(value="batch_program_id") Long batch_program_id) throws ProgramNotFoundException
	{
		return batchService.getBatchProgram(batch_program_id);
	}
	
	
	
	
	
	
	//post batch with program ID
	
	/*@PostMapping("/batchProgramID")
	public Batch saveBatch(@RequestBody BatchProgramID batchProgram)
	{
		return batchService.saveBatch(batchProgram);
	}*/
	
	
	/*@GetMapping("/batchName")
	public Optional<Batch> getBatchByDescription( String batchDescription){
		return batchService.getBatchByDescription(batchDescription);
	}
	*/
	
}
