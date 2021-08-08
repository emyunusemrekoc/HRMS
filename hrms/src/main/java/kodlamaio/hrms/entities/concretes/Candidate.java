package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper=false)
public class Candidate extends User{

	@Column(name="first_name")
	private String firstName;
	
	@Column(name= "last_name")
	private String lastName;
	
	@Column(name="identification_number" )
	private String identificationNumber;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth; 
	
	
//	@Column(name="cover_letter")
//	private String coverLetter; 
	
	@JsonIgnore
	@OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
	private CandidateCoverLetter coverLetter;
	
}
