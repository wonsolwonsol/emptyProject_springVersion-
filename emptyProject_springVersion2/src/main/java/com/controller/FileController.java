package com.controller;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dto.Login;
import com.dto.Upload;

@Controller
public class FileController {
	
	@RequestMapping("/")
	public String home() {
		return "uploadForm";
	}
	
	@RequestMapping("/upLoad")
	public String home1(Upload file) {
		
		String theText = file.getTheText();
		CommonsMultipartFile theFile = file.getTheFile();
		long size = theFile.getSize();
		String fileName = theFile.getName();
		String oriFileName = theFile.getOriginalFilename();
		String type = theFile.getContentType();
		
		System.out.println("size "+size);
		System.out.println("fileName "+fileName);
		System.out.println("oriFileName "+oriFileName);
		System.out.println("type "+type);
		File f = null;
		
		
		f = new File("c:\\upload", oriFileName);
		
		try {
			theFile.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "info";
	}


}
