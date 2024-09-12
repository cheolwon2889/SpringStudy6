package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MeberDAOTest {
	// MemberDAO객체의 메서드 호출
	
	@Inject
	private MemberDAO mdao;
	
	// @Test
	public void getBean() {
		System.out.println("mdao : "+ mdao);
	}	
	
	@Test
	public void getTime() {
		mdao.getTime();
	}
	
	@Test
	public void 회원가입테스트() {
		System.out.println(" TEST : 회원가입테스트() 시작");
		MemberVO vo = new MemberVO();
		
		vo.setUserid("admin");
		vo.setUsername("관리자");
		vo.setUserpw("1234");
		vo.setUseremail("itwill@admin.com");
		
		mdao.insertMember(vo);
		
		System.out.println(" TEST : 회원가입테스트() 끝");
	}
	
}
