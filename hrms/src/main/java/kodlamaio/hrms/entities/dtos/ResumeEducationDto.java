package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeEducationDto {
	
	
	private int id;
	//private int resumeId;
	private String degreeEduDegree;
	private String schoolName;
	private String schoolDepartment;
	private Date startedDate;
	private Date endDate;
	
	

}
