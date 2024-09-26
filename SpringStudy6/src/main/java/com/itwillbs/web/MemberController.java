package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.service.MemberService;

//@RequestMapping( value = "/member/*")
// => 특정 동작의 형태를 구분( ~.me , ~.bo, ~.do)

@Controller
@RequestMapping( value = "/member/*")
public class MemberController {
	
	// 객체 주입
//	@Inject
//	private MemberDAO mdao;
	
	
	@Inject
	private MemberService mService;
	
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
		// 한글 인코딩 처리 => web.xml 필터로 처리
		
		
		// 전달정보(파라메터) 저장
		logger.debug("(●'◡'●) vo : " + vo);
		
		// DB 객체 생성 - 회원가입
		// MemberDAO 객체 생성 => 객체 주입
		// mdao.insertMember(vo);
		
		// MemberService 객체를 주입 -> 해당동작 실행
		mService.memberJoin(vo);
		
		logger.debug("(●'◡'●) 회원가입 성공!");
		
		logger.debug("(●'◡'●) 로그인 페이지로 이동 / member/login");
		
		
		
		return "redirect:/member/login";
	}
	
	// 로그인 처리 - 입력 (GET)
	// http://localhost:8088/member/login
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String loginMemberGET() {
		logger.debug("(●'◡'●) /member/login -> loginMemberGET() 실행 ");
		logger.debug("(●'◡'●) 연결된 뷰페이지 (jsp) 출력 ");
		
		return "/member/loginForm"; // /views/member/loginForm
	}
	
	// 로그인 처리 - 처리 (POST)
//	public String loginMemberPOST(@RequestParam("userid") String userid, @RequestParam("userpw") String userpw) {
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String loginMemberPOST(MemberVO vo, HttpSession session) {
		logger.debug("(●'◡'●) /member/login(post) -> loginMemberPOST() 실행 ");
		
		// 전달정보를 저장(userid, userpw)
		 logger.debug("(●'◡'●) vo : " + vo );
//		logger.debug("(●'◡'●) id : "+ userid);
//		logger.debug("(●'◡'●) pw : "+ userpw);
		 
		 // 서비스 -> 회원정보 확인 -> DAO 호출
		 MemberVO resultVO = mService.memberLoginCheck(vo);
		 
		 if(resultVO == null) {
			 // 로그인 실패! -> 로그인 페이지로 이동.
			 return "redirect:/member/login";
		 }
		 // 사용자의 아이디정보를 세션영역에 저장
		 session.setAttribute("id", resultVO.getUserid());
		 
		 // 로그인 성공! -> 메인페이지로 이동
			 
		return "redirect:/member/main";
	}
	
	// 메인페이지 - GET
	@RequestMapping(value = "/main" , method = RequestMethod.GET)
	public void mainMemberGET() {
		logger.debug("(●'◡'●) /member/main -> mainMemberGET() 실행 ");
		logger.debug("(●'◡'●) 연결된 뷰페이지 (views/member/main.jsp)");
	}
	
	// 로그아웃페이지 - GET(정보입력,조회,출력) / POST(처리)
	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
	public String logoutMemberGET(HttpSession session) {
		logger.debug("(●'◡'●) /member/main -> mainMemberGET() 실행 ");
		logger.debug("(●'◡'●) 연결된 뷰페이지 (views/member/logout.jsp)");
		session.invalidate();
		
		logger.debug("사용자 정보 로그아웃 !");
		return "redirect:/member/main";
	}
	
	// 회원정보 조회 GET
	// @RequestMapping(value = "info" , method = RequestMethod.GET)
	@GetMapping(value = "info")
	public void infoMemberGET(HttpSession session, Model model) {
		logger.debug("/member/info -> infoMemberGET() 실행 ");
		
		// 아이디 정보가 필요함
		String id = (String)session.getAttribute("id");
		logger.debug("(●'◡'●) id : " + id);
		// 서비스 -> DAO : 특정 아이디를 사용해서 회원의 정보를 조회
		
		MemberVO vo = mService.memberInfo(id);
		logger.debug("(●'◡'●) vo : "+ vo);
		//model.addAttribute("memberInfo", vo);
		// 서비스에서 가져온 데이터를 연결된 뷰페이지에 전달해서 출력
		model.addAttribute("memberVO", mService.memberInfo(id));
		// => 이름이 없을 경우 첫글자를 소문자로 바꾼 클래스명 이름으로 사용
		logger.debug("(●'◡'●) 연결된 뷰페이지로 이동");
		
	}
	
	// 회원정보 수정 GET
	@GetMapping(value= "/update")
	public String updateMemberGET(HttpSession session , Model model) {
		// 아이디 정보가 필요함
		String id = (String)session.getAttribute("id");
		logger.debug("(●'◡'●) id : " + id);
		// 서비스 -> DAO : 특정 아이디를 사용해서 회원의 정보를 조회
		
		
		MemberVO vo = mService.memberInfo(id);
		logger.debug("(●'◡'●) vo : "+ vo);
		//model.addAttribute("memberInfo", vo);
		// 서비스에서 가져온 데이터를 연결된 뷰페이지에 전달해서 출력
		model.addAttribute( mService.memberInfo(id));
		// => 이름이 없을 경우 첫글자를 소문자로 바꾼 클래스명 이름으로 사용
		logger.debug("(●'◡'●) 연결된 뷰페이지로 이동");
		
		return "member/update";
		
		
	}
	
	// 회원정보 수정 POST
	@PostMapping(value= "/update")
	public String updateMemberPOST(MemberVO vo) {
		
		logger.debug("(●'◡'●) /member/update -> updateMemberPOST() 실행 ");
		// 한글처리 인코딩 => web.xml 필터 처리
		logger.debug("(●'◡'●) 전달받은 정보(파라메터)를 저장 ");
		
		// 서비스 -> DAO : 전달받은 정보를 사용해서 정보 수정하는 동작
		int result = mService.memberUpdate(vo);
		
		if(result == 0) {
			// SQL-update 실행결과가 없음(수정x)
			return "redirect:/member/update";
		}
		// 수정 성공
		return "redirect:/member/main";
	}
	
		
	// 회원정보 삭제 GET
	@GetMapping(value="/delete")
	public void deteleMemberGET(HttpSession session, Model model) {
		// 아이디 정보가 필요함
		String id = (String)session.getAttribute("id");
		logger.debug("(●'◡'●) id : " + id);
		// 서비스 -> DAO : 특정 아이디를 사용해서 회원의 정보를 조회
		
		
		MemberVO vo = mService.memberInfo(id);
		logger.debug("(●'◡'●) vo : "+ vo);
		//model.addAttribute("memberInfo", vo);
		// 서비스에서 가져온 데이터를 연결된 뷰페이지에 전달해서 출력
		model.addAttribute( mService.memberInfo(id));
		// => 이름이 없을 경우 첫글자를 소문자로 바꾼 클래스명 이름으로 사용
		logger.debug("(●'◡'●) 연결된 뷰페이지로 이동");
		
		
	}
	// 회원정보 삭제 DELETE
	
	@PostMapping(value = "/delete")
	public String deteleMemberPOST(MemberVO vo, HttpSession session) {
		logger.debug("(●'◡'●) MemberVO : " + vo);
		
		int result = mService.memberDelete(vo);
		
		if(result == 0) {
			// 입력된 정보가 틀림
			return "redirect:/member/delete";
			
		}
		
		// 세션객체 정보를 초기화
		session.invalidate();
		
		return "redirect:/member/main";
	}
	
	// 회원목록 조회 - GET
	@RequestMapping(value = "/list" , method=RequestMethod.GET)
	public void listMemberGET(Model model) {
		
		logger.debug("(●'◡'●) member/list -> listMemberGET() 실행 ");
		
		// 로그인 (세션정보) => 생략 
		
		// 서비스 -> DAO : 회원 목록정보를 가져오기
		List<MemberVO> memberlist = mService.memberList();
		// 연결된 view페이지로 전달해서 출력
		// => Model 객체 생성
		// List 같은 경우는 이름을 지정해주는 것을 권장함.
		model.addAttribute("memberList" , memberlist);
		
		
		
	}
	
	
	

	
	
	
	
	
	
}
