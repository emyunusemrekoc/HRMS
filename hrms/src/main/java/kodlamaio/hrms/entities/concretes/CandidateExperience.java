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
@Table(name = "candidate_experiences")
public class CandidateExperience {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonIgnore
	//@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name="candidate_id",referencedColumnName = "id")
	private Candidate candidate;
	
	@ManyToOne()
	@JoinColumn(name="job_title_id",referencedColumnName = "id")
	private JobTitle jobTitle;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="started_date")
	private Date startedDate;
	
	@Column(name="end_date")
	private Date endDate;
	
//	@Column(name="is_continuing")
//	private boolean isContinuing;
	
	
	

}
