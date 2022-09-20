package com.lms.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="tbl_lms_batch")
public class Batch {
	
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="batch_id")
	private Long batchId;
	
	@NotBlank (message = "Batch Name is mandatory")
	@Column(name="batch_name")
	private String batchName;
	
	@Column(name="batch_description")
	private String batchDescription;
	
	@NotBlank (message = "Batch Status is mandatory")
	@Column(name="batch_status")
	private String batchStatus;
	
	@Positive
	@NotNull(message = "batch_program_id is mandatory")
	@Column(name="batch_program_id")
	private Long batchProgramId;
	
	@ManyToOne
    @JoinColumn(
            name = "batch_program_id"  , insertable = false, updatable = false
    )
   	private Program program;
	
	@Positive
	@NotNull (message = "Batch No of Classes is mandatory")
	@Column(name="batch_no_of_classes")
	private Long batchNoOfClasses;
	
	@CreationTimestamp
	@Column(name = "creation_time", nullable = false)
	private LocalDateTime createdTime;
	
	@UpdateTimestamp
	@Column(name = "last_mod_time", nullable = false)
    private LocalDateTime updatedTime;
	
	public Batch( String batchName, String batchDescription,
			 String batchStatus,Long batchProgramId,
			 Program batchProgram ,
			Long batchNoOfClasses) {
		super();
		this.batchName = batchName;
		this.batchDescription = batchDescription;
		this.batchStatus = batchStatus;
		this.batchProgramId = batchProgramId;
		this.program = batchProgram;
		this.batchNoOfClasses = batchNoOfClasses;
	}


}
