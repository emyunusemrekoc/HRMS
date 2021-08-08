package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateEducationGetDto {
	
	
	private int id;
	private int candidateId;
	private String degreeEduDegree;
	private String schoolName;
	private String schoolDepartment;
	private Date startedDate;
	private Date endDate;
	
	

}
