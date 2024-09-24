package com.itwillbs.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

//@RequestMapping( value = "/member/*")
// => 특정 동작의 형태를 구분( ~.me , ~.bo, ~.do)

@Controller
@RequestMapping( value = "/member/*")
public class MemberController {
	
	// 객체 주입
	@Inject
	private MemberDAO mdao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	// persistence에서 컨트롤러를 실행 시키면 어떻게 되는지???
	
	
	// http://localhost:8088/web/member/test (x)
	// http://localhost:8088/member/test (o)
//	@RequestMapping(value ="/test" , method=RequestMethod.GET)
//	public void test() {
//		logger.debug("(●'◡'●) test() 실행");
//	}
	
	
	// 회원가입 - 정보 입력
	// http://localhost:8088/member/join
	@RequestMapping(value = "/join" , method = RequestMethod.GET)
	public void joinMemberGet() {
		logger.debug("(●'◡'●) /join => joinMemberGet() 실행 ");
		logger.debug("(●'◡'●) 연결된 뷰(JSP)를 보여주기 ");
		// 페이지 이동(x) => 스프링이 자동으로 연결
		logger.debug("(●'◡'●) /views/member/join.jsp 뷰페이지 연결");
	}
	
	// 회원가입 - 정보 처리
	// http://localhost:8088/member/join
	@RequestMapping(value ="join" , method = RequestMethod.POST)
	public String joinMemberPost(MemberVO vo) {
		logger.debug("(●'◡'●) /member/join -> joinMemberPost() 실행 ");
		
		// 전달정보(파라메터) 저장
		// 한글 인코딩 처리
		logger.debug("(●'◡'●) vo : " + vo);
		
		// DB 객체 생성 - 회원가입
		// MemberDAO 객체 생성 => 객체 주입
		mdao.insertMember(vo);
		logger.debug("(●'◡'●) 회원가입 성공!");
		
		
		
		return "";
	}
	
	
	
	
	
	
}
