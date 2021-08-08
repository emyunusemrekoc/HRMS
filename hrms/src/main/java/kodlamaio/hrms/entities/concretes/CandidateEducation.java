package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="candidate_educations")
public class CandidateEducation {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonIgnore
	//@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name="Candidate_id",referencedColumnName = "id")
	private Candidate candidate;
	
	@ManyToOne()
	@JoinColumn(name="degree_id",referencedColumnName = "id")
	private CandidateEduDegree degree;	
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="school_department")
	private String schoolDepartment;
	
	@Column(name="started_date")
	private Date startedDate;
	
	@Column(name="end_date")
	private Date endDate;
	
}
