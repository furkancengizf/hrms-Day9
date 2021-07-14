package HRMSDemo.hrms.core.adapter;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import HRMSDemo.hrms.core.utilities.results.DataResult;

public interface CloudService {
    DataResult<Map<String, String>> upload(MultipartFile file);
    DataResult<Map> delete(String id) throws IOException;
}
