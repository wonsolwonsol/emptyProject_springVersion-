package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Page3;

import com.dto.Review;
import com.dto.ReviewJoin;

//put, get 입출력 
@Repository
public class ReviewDAO {
	@Autowired
	SqlSessionTemplate t ;	
	
	public int reviewDelete(String review_number) {
		int n = t.delete("ReviewMapper.reviewDelete", review_number); 
		return n; 
	}

	public int totalRecord() {
		int n = t.selectOne("ReviewMapper.totalCount");
		return n ; }

	public Review reviewRetrieve(String review_number){
		Review review = t.selectOne("ReviewMapper.reviewRetrieve", review_number); 
		//List result = t.selectList("ReviewMapper.reviewRetrieve", param); 
		return review; 
				
		//return (Map<String, Object>) t.selectOne("ReviewMapper.reviewRetrieve", param); 
	}
	public void updateReadCnt(String review_number) {
		t.update("ReviewMapper.updateReadCnt", review_number);
	}
	
	
	public List<ReviewJoin> reviewRetrieveJoin(String review_number){
		List<ReviewJoin> rj = t.selectList("ReviewMapper.reviewRetrieveJoin", review_number );
		return rj; 
	}
	public Page3 review(int curpage){ //목록보기
		Page3 page = new Page3(); 
		//offset 데이터 인덱스 값
		int offset = (curpage - 1) * page.getPerPage();
		//page에 담을 list (인덱스부터 perpage 갯수 만큼)
		List<Review> list = t.selectList("ReviewMapper.review", null, 
				new RowBounds(offset,page.getPerPage()));
		
		page.setList(list); 
		page.setCurrentPage(curpage);
		int totalCount = totalRecord();
		page.setTotalCount(totalCount);
		return page ; 
	
	}
	public void reviewWrite(Review review) {
        t.insert("ReviewMapper.reviewWrite", review);
			}
	public int reviewDelete(int review_number) {
        int n = t.delete("ReviewMapper.reviewDelete", review_number);
        return n;
        }
	public void reviewUpdate(Review review) {
        t.update("ReviewMapper.reviewUpdate", review);
			}

	
}
