package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeExperienceDto {
	
	@JsonIgnore
	private int id;
	private int resumeId;
	private int jobTitleId;
	private String companyName;
	private Date startedDate;
	private Date endDate;
	private boolean isContinuing;
	
	

}
