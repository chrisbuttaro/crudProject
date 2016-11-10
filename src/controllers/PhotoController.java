package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.PhotoDAO;


@SessionAttributes("")
public class PhotoController {
	@Autowired
	private PhotoDAO dao;
	
	
		
		@RequestMapping("GetNextPhoto.do")
		  public ModelAndView statesList(@RequestParam("navigate") String navigate) {
			System.out.println(navigate);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index.jsp");
			mv.addObject("photo", dao.getPhotobyIndex(navigate));
			return mv;
		
		
	}

}
