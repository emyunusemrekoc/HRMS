package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateExperienceGetDto {
	
	
	private int id;
	private int candidateId;
	private String jobTitleTitle;
	private String companyName;
	private Date startedDate;
	private Date endDate;

	

}
