package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

/**
 * 
 *	tbl_member 테이블의 데이터를 활용하는 동작을 정의 
 *  
 */
public interface MemberDAO {
	
	// 디비서버 시간 조회
	public String getTime();
	
	// 회원가입 
	// 
	public void insertMember(MemberVO vo);
	
}
