package com.lms.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dto.ProgramRequest;
import com.lms.entity.*;
import com.lms.exception.ProgramNotFoundException;
import com.lms.service.*;


@RestController

public class ProgramController {

	@Autowired
	 ProgramService programService;

	// get all programs
	@GetMapping("/program")
	public List<Program> getPrograms() {
		return programService.getPrograms();
	}

	// get program by id
	@GetMapping("/program/{id}")
	public Program findProgram(@PathVariable Long id) throws ProgramNotFoundException {
		return programService.findProgram(id);
	}

	// post program- create a new program
	@PostMapping("/program")
	public Program createProgram(@Valid @RequestBody ProgramRequest newProgram) {
		return programService.createProgram(newProgram);
	}
	
	//put mapping- if id exists update else create new record
	
	@PutMapping("/program/{id}") 
	public Program updateOrCreateProgram(
			@Valid @RequestBody ProgramRequest updateProgram ,
			@PathVariable Long id) throws ProgramNotFoundException
	{
		return programService.updateOrCreateProgram(updateProgram,id);
	}
	//delete program
	@DeleteMapping("/program/{id}")
	public void deleteProgram(@PathVariable Long id) throws ProgramNotFoundException
	{
		 programService.deleteProgram(id);
	}
	

}
