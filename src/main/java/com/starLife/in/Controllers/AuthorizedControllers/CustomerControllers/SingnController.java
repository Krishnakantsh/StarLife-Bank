package com.starLife.in.Controllers.AuthorizedControllers.CustomerControllers;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.starLife.in.Entity.CaptureCode;
import com.starLife.in.repository.CaptureRepository;
import com.starLife.in.service.captureService;




@Controller
public class SingnController {
	@Autowired
	private CaptureRepository captureRepository;

   @Autowired
   private captureService captureservice;
	
   @GetMapping("/signin")
   public String openSignInpage(Model m) {

	    Random rm = new Random();
       int numMax = 67;
       int numMin = 0;

       String str1 = "abcdefghijklmnopqrstuvwxyz";
       String str2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String str3 = "@#$%&*";
       int arr[] = {0,1,2,3,4,5,6,7,8,9};
       String capture1 ="";

       for(int i=1; i<=6; i++){
           int ni =( rm.nextInt(numMax - numMin+1) + numMin);
           capture1 = capture1 + captureservice.digitt(ni,arr,str1,str2,str3);
        }
       
       
       CaptureCode cc= new CaptureCode();
       
       cc.setCaptureNo(1);
   	 cc.setCaptureCode(capture1);
   	   
       captureRepository.save(cc);
   	
       CaptureCode capture2 = this.captureRepository.findByCaptureno(1);
       String capture =capture2.getCaptureCode();
       m.addAttribute("capture",capture);
       
	   m.addAttribute("title","Login page");
	   
	   
	   return "login";
   }
   

   @GetMapping("/fintakebank")
   public String openHomepage() {
	   return "fintakebank";
   }


   // method for failed login 
   @GetMapping("/logininfailed")
   public String getMethodName(Model m) {
   CaptureCode capture2 = this.captureRepository.findByCaptureno(1);
   String capture =capture2.getCaptureCode();
   m.addAttribute("capture",capture);

   m.addAttribute("title", "login form");
       return "login";
   }
   
}
