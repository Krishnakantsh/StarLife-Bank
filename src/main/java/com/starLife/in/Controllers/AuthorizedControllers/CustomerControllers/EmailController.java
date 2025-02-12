package com.starLife.in.Controllers.AuthorizedControllers.CustomerControllers;

import java.security.Principal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.starLife.in.Entity.Customer;
import com.starLife.in.helper.Message;
import com.starLife.in.helper.SigninHelper;
import com.starLife.in.repository.CustomerRepository;
import com.starLife.in.service.EmailService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EmailController {


  @Autowired
  private CustomerRepository custRepo;

  @Autowired
	private EmailService emailSEndService;
	
  // @RequestBody EmailsendHelper emailsendhelper 
	
	@PostMapping("/home/forgetPasswordPage/getOtp")
	public String emailsend(@ModelAttribute Customer customer, Principal p, HttpSession session, Model m){
    
  // check valid user .....
  
    String userid = customer.getUserId();
    session.setAttribute("userid", userid);

    Customer cust = this.custRepo.getUserByUserName(userid);
    String email = cust.getcEmail();
 
    Random rd = new Random();

    try{
    int min = 100000;
    int max = 999999;

    int ottp = rd.nextInt(max - min + 1)+ min;

    String myOtp = Integer.toString(ottp);

    session.setAttribute("myotp", myOtp);
    session.setAttribute("email", email);

    String message = 
     "<div style='width:100vw; height:fit-content;  border: 0.1vw solid red; padding:2px; align-items: center; text-align:center; justify-content: center ; padding-bottom:5vw;'><div  style=' width:100%; height:25vw; background:red; padding-top:4vw; text-align:center; '><h1 style='  font-size: 10vw; color: white;'>Star Life Bank</h1></div><h3 style='color: red; font-size: 3vw;'>WELCOME TO STAR LIFE BANK</h3><h3 style='color: black; font-size: 3vw; font-family: Verdana;'>Your OTP for reset password</h3><h1 style='color: red; font-size: 6vw; text-align:center;'>"+myOtp+"</h1></div>";
    

    String subject="ONE TIME PASSWORD"; 

    if(cust != null){

      Message messagee = new Message();
      messagee.setType("alert-success");
      // messagee.setMessage("OTP has been sent successfully ! Please check email");
      
      // session.setAttribute("messagee", messagee);
      this.emailSEndService.sendmaill(email,message,subject); 
    }
   
   }
   catch(Exception e){
    e.printStackTrace();
   }
  
   m.addAttribute("userid", userid);
   
		return "forgetPassword";
    
	}
  


  // verify otp here ......................

  @PostMapping("/home/forgetPasswordPage/verify_otp")
  public String verifyOtp(@ModelAttribute SigninHelper signinHelper, HttpSession session,Model m) {
   
   String savedOtp =(String) session.getAttribute("myotp");
   
   String currOtp = signinHelper.getNewOtp();

   String email =(String) session.getAttribute("email");

   Customer customer = this.custRepo.findByEmail(email);

   boolean flag = false;

   if(customer != null){

    if(savedOtp.equals(currOtp)){

       flag=true;
       
       session.setAttribute("messagee", new Message("alert-success", "OTP verified successfully !!! "));
      }else{
        session.setAttribute("messagee", new Message("alert-danger", "Invalid OTP ! Please enter valid otp "));
      }
    }else{ 
      session.setAttribute("messagee", new Message("alert-danger", "User not found !! please enter valid userid"));   
    }


    // otp verification confirmation 

    session.setAttribute("flag", flag);

    // set attribute for input otp
     
    m.addAttribute("OTP", currOtp);

    // fetch userid from session 
     
   String userid =(String) session.getAttribute("userid");
   m.addAttribute("userid", userid);

      return "forgetPassword";
  }
  
// method for reset password page ...........

@GetMapping("/home/forgetPasswordPage/resetpass")
public String getResetPage(HttpSession session){

  boolean flag =(boolean) session.getAttribute("flag");

  if(!flag){
    return "forgetPassword";
  }

  return "NewPasswordSetUp";
}

}