package com.care.back.editor.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.back.editor.service.BilEditorService;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class BilEditorServiceImpl implements BilEditorService{
	
	
	@Value("${upload.path}")
	public String defalutPath;
	
	
	@Override
	public String imageUpload(MultipartHttpServletRequest request, HttpServletResponse res){
		// TODO Auto-generated method stub
		MultipartFile uploadFile = request.getFile("upload");
		File file = new File(defalutPath + uploadFile.getOriginalFilename());
		String uploadId = UUID.randomUUID().toString();
		String uploadPath = "";
		try {
			InputStream input = uploadFile.getInputStream();
			uploadPath = defalutPath+uploadId+"."+FilenameUtils.getExtension(uploadFile.getOriginalFilename());
			FileOutputStream output = new FileOutputStream(uploadPath);
			int count = 0;
			byte[] buffer = new byte[1024];
			
			File dir = new File(defalutPath);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			while((count=input.read(buffer))!= -1) {
				output.write(buffer,0,count);
			}
			output.close();
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uploadId+"."+FilenameUtils.getExtension(uploadFile.getOriginalFilename());
	}

	@Override
	public String fileUpload(MultipartHttpServletRequest request, HttpServletResponse res) throws IOException {
		// TODO Auto-generated method stub
		return defalutPath;
	}
	

}
