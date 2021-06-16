//package kodlamaio.hrms.entities.dtos;
//
//import java.time.LocalDateTime;
//
//import javax.validation.constraints.NotBlank;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class ResumeAddDto {
//
//	@JsonIgnore
//	private int id;
//	private int candidateId;
//	private String about;
//	@NotBlank(message = "Özgeçmiş ismi boş bırakılamaz")
//	private String resumeName;
//	@JsonIgnore
//	private LocalDateTime createdDate;
//	@JsonIgnore
//	private LocalDateTime updatedDate;
//
//}
