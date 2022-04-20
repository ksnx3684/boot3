package com.ksnx3684.boot3.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	@Autowired
	private ServletContext servletContext;
	
	public String fileSave(MultipartFile mf, String path) throws Exception{
		// path = "프로젝트 상의 파일을 저장할 폴더의 경로"
		// 1. 파일을 로컬에 저장하고
		// 2. 저장된 파일명을 리턴(파일명은 중복되지 않게)
		
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// 1. 시간
		Calendar ca = Calendar.getInstance();
		long l = ca.getTimeInMillis();
		String oriName = mf.getOriginalFilename();
		
		String fileName = l + "_" + oriName;
		
		// 2. UUID
		fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + oriName;
		
		file = new File(file, fileName);
		FileCopyUtils.copy(mf.getBytes(), file);
		
		return fileName;
	}
	
	public boolean fileRemove(String path, String fileName) throws Exception{
		// 파일을 로컬에서 삭제
		
		String realPath = servletContext.getRealPath(path);
		File file = new File(realPath, fileName);
		
		return file.delete();
	}
}
