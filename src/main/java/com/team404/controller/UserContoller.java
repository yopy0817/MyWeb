package com.team404.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.UserVO;
import com.team404.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserContoller {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	//가입화면
	@RequestMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}
	//로그인화면
	@RequestMapping("/userLogin")
	public String userLogin() {
		return "user/userLogin";
	}
	//마이페이지화면
	@RequestMapping("/userMypage")
	public String userMypage(HttpSession session, Model model) {
		
//		if(session.getAttribute("userVO") == null ) { 
//			return "redirect:/user/userLogin"; //로그인화면으로
//			
//		}
		
		//아이디를세션에서 얻는다.
		UserVO vo = (UserVO)session.getAttribute("userVO");
		String userId = vo.getUserId();
		//회원정보 조회
		UserVO userInfo  = userService.getInfo(userId);
		model.addAttribute("userInfo", userInfo); //결과 추가

		
		return "user/userMypage";
	}
	
	//중복처리 메서드
	@ResponseBody //일반 컨트롤러에서 ResponseBody는 요청의 경로로 return값을 돌려줍니다
	@PostMapping(value = "/idCheck", produces = "application/json")
	public int idCheck(@RequestBody UserVO vo) {
		
		//중복체크함수
		int result = userService.idCheck(vo);
				
		
		
		return result; //0이라면 중복x, 1이라면중복
	}

	//가입요청
	@RequestMapping(value = "/joinForm", method = RequestMethod.POST )
	public String joinForm(UserVO vo,
						   RedirectAttributes RA) {
		
		int result = userService.join(vo);
		
		if(result == 1) { //가입성공
			RA.addFlashAttribute("msg", "가입을 축하합니다");			
		} else { //가입 실패
			RA.addFlashAttribute("msg", "가입에 실패했습니다. 다시 시도하세요");
		}
		
		return "redirect:/user/userLogin";
	}
	
	//로그인요청
//	@RequestMapping(value = "/loginForm", method= RequestMethod.POST)
//	public String loginForm(UserVO vo, HttpSession session, Model model) {
//		
//		//로그인 처리 
//		UserVO userVO = userService.login(vo);
//		
//		System.out.println(userVO);
//		
//		if( userVO != null) { //로그인 성공
//			session.setAttribute("userVO", userVO); //회원정보 저장
//			return "redirect:/"; //홈
//			
//		} else { //로그인 실패
//			model.addAttribute("msg", "아이디 비밀번호를 확인하세요");
//			return "user/userLogin"; //다시 로그인화면
//		}
//	}
	
	//PostHandler를 이용한 로그인요청
	@RequestMapping(value = "/loginForm", method= RequestMethod.POST)
	public ModelAndView loginForm(UserVO vo) {
		
		//로그인 처리
		UserVO userVO = userService.login(vo);
		
		ModelAndView mv = new ModelAndView();
		
		if(userVO != null) { //로그인 성공
			mv.addObject("login", userVO);
			
		} else { //로그인 실패
			mv.addObject("msg", "아이디 비밀번호를 확인하세요");
			
		}
		
		return mv; //디스패쳐 서블릿으로 반환
	}
	
	
	
	
	
	//로그아웃
	@RequestMapping("/userLogout")
	public String userLogout(HttpSession session) {
		
		session.invalidate(); //세션무효화
		
		return "redirect:/"; //홈
	}
	
	
	
	
	
	
	
	
}
