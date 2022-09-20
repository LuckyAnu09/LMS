package com.lms.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "program_request")

@ToString
@Table(name = "tbl_lms_program")
public class Program {

	

	@Id
	 @GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="program_id")
	private Long programID;

	@NotBlank (message = "Program Name is mandatory")
	@Column(name="program_name")
	private String programName;

	
	@Column(name="program_description")
	private String programDescription;

	@NotBlank (message = "program_status is mandatory")
	@Column(name="program_status")
	private String programStatus;


	@CreationTimestamp
	@Column(name = "creation_time", nullable = false)
	private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "last_mod_time", nullable = false)
    private LocalDateTime updateDateTime;

   @JsonIgnore
   @OneToMany
    (mappedBy="program")
    private List<Batch> batches;
   
   public Program( String programName, String programDescription,
			 String programStatus) {
		super();
		this.programName = programName;
		this.programDescription = programDescription;
		this.programStatus = programStatus;
	}



}