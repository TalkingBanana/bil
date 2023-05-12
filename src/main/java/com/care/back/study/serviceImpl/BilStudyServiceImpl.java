package com.care.back.study.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.back.comment.dto.BilCommentDto;
import com.care.back.study.dao.BilStudyDao;
import com.care.back.study.dto.BilStudyDto;
import com.care.back.study.service.BilStudyService;

import jakarta.servlet.http.HttpServletResponse;


@Service
public class BilStudyServiceImpl implements BilStudyService{

	
	@Autowired
	BilStudyDao dao;
	
	private String filePath = "C:/bil-storage/";
	
	@Override
	public ArrayList<BilStudyDto> studyList(int currentPage, String category, String keyword, String order) {
		// TODO Auto-generated method stub
		String code = "";
		if(category.equals("자료실")) {
			code = "files";
		} else if (category.equals("강의")) {
			code = "video";
		} else {
			code = "";
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("page", (currentPage-1)*10);
		map.put("code", code);
		map.put("keyword", keyword);
		map.put("order", order);
		ArrayList<BilStudyDto> list = dao.getStudyList(map);
		return list;
	}

	@Override
	public int deleteStudy(BilStudyDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudy(BilStudyDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertStudy(BilStudyDto dto, MultipartFile file) {
		// TODO Auto-generated method stub
		if(dto.getCategory().equals("files")) {
			dto.setKorCategory("자료실");
		} else {
			dto.setKorCategory("강의");
		}
		dto.setWriter("테스터 계정");
		
		File uploadFile = new File(filePath+file.getOriginalFilename());
		
		if(!uploadFile.getParentFile().exists()) {
			uploadFile.getParentFile().mkdirs();
		}
		
		try {
			InputStream input = file.getInputStream();
			FileOutputStream output = new FileOutputStream(uploadFile);
			
			int count = 0;
			byte[] buffer = new byte[1024];
			
			while((count=input.read(buffer)) != -1) {
				output.write(buffer,0,count);
			}
			input.close();
			output.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!file.isEmpty()) {
			dto.setFileYn(file.getOriginalFilename());
		}
		
		
		int result = dao.insertStudy(dto);
		return result;
	}

	@Override
	public int getStudyTotal(String category, String keyword) {
		// TODO Auto-generated method stub
		if(keyword == null) keyword="";
		String cateCode = "";
		if(category.equals("자료실")) {
			cateCode = "datas";
		} else if (category.equals("강의")) {
			cateCode = "video";
		} else {
			cateCode = "";
		};
		
		String keyCode = "";
		if(keyword.equals("최신순")) {
			keyCode = "";
		} else if(keyword.equals("추천순")) {
			
		} else if(keyword.equals("댓글순")) {
			
		} else if(keyword.equals("조회순")) {
			
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("code", cateCode);
		map.put("keyword", keyword);
		int result = dao.getStudyTotal(map);
		return result;
	}

	@Override
	public BilStudyDto getStudyDetail(int num) {
		// TODO Auto-generated method stub
		
		
		BilStudyDto dto = new BilStudyDto();
		dto = dao.getStudyDetail(num);
		return dto;
	}

	@Override
	public void fileDownload(HttpServletResponse res, String path) {
		// TODO Auto-generated method stub
		try {
			byte[] fileByte = FileUtils.readFileToByteArray(new File(filePath+path));
			
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode("tistory.png", "UTF-8")+"\";");
			res.setHeader("Content-Transfer-Encoding", "binary");

			res.getOutputStream().write(fileByte);
			res.getOutputStream().flush();
			res.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
