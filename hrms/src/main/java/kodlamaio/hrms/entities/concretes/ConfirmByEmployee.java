package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="confirm_by_employees")
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmByEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@ManyToOne()
	@JoinColumn(name="employers_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="employees_id")
	private Employee employee;
	

}
