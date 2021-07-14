package HRMSDemo.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import HRMSDemo.hrms.business.abstracts.ResumeImageService;
import HRMSDemo.hrms.core.utilities.results.DataResult;
import HRMSDemo.hrms.core.utilities.results.Result;
import HRMSDemo.hrms.entities.concretes.ResumeImage;

@RestController
@RequestMapping("/api/esumeImage")
@CrossOrigin
public class ResumeImageController {
    private ResumeImageService resumeImageService;
    @Autowired
    public ResumeImageController(ResumeImageService resumeImageService) {
        this.resumeImageService = resumeImageService;
    }

    @GetMapping("getByEmployee_Id")
    public DataResult<ResumeImage> getByEmployee_Id(@RequestParam int employeeId){
        return resumeImageService.getByEmployee_Id(employeeId);
    }
    @PostMapping("photoUpload")
    public Result photoUpload(@RequestParam("photo") MultipartFile photo, @RequestParam("id") int id) {
        return  this.resumeImageService.add(photo,id);
    }
    @PostMapping("photoDelete")
    public Result photoDelete(@RequestParam("id") int id){
        return this.resumeImageService.delete(id);
    }
}
