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
	@JsonIgnore
	private int id;
	private int resumeId;
	private int degreeId;
	private String schoolName;
	private String schoolDepartment;
	private Date startedDate;
	private Date endDate;
	
	

}
