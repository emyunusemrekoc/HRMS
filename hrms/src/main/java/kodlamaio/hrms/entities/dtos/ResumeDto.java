package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;

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
public class ResumeDto {
	
	
	private int id;
	private int candidateId;
	private String about;
	@NotBlank(message = "Özgeçmiş ismi boş bırakılamaz")
	private String resumeName;
	@JsonIgnore
	private LocalDateTime createdDate;
	@JsonIgnore
	private LocalDateTime updatedDate;
	private List<ResumeLanguage> languages;
	private List<ResumeSkill> skills;
	private List<ResumeEducation> educations;
	private List<ResumeExperience> experiences;
	private List<ResumeCoverLetter> coverLetters;
	private List<ResumeLink> links;
	

}
