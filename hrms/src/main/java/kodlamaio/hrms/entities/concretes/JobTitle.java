package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // bu classin bir entity olduğunu belirtir.
@Data // getter setter oluşturur
@Table(name="job_titles") // sql tablosuyla eşleştirir
@AllArgsConstructor // bizim yerimize constructor oluşturur 
@NoArgsConstructor // içi boş constructorları oluşturur
public class JobTitle {
	
	@Id // jobtitles primary keyi id dir demek. veritabanınındaki idyi belirtir.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // idyi nasıl artıracağımızı belirtiyoruz
	
	@Column(name="id") // sql ile tabloları eşleştirir.
	private int id;
	
	@Column(name="title")
	private String title;
	

	
}
