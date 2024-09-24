package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.domain.MemberVO;

/**
 * 
 * 스프링 MVC가 제공(처리)하는 기능 - URI를 분석해서 적절한 컨트롤러 연결 - 컨트롤러가 필요한 메서드를 작동으로 호출 -
 * 컨트롤러에서 생성된 결과(데이터)를 뷰페이지로 전달 - 컨트롤러 결과에 따른 뷰페이지 연결
 * 
 * 개발자가 제공(처리)하는 기능 - 특정 주소(URI)에 반응하는 컨트롤러 설계 - 서비스 객체를 생성 - DAO 객체를 생성 - 컨트롤러의
 * 동작을 메서드 형태로 설계 - 전달된 데이터 뷰페이지에 출력
 * 
 */

// @Controller : 해당 클래스를 컨트롤러 객체 (빈)으로 인식하도록 설정( servlet-context ) 
@Controller
public class SampleController2 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);

	// * 메서드의 리턴타입이 String 일때 , 문자열 jsp 뷰 페이지를 연결

	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public String doB() {
		logger.debug("(●'◡'●) /doB -> 실행 (●'◡'●)");

		// return null; // null일때는 void 리턴과 동일함.
		return "itwill";
	}

	@RequestMapping(value = "/doB1", method = RequestMethod.GET)
	public String doB1() {
		logger.debug("(●'◡'●) /doB1 -> 실행 (●'◡'●)");

		// return null; // null일때는 void 리턴과 동일함.
		return "itwill";
	}

	@RequestMapping(value = "/doB2", method = RequestMethod.GET)
	public String doB2(@ModelAttribute("msg") String msg) {
		logger.debug("(●'◡'●) /doB2 -> 실행 (●'◡'●)");
		// request.getParamater("msg"); => X
		logger.debug("(●'◡'●) msg : " + msg + " (●'◡'●)");

		// return null; // null일때는 void 리턴과 동일함.
		return "itwill";
	}

	// http://localhost:8088/web/doB3?msg=itwill&id=admin
	@RequestMapping(value = "/doB3", method = RequestMethod.GET)
	public String doB3(@ModelAttribute("msg") String msg, @ModelAttribute("id") int id) {
		logger.debug("(●'◡'●) /doB2 -> 실행 (●'◡'●)");
		// request.getParamater("msg"); => X
		logger.debug("(●'◡'●) msg : " + msg + " (●'◡'●)");
		logger.debug("(●'◡'●) id : " + id + " (●'◡'●)");

		// return null; // null일때는 void 리턴과 동일함.
		return "itwill";
	}

	// * 컨트롤러는 파라메터 자동수집을 제공.
	// http://localhost:8088/web/doB4?userid=itwill&userpw=20240101
	@RequestMapping(value = "/doB4", method = RequestMethod.GET)
	public String doB4(/* @ModelAttribute 생략됨. */MemberVO vo) {
		// public String doB4(@ModelAttribute("userid") String msg
		// ,@ModelAttribute("userpw") String userpw) {
		logger.debug("(●'◡'●) /doB4 -> 실행 (●'◡'●)");
		// request.getParamater("msg"); => X

//			logger.debug("(●'◡'●) msg : " + msg + " (●'◡'●)");
//			logger.debug("(●'◡'●) id : " + id + " (●'◡'●)");

		logger.debug("(●'◡'●) vo : " + vo);

		return "itwill";
	}

	// http://localhost:8088/web/doB5?userid=itwill&userpw=20240101
	@RequestMapping(value = "/doB5", method = RequestMethod.GET)
	public String doB5(Model model /* MemberVO vo1 */) {
		logger.debug("(●'◡'●) /doB5 -> 실행 (●'◡'●)");

		// MemberVO 객체 생성 => DAO의 메서드 리턴
		MemberVO vo = new MemberVO();
		vo.setUserid("ADMIN");
		vo.setUserpw("1234");

//		request.setAttribute(attributeName, attributeValue );

		/* @ModelAttribute("name") */
//		model.addAttribute("name", v);

		/* @ModelAttribute */
//		model.addAttribute(vo);
//		=>  spring에서 규칙을 만들어둠
//		=> 이름이 없는 경우 스프링에서 이름을 자동으로 설정
//		=> 전달하는 객체의 클래스타입명을 첫글자 소문자로 변경해서 이름으로 설정
//		=> ex) vo 객체의 타입 MemberVO => memberVO
		model.addAttribute("vo1", vo);

		logger.debug("(●'◡'●) vo : " + vo);

		return "itwill";
	}

	// http://localhost:8088/web/doB6?userid=itwill&userpw=20240101
	@RequestMapping(value = "/doB6", method = RequestMethod.GET)
	public String doB6(Model model, MemberVO vo1) {
		logger.debug("(●'◡'●) /doB6 -> 실행 (●'◡'●)");

		// MemberVO 객체 생성 => DAO의 메서드 리턴
		MemberVO vo = new MemberVO();
		vo.setUserid("ADMIN");
		vo.setUserpw("1234");

		model.addAttribute("adminVO" + vo);

		logger.debug("(●'◡'●) vo1 : " + vo1);
		logger.debug("(●'◡'●) vo : " + vo);

		return "itwill";
	}
	// http://localhost:8088/web/doB7?userid=itwill&userpw=20240101
	@RequestMapping(value = "/doB7", method = RequestMethod.GET)
	public String doB7(@RequestParam("userid") String id,
						@RequestParam("userpw") int pw) {
		// @RequestParam("파라메터명") 저장할 변수 (자동형 변환: 문자, 숫자, 날짜...) 해줌.
		// => request.getParammeter("이름") => 스트링타입으로 전달. p131~138
		logger.debug("(●'◡'●) /doB7 -> 호출 (●'◡'●)");


		logger.debug("(●'◡'●) id : " + id + ", pw : "+ (pw+1));
		

		return "itwill";
	}

}
