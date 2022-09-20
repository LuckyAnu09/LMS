package com.lms.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.repository.ProgramRepository;
import com.lms.dto.ProgramRequest;
import com.lms.entity.*;
import com.lms.exception.ProgramNotFoundException;

@Service
public class ProgramService {

	@Autowired
	ProgramRepository pr;

	public ProgramService() {

	}

	public List<Program> getPrograms() {

		return pr.findAll();
	}

	public Program createProgram(@Valid ProgramRequest programRequest) {

		Program newProgram = new Program

		(programRequest.getProgramName(), programRequest.getProgramDescription(), programRequest.getProgramStatus());

		return pr.save(newProgram);
	}

	public Program findProgram(Long id) throws ProgramNotFoundException {

		Program program = pr.findByProgramID(id);

		if (program != null) {
			return program;
		} else {
			throw new ProgramNotFoundException("Program not found with ID : " + id);
		}
	}

	public void deleteProgram(Long id) throws ProgramNotFoundException {
		Program program = pr.findByProgramID(id);
		if (program != null) {
			pr.deleteById(id);
		}

		else {
			throw new ProgramNotFoundException("Program not found with ID: " + id);

		}

	}

	public Program updateOrCreateProgram(@Valid ProgramRequest updateProgram, Long id) throws ProgramNotFoundException {

		Program program = pr.findByProgramID(id);
		if (program != null) {
			program.setProgramName(updateProgram.getProgramName());
			program.setProgramDescription(updateProgram.getProgramDescription());
			program.setProgramStatus(updateProgram.getProgramStatus());
			program.setUpdateDateTime(updateProgram.getUpdateDateTime());
			return pr.save(program);
		}

		else {
			
			throw new ProgramNotFoundException("Program Not found:"+id);
			
			/*Program newProgram = new Program

			(updateProgram.getProgramName(), updateProgram.getProgramDescription(), updateProgram.getProgramStatus());

			return pr.save(newProgram);*/

		}
		/*
		 * if (pr.findById(id).isPresent()) { Program pID = this.pr.getById(id);
		 * pID.setProgramID(id);
		 * 
		 * pID.setProgramName(updateProgram.getProgramName());
		 * 
		 * pID.setProgramDescription(updateProgram.getProgramDescription());
		 * 
		 * pID.setProgramStatus(updateProgram.getProgramStatus());
		 * 
		 * pID.setCreateDateTime(pID.getCreateDateTime());
		 * 
		 * pID.setUpdateDateTime(updateProgram.getUpdateDateTime()); return
		 * pr.save(pID); } else return pr.save(updateProgram);
		 */
	}
}
