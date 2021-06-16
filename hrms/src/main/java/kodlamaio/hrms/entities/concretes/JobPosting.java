package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

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
@Entity
@Table(name="job_postings")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="employer_id",referencedColumnName = "id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_title_id",referencedColumnName = "id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name="city_id",referencedColumnName = "id")
	private City city;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPosition;
	@JsonIgnore
	@Column(name="created_date")
	private LocalDate createdDate ;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;

	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "job_posting_name")
	private String jobPostingName;
	
}
