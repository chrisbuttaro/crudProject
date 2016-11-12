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
			//try{
				mv.addObject("photo", dao.getPhotobyIndex(navigate));
				
			//}
		//	catch (Exception e){
			 //   System.out.println("list empty");
			//}
		
			return mv;

	}
		
		@RequestMapping("addPhoto.do")
		  public ModelAndView addPhoto(Photo photo, @RequestParam("URL") String URL, @RequestParam("index") String index) {
			photo.setImgURL(URL);
			photo.setIndex(Integer.parseInt(index));
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index.jsp");
			
			mv.addObject("photo", dao.addPhoto(photo));
			return mv;

}
		
		@RequestMapping("deletePhoto.do")
		  public ModelAndView deletePhoto(Photo photo, Photo photo1, @RequestParam("index") String index) {
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index.jsp");
			try
			{
				int indx=Integer.parseInt(index); 
				dao.deletePhoto(indx);
				mv.addObject("photo", dao.getPhotobyIndex("back"));
			}
			catch (Exception e){
			    System.out.println("list empty");
			  
			    mv.addObject("photo", photo1);
			}
			return mv;
			}
			
		@RequestMapping("updatePhoto.do")
		  public ModelAndView updatePhoto(Photo p, @RequestParam("URL") String URL, @RequestParam("index") String index) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index.jsp");
			mv.addObject("photo", dao.updatePhoto(p, URL, Integer.parseInt(index)));
			return mv;

}
		

}
		

