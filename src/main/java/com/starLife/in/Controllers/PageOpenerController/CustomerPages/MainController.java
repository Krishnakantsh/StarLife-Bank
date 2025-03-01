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
