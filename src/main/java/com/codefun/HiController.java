package com.codefun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/** 
 * 
 * @author ���� :		E-mail: 
 * @version ����ʱ�䣺2016-7-12 ����2:36:58 
 * 
 */
@Controller
public class HiController extends AbstractController {

	@Override
	@RequestMapping("test/sayhi.do")
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView  view = new ModelAndView("/index.jsp");
		view.addObject("mesg", "����");
		return view;
	}

}
