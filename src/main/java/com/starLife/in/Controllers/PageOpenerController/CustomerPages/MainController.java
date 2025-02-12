package com.starLife.in.Controllers.PageOpenerController.CustomerPages;


import java.security.Principal;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



// import com.starLife.in.starLifeConfig.CustomCustomerDetails;


import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class MainController {





	
  // Home page handler ................................

	@GetMapping("")
	public String home(Model m) {
		m.addAttribute("title","Star Life : Home page");
		return "newHome";
	}
	
	// Home account open page handler ................................
		
	@GetMapping("/Open_new_accountt")
	public String OpenAccount(Model m, HttpSession session) {
		m.addAttribute("title","Create new account");
		session.removeAttribute("alert");
		return "Open_new_account";
	}

	// Home forget password page handler ................................

	 @GetMapping("/forgetPasswordPage")
	 public String openForgetPasswordPage(Model m) {
		 m.addAttribute("title","Forgotten password");
		 return "forgetPassword";
	 }
	 
	//  reset password page handler ....................................

	 @GetMapping("/resetPassword")
	 public String passwordResetPageOpen(Model m) {
		 m.addAttribute("title","Reset password !!");
		 return "NewPasswordSetUp";
	 }
	 
	 
	 // signin system .......SigninHelper...........................
	
	//  @PostMapping("/kris")
	//   public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody SigninHelper signinHelper ) throws Exception{
		  
	// 	  String username =signinHelper.getEmail();
	// 	  String passw = signinHelper.getCpassword();
		  
	// 	  Authentication authent =authenticate(username , passw);
	// 	  SecurityContextHolder.getContext().setAuthentication(authent);
          
  //         String token =jwtprovider.generateToken(authent);
          
  //         System.out.println(token);
          
          
  //         AuthResponse resp = new AuthResponse(token, "sign in successfully");
          
	// 	  return new ResponseEntity<AuthResponse>(resp , HttpStatus.CREATED);
		  
	//   }

	// private Authentication authenticate(String username, String passw) {
		
	// 	UserDetails userDetails = customCustomerDetails.loadUserByUsername(username);
		
	// 	if(userDetails == null) {
	// 		throw new BadCredentialsException("invalid user");
	// 	}
		
	// 	if(!bcptp.matches(passw,userDetails.getPassword())) {
	// 		throw new BadCredentialsException("invalid password");
	// 	}
				
	// 	return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	// }
	 
	 
// handler for get customer page support ..........

@GetMapping("/Customer_Support")
public String getCustSuppPage(Model m,HttpSession  session){

  
	m.addAttribute("session", session);

   return "customerSupport";
}



// handler for cardService ..............

@GetMapping("/cardService")
public String openCardServicePage(Model m , Principal p){
  m.addAttribute("title", "Star Bank : Card service");
	return "cardService";
}


// for incomplete work access page ..........................................

@GetMapping("/incomplete_task_page")
public String getIncomplete(Model m){
  m.addAttribute("title", "Incomplete work page");

	return "incompleteAlert";
}


/// download image here.......................................................

@GetMapping("/download")
public ResponseEntity<?> DOWNLOADfILE(@RequestParam MultipartFile file){
	return new ResponseEntity<>("Upload failed ", HttpStatus.INTERNAL_SERVER_ERROR);
}




}
