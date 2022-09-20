package com.lms.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor (staticName = "batchReq")

public class BatchRequest {
	
	@NotBlank (message = "Batch Name is mandatory")
	public String batchName;
	
	public String batchDescription;
	
	@NotBlank (message = "Batch Status is mandatory")
	public String batchStatus;
	
	@Positive
	@NotNull
	 (message = "Batch No of Classes is mandatory")
	public Long batchNoOfClasses;
	
	@Positive
	@NotNull
	(message = "Batch ProgramID is mandatory")
	public Long batchProgramId;
	
	@JsonIgnore
	@UpdateTimestamp
  //  @Column(name = "last_mod_time", nullable = false)
    private LocalDateTime updatedTime;

}
