package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="candidate_cover_letters")
public class CandidateCoverLetter {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonIgnore
	//@JsonProperty(access = Access.WRITE_ONLY)
	
	@OneToOne()
	@JoinColumn(name="candidate_id",referencedColumnName = "id")
	private Candidate candidate;
	
//	@Column(name="title")
//	private String title;
//	
	@Column(name="cover_letter")
	private String coverLetter;
}
