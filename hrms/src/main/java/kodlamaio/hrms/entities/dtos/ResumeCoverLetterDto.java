package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeCoverLetterDto {
	@JsonIgnore
	private int id;
	private int resumeId;
	private String title;
	private String coverLetter;
	

}
