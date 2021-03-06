package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dto.Page3;
import com.dto.Review;
import com.dto.ReviewComment;
import com.dto.ReviewJoin;
import com.dto.ReviewUpload;
import com.service.ReviewBoardService;

@Controller
public class ReviewController {

	@Autowired
	ReviewBoardService service; 
	
	@RequestMapping("/review")
	public String review(@RequestParam int currentPage, Model m) {
		if(currentPage == 0) {
			currentPage = 1 ; 
		}
		Page3 page = service.review(currentPage);
		List<Review> mod = page.getList();
		m.addAttribute("page", page);
		return "review"; }

		@RequestMapping("/reviewWrite")
		public String reviewWrite() {
			return "reviewWrite"; 
		}
	
	//@RequestParam String review_number ==> 임시고정 
	@RequestMapping("/reviewRetrieve")
	public ModelAndView reviewRetrieve(@RequestParam String review_number, ModelAndView m) {
		
			List<ReviewJoin> rj = service.reviewRetrieveJoin(review_number);
			m.addObject("reviewRetrieve", rj);
			m.setViewName("reviewRetrieve");

		return m; 
	}
	@RequestMapping(value="/reviewWriteSubmit", method=RequestMethod.POST)
    public String reviewWrite(Review r, ReviewUpload file) {
          System.out.println(">>>>>>>>>>reviewWriteSubmit Controller 통과");
          System.out.println(r);
          System.out.println(file);
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
          
          
          //안선팀원용 경로 
         // f = new File("C:\\Users\\acorn\\git\\emptyProject_springVersion\\"
          		//+ "emptyProject_springVersion2\\src\\main\\webapp\\WEB-INF\\views\\images\\review", oriFileName);
          f = new File("C:\\upload", oriFileName); 
          
          try {
                 theFile.transferTo(f);
          } catch (IllegalStateException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
          } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
          }
          r.setImage_name(oriFileName);
          
          service.reviewWrite(r);
          return "redirect:./review?currentPage=1" ;
          
    }
	
	@RequestMapping(value="/reviewDelete", method=RequestMethod.GET)
	public String reviewDelete(@RequestParam String review_number) {
		System.out.println("review_number 넘어옵니까 delete"+review_number);
		int rj = Integer.parseInt(review_number); 
		service.reviewDelete(rj);
		return "redirect:/review?currentPage=1"; 
	}
	
	
	@RequestMapping("/reviewUpdate")
	public ModelAndView reviewUpdate(@RequestParam String review_number, ModelAndView m, Review r) {
		
		Review review = 
				service.reviewRetrieve(review_number);
		System.out.println("review UpdateUI GO!"+review);
		m.addObject("reviewUpdate", review);
		m.setViewName("reviewUpdate");
		return m; 
	}
	
	@RequestMapping(value="/reviewUpdateSubmit", method=RequestMethod.POST)
	public String reviewUpdateSubmit(Review r,ReviewUpload file) {
        System.out.println(">>>>>>>>>>reviewUpdateSubmit Controller 통과");
        System.out.println(r);
        System.out.println(file);
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
        
       /* f = new File("C:\\Users\\acorn\\git\\emptyProject_springVersion\\"
          		+ "emptyProject_springVersion2\\src\\main\\webapp\\WEB-INF\\views\\images\\review", oriFileName);*/
        
        f = new File("C:\\upload", oriFileName); 
        try {
               theFile.transferTo(f);
        } catch (IllegalStateException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
        r.setImage_name(oriFileName);
     
      
        service.reviewUpdate(r); 
		return "redirect:/review?currentPage=1" ; 
	}
	
	@RequestMapping("/reviewComment")
	public String reviewComment(ReviewComment rc) {
		
		service.ReviewCommentInsert(rc);
		return "redirect:/review?currentPage=1"; 
	}
	
	@RequestMapping("/reviewCommentDelete")
	public String reviewCommentDelete(@RequestParam("r_comment_number") String r_comment_number) {
		System.out.println("코멘트 넘버 넘어오니?====="+r_comment_number);
		service.reviewCommentDelete(r_comment_number);
		return "redirect:/review?currentPage=1"; 
		
	}
	
	
	
}
