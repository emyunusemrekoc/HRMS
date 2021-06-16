package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeCoverLetterDto {
	
	
	private int id;
	//private int resumeId;
	private String title;
	private String coverLetter;
	

}
