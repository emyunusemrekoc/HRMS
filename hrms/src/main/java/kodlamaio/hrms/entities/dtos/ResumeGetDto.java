package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.ResumeCoverLetter;
import kodlamaio.hrms.entities.concretes.ResumeEducation;
import kodlamaio.hrms.entities.concretes.ResumeExperience;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;
import kodlamaio.hrms.entities.concretes.ResumeLink;
import kodlamaio.hrms.entities.concretes.ResumeSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeGetDto {
	
	@JsonIgnore
	private int id;
	private int candidateId;
	private String about;
	private String resumeName;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private List<ResumeLanguage> languages;
	private List<ResumeSkill> skills;
	private List<ResumeEducation> educations;
	private List<ResumeExperience> experiences;
	private List<ResumeCoverLetter> coverLetters;
	private List<ResumeLink> links;
	

}
