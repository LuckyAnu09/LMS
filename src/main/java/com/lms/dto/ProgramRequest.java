package com.lms.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor (staticName = "build")
@NoArgsConstructor
public class ProgramRequest {
	
	@NotNull (message = "Program Name is mandatory")
	private String programName;
	
	private String programDescription;
	
	@NotNull (message = "program_status is mandatory")
	private String programStatus;

	@JsonIgnore
	@UpdateTimestamp
  //  @Column(name = "last_mod_time", nullable = false)
    private LocalDateTime updateDateTime;

}
