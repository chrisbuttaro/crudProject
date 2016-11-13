package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		@RequestMapping("GetNextPhoto.do") //gets next/previous photo and sends it to admin, photos.jsp
		  public ModelAndView photoList(@RequestParam("navigate") String navigate) {
			System.out.println(navigate);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("photos.jsp");
			//try{
				mv.addObject("photo", dao.getPhotobyIndex(navigate));
				
			return mv;

	}
		@RequestMapping("password.do") // takes in password and sends it to dao, 
		  public ModelAndView password(@RequestParam("password") String password) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("photos.jsp");
			if(dao.getPhotoPassword(password).getIndex()==0){
				mv.addObject("photo", dao.getPhotobyIndex(password));
			}
				
			return mv;

	}
		
		@RequestMapping("GetNextUser.do")  ////gets next/previous photo and sends it to guest, user.jsp
		  public ModelAndView photoList1(@RequestParam("navigate") String navigate) {
			System.out.println(navigate);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("user.jsp");
				mv.addObject("photo", dao.getPhotobyIndex(navigate));
				
			return mv;

	}
		
		@RequestMapping("addPhoto.do")  //gets an index and a url to insert an img src into any index in the list
		  public ModelAndView addPhoto(Photo photo, @RequestParam("index") String index, @RequestParam("URL") String URL ) {
			 
			photo.setImgURL(URL);
			photo.setIndex(Integer.parseInt(index));
			ModelAndView mv = new ModelAndView();
			mv.setViewName("photos.jsp");
			mv.addObject("photo", dao.addPhoto(photo));
			return mv;

}
		
		@RequestMapping("deletePhoto.do") //get index from user and sends it to dao to delete photo
		  public ModelAndView deletePhoto(Photo photo, @RequestParam("index") String index) {
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("photos.jsp");
			try
			{
				int indx=Integer.parseInt(index); 
				dao.deletePhoto(indx);
				mv.addObject("photo", dao.getPhotobyIndex("back"));
			}
			catch (Exception e){
			    System.out.println("list empty");
			  
			    mv.addObject("photo", photo);
			}
			return mv;
			}
		
		@RequestMapping("size.do") //gets a width and an index for the dao to resize the current img src
		  public ModelAndView sizePhoto(@RequestParam("index") String index, @RequestParam("size") String size) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("photos.jsp");
			mv.addObject("photo", dao.setSize(Integer.parseInt(index), Integer.parseInt(size)));
			return mv;
		}
			
		@RequestMapping("updatePhoto.do")//takes in a url to replace the current img on the screen
		  public ModelAndView updatePhoto(Photo p, @RequestParam("URL") String URL, @RequestParam("index") String index) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("photos.jsp");
			mv.addObject("photo", dao.updatePhoto(p, URL, Integer.parseInt(index)));
			return mv;

}
		

}
		

