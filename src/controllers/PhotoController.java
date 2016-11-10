package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.Photo;
import data.PhotoDAO;

@Controller
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
		
		@RequestMapping("addPhoto.do")
		  public ModelAndView addPhoto(Photo photo, @RequestParam("URL") String URL) {
			
			photo.setImgURL(URL);
			dao.addPhoto(photo);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index.jsp");
			mv.addObject("photo", photo);
			return mv;

}
		
		@RequestMapping("deletePhoto.do")
		  public ModelAndView deletePhoto(Photo photo, Photo photo1, @RequestParam("index") String index) {
			int indx=Integer.parseInt(index); 
			dao.deletePhoto(indx);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index.jsp");
			if (!dao.getPhotos().isEmpty()){
			mv.addObject("photo", dao.getPhotobyIndex("back"));
			}else{ mv.addObject("photo", photo1);}
			return mv;

}
		
}
