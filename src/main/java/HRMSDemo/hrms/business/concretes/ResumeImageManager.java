package HRMSDemo.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import HRMSDemo.hrms.business.abstracts.EmployeeService;
import HRMSDemo.hrms.business.abstracts.ResumeImageService;
import HRMSDemo.hrms.core.adapter.CloudService;
import HRMSDemo.hrms.core.utilities.results.DataResult;
import HRMSDemo.hrms.core.utilities.results.ErrorResult;
import HRMSDemo.hrms.core.utilities.results.Result;
import HRMSDemo.hrms.core.utilities.results.SuccessDataResult;
import HRMSDemo.hrms.core.utilities.results.SuccessResult;
import HRMSDemo.hrms.dataAccess.abstracts.ResumeImageDao;
import HRMSDemo.hrms.entities.concretes.ResumeImage;
import lombok.var;

@Service
public class ResumeImageManager implements ResumeImageService{

	
	

        private ResumeImageDao resumeImageDao;
        private CloudService cloudService;
        private EmployeeService employeeService;

    @Autowired
    public ResumeImageManager(ResumeImageDao resumeImageDao, CloudService cloudService, EmployeeService employeeService) {
        this.resumeImageDao = resumeImageDao;
        this.cloudService = cloudService;
        this.employeeService = employeeService;
    }
	
	
	@Override
	public Result add(MultipartFile photoFile, int employeeId) {
        var resumeImageByEmployeeId = resumeImageDao.getByEmployee_Id(employeeId);
        if (resumeImageByEmployeeId == null) return new ErrorResult("Employee Is Null");
        var result = this.cloudService.upload(photoFile);
        if(!result.isSuccess()) {
            return new ErrorResult();
        }
        ResumeImage photo = new ResumeImage();
        photo.setEmployee(employeeService.getById(employeeId).getData());
        photo.setImgLink(result.getData().get("url"));
        photo.setUploadedDate(result.getData().get("created_at"));
        this.resumeImageDao.save(photo);
        return new SuccessResult("Photo added");
	}

	@Override
	public Result delete(int id) {
        var image = resumeImageDao.getByResumeImageId(id);
        this.resumeImageDao.delete(image);
        return new SuccessResult("Photo deleted");
	}

	@Override
	public DataResult<ResumeImage> getByEmployee_Id(int id) {
        return new SuccessDataResult<>(resumeImageDao.getByEmployee_Id(id));
	}

	@Override
	public DataResult<ResumeImage> getByResumeImageId(int id) {
		 return new SuccessDataResult<>(resumeImageDao.getByResumeImageId(id));
	}

}
