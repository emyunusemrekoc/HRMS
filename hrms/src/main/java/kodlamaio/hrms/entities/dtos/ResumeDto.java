//package kodlamaio.hrms.entities.dtos;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import javax.validation.constraints.NotBlank;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import kodlamaio.hrms.entities.concretes.CandidateCoverLetter;
//import kodlamaio.hrms.entities.concretes.CandidateEducation;
//import kodlamaio.hrms.entities.concretes.CandidateExperience;
//import kodlamaio.hrms.entities.concretes.CandidateLanguage;
//import kodlamaio.hrms.entities.concretes.CandidateLink;
//import kodlamaio.hrms.entities.concretes.CandidateSkill;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class ResumeDto {
//	
//	
//	private int id;
//	private int candidateId;
//	//private String about;
//	@NotBlank(message = "Özgeçmiş ismi boş bırakılamaz")
//	private String resumeName;
//	@JsonIgnore
//	private LocalDateTime createdDate;
//	@JsonIgnore
//	private LocalDateTime updatedDate;
////	private List<ResumeLanguage> languages;
////	private List<ResumeSkill> skills;
////	private List<ResumeEducation> educations;
////	private List<ResumeExperience> experiences;
////	private List<ResumeCoverLetter> coverLetters;
////	private List<ResumeLink> links;
//	
//
//}
