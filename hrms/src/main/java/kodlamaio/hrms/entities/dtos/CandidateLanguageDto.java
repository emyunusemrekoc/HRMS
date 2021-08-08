package kodlamaio.hrms.entities.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateLanguageDto {
	
	
	private int id;
	private int candidateId;
	private String language;
	@Max(5)
	@Min(1)
	private short languageLevel;

}
