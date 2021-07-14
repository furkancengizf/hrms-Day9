package HRMSDemo.hrms.entities.concretes;

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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_img")
public class ResumeImage {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int resumeImageId;

	    @Column(name = "img_link")
	    private String imgLink;

	    @Column(name = "uploaded_date")
	    private String uploadedDate;

	    @ManyToOne()
	    @JoinColumn(name = "employee_id")
	    private Employee employee;
}