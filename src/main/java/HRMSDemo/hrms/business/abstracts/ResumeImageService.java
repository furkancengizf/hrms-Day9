package HRMSDemo.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import HRMSDemo.hrms.core.utilities.results.DataResult;
import HRMSDemo.hrms.core.utilities.results.Result;
import HRMSDemo.hrms.entities.concretes.ResumeImage;

public interface ResumeImageService {
    Result add(MultipartFile photoFile, int employeeId);
    Result delete(int id);
    DataResult<ResumeImage> getByEmployee_Id(int employeeId);
    DataResult<ResumeImage> getByResumeImageId(int id);
}
