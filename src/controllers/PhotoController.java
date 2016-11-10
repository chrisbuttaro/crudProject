package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.PhotoDAO;

@Controller
@SessionAttributes("")
public class PhotoController {
	private PhotoDAO dao;
	
	@RequestMapping("GetNextPhoto.do")
	public ModelAndView stateN(){ 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("photo", dao.getPhotobyIndex(0));
		return mv;
	}

}
