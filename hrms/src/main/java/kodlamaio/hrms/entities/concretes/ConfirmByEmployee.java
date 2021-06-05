package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="confirm_by_employees")
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode(callSuper=false)
public class ConfirmByEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@OneToOne()
	@JoinColumn(name="employers_id",referencedColumnName = "id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="employees_id",referencedColumnName = "id")
	private Employee employee;
	
	@JsonIgnore
	@Column(name="confirmed_date")
	private LocalDateTime confirmedDate;

}
