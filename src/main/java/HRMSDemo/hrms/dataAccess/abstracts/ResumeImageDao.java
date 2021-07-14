package HRMSDemo.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSDemo.hrms.entities.concretes.ResumeImage;

public interface ResumeImageDao extends JpaRepository<ResumeImage, Integer>{
	ResumeImage getByEmployee_Id(int employeeId);
	ResumeImage getByResumeImageId(int id);
}
