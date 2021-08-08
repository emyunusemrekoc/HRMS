package kodlamaio.hrms.entities.concretes;

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
@Table(name="candidate_languages")
public class CandidateLanguage {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="candidate_id",referencedColumnName = "id")
	private Candidate candidate;
	
	@Column(name="language")
	private String language;
	
	@Column(name="language_level")
	private short languageLevel;
	
	
	
	
}
