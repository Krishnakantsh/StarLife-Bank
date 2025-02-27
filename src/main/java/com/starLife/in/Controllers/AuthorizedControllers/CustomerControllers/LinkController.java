package com.starLife.in.Controllers.AuthorizedControllers.CustomerControllers;

import java.security.Principal;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.starLife.in.Entity.Customer;
import com.starLife.in.helper.Message;
import com.starLife.in.helper.SigninHelper;
import com.starLife.in.repository.CustomerRepository;
import com.starLife.in.service.EmailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/customer/customerDashboard")
public class LinkController {
  
	@Autowired
	private CustomerRepository cstmrRepo;

	

	@Autowired
	private EmailService EmailService;
		

// link adhar ............................................................

     

		 @GetMapping("/adharlink")
     public String linkAdhar(@ModelAttribute Customer cust , Model m, Principal p , HttpSession session) {
    	 
  	  String username = p.getName();
    	 
  	  Customer customer = this.cstmrRepo.getUserByUserName(username); 	
				 
    	 m.addAttribute("title", "Aadhar Card Link  ");
    	 m.addAttribute("customer", customer);
       
			 session.removeAttribute("linked");
			 System.out.println(customer);
    	 
    	 return "customerService/adharlink";
     }

 // link aadhar process handler .........
      
    @PostMapping("/LinkAdhar_process")
     public String getadharLinkOtp(@ModelAttribute Customer cust , Principal p , Model m , HttpSession session){
       
    String aadhar_num = cust.getcAadhar();

    String Userid = cust.getUserId(); 
    
    Customer customer = this.cstmrRepo.getUserByUserName(p.getName());

    System.out.println("current adhar : "+aadhar_num);
    System.out.println("current userid : "+Userid);
    System.out.println("saved adhar : "+ customer.getUserId());
    System.out.println("saved userid : "+ customer.getcAadhar());

    if(customer.getUserId().equals(Userid)  && customer.getcAadhar().equals(aadhar_num)  ){
      
           if(customer.getAdharLinkStatus().isEmpty()){
               customer.setAdharLinkStatus("done");
               this.cstmrRepo.save(customer);
               Message message = new Message("alert-success" , "Aadhar has been linked successfully  !!");
               session.setAttribute("Aadharmessage",message);
               return "customerService/adharlink";
           } 
           else{
            Message message = new Message("alert-success" , "Aadhar already linked !!");
            session.setAttribute("Aadharmessage",message);

            return "customerService/adharlink";
           }        
    }

    Message message = new Message("alert-danger" , "Some error occured");
    session.setAttribute("Aadharmessage",message);

    return "customerService/adharlink";
}
    


// status adhar ............................................................

     

@GetMapping("/adharstatusForm")
				 public String adharStatus(Model m, Principal p, HttpSession session) {
					 
					String username = p.getName();
					 
					Customer customer = this.cstmrRepo.getUserByUserName(username); 	
						 
					 m.addAttribute("title", " Aadhar Status : Form ");
					 m.addAttribute("customer", customer);
					 session.removeAttribute("linkeddd");
           session.removeAttribute("showProcessForm");
           session.removeAttribute("notlinked");
           session.removeAttribute("error");
					 System.out.println(customer);
					 
					 return "customerService/aadharStatus";
}

// ADHAR STATUS OTP send handler................ 

@PostMapping("/LinkAdhar_getOtp")
    public String getadharStarusOtp( Principal p  , @ModelAttribute Customer cust, Model m , HttpSession session){
                  
         String adhar = cust.getcAadhar();
      
         Customer custo = this.cstmrRepo.getUserByUserName(p.getName());

         session.setAttribute("adharr", adhar);

        System.out.println(custo);
        String email = custo.getcEmail();
      
        Random rd = new Random();     
        int max = 9999;
        int min = 1000;
        String otp = Integer.toString(rd.nextInt(max-min+1)+min);
        
        String message = 
        "<div style='width:100vw; height:fit-content;  border: 0.1vw solid red; padding:2px; align-items: center; text-align:center; justify-content: center ; padding-bottom:5vw;'><div  style=' width:100%; height:25vw; background:red; padding-top:4vw; text-align:center; '><h1 style='  font-size: 10vw; color: white;'>Star Life Bank</h1></div><h3 style='color: red; font-size: 3vw;'>WELCOME TO STAR LIFE BANK</h3><h3 style='color: black; font-size: 3vw; font-family: Verdana;'>Your OTP for adhar status </h3><h1 style='color: red; font-size: 6vw; text-align:center;'>"+otp+"</h1></div>";
        
        
        String subject="ONE TIME PASSWORD"; 
        
        this.EmailService.sendmaill(email, message, subject);

        if(otp != null){
        session.setAttribute("showProcessForm", "showProcessForm");
        session.setAttribute("otp", otp);
        return "customerService/aadharStatus";
        }
        else{
          session.setAttribute("error", "error");
        }

        return "customerService/aadharStatus";

      }


  // // ADHAR STATUS process handler................ 

@PostMapping("/adharStatus")
      public String adharStatusProceed(Principal p, @ModelAttribute Customer cust, Model m , HttpSession session, @ModelAttribute SigninHelper SigninHelper){
               
      String savedotp =(String) session.getAttribute("otp");
      String adharr = (String) session.getAttribute("adharr");

      String currOtp = SigninHelper.getNewOtp();
      
      Customer custo = this.cstmrRepo.getUserByUserName(p.getName());
      // System.out.println(currOtp);
      // System.out.println(savedotp);

       System.out.println(adharr);
       System.out.println(custo.getcAadhar());
      if(savedotp.equals(currOtp)){

           if( custo.getcAadhar().equals(adharr)  && custo.getAdharLinkStatus() != null){

              session.setAttribute("linkeddd","linkedd");
              System.out.println("done trigger here ");
                        
           }else{
             session.setAttribute("notlinked","notlinked");
             session.removeAttribute("linkedd");
             session.removeAttribute("otp");
           }   
      }
            return "customerService/aadharStatus";
      }


// e kyc adhar ..page access handler ..........................................................  

@GetMapping("/Kyc_status")
     public String ekyc(Model m, Principal p, HttpSession session) {
    	 
  	  String username = p.getName();
    	 
  	  Customer customer = this.cstmrRepo.getUserByUserName(username); 
      
      if(customer.getEkycstatus() == null){
        session.setAttribute("notEyc", "KYC- not complete");
      }else{
        session.setAttribute("yesKyc", "KYC-complete");
      }  
      m.addAttribute("customer", customer);
      m.addAttribute("title", "KYC- Make & status");
      
    	 return "customerService/ekyc";
       
     }

// ekyc process handler

@PostMapping("/ekycdone")
public String processKyc(Principal p, @ModelAttribute Customer cust, Model m , HttpSession session){
  
  String username = p.getName();
    	 
  Customer cstmr = this.cstmrRepo.getUserByUserName(username); 

  if( (cstmr.getName().equals(cust.getName()))  &&  (cstmr.getcEmail().equals(cust.getcEmail())  ) && (cstmr.getcPhone().equals(cust.getcPhone())  )){
       
      cstmr.setEkycstatus("true");
      this.cstmrRepo.save(cstmr);
      session.setAttribute("yesKyc", "KYC- complete");
      session.removeAttribute("notEyc");
  }
  else{
    session.setAttribute("notEyc", "KYC- not complete");
    session.setAttribute("kycerror", "KYC- not complete");
    session.removeAttribute("yesKyc");
  }

  return "customerService/ekyc";
}


// pancard adhar css............................................................

    
 @GetMapping("/pancard_stat")
	public String pancard(Model m, Principal p, HttpSession session) {

    String username = p.getName();
    	 
    Customer customer = this.cstmrRepo.getUserByUserName(username); 
    
    if(customer.getPanCard()== null){
        session.setAttribute("notPanLink", "panlnk- not complete");
    }else{
      session.setAttribute("panlinkDone", "panlinkDone-complete");
    }  
    m.addAttribute("customer", customer);
  	 
		return "customerService/pancardLink";
	}

// pan card link process handler .........................

@PostMapping("/panLinkProcess")
public String PanLinkProcess(Principal p, @ModelAttribute Customer cust, Model m , HttpSession session){

  
  String username = p.getName();
    	 
  Customer customer = this.cstmrRepo.getUserByUserName(username); 
  
  String panNum =cust.getPanCard();
  String Userid =cust.getUserId();

  if(customer.getUserId().equals(Userid)){
      customer.setPanCard(panNum);;
      this.cstmrRepo.save(customer);

    session.removeAttribute("notPanLink");
    session.setAttribute("panlinkDone", "panlinkDone");
    session.setAttribute("panAlert", "panAlert");
  }

  return "customerService/pancardLink";
}

// show pan card  status handler .......................



@PostMapping("/checkPanStatus")
public String checkPanStatus(Principal p, @ModelAttribute Customer cust, Model m , HttpSession session){

  String username = p.getName();
    	 
  Customer customer = this.cstmrRepo.getUserByUserName(username); 
  
  String panNum =cust.getPanCard();

  if( customer.getPanCard().equals(panNum)){
        session.setAttribute("showPanStatus", "showPanStatus");
        session.removeAttribute("panlinkDone");
  }else{
    session.setAttribute("notPanLink", "notPanLink");
    session.setAttribute("nopanAlert", "nopanAlert");
  }

	return "customerService/pancardLink";
	}


  // npci adhar css............................................................

  @GetMapping("/npciprocess")
  public String npci(Model m, Principal p, HttpSession session){

  String username = p.getName();
    	 
  Customer customer = this.cstmrRepo.getUserByUserName(username); 

  
  if(customer.getNpcistatus() == null){
    session.setAttribute("npciNotDone", "npciNotDone");
  }else{
    session.setAttribute("npciDone", "npciDone");
  }
 	 
    m.addAttribute("customer", customer);
    	 return "customerService/npciLink";
 }

// npci process handler 

@PostMapping("/npci_process")
public String npciProcess(Principal p, @ModelAttribute Customer cust, Model m , HttpSession session){

  
  String username = p.getName();
  Customer customer = this.cstmrRepo.getUserByUserName(username); 
  
  String account =cust.getAccountNo();
  String Userid =cust.getUserId();

  if(customer.getUserId().equals(Userid)  &&  customer.getAccountNo().equals(account)){
      customer.setNpcistatus("done");
      this.cstmrRepo.save(customer);      
    session.setAttribute("npciDone", "npciDone");
    session.setAttribute("npciAlert", "npciAlert");
  }

  return "customerService/npciLink";
}

// npci status show handler ................................

@PostMapping("/checkNpciStatus")
public String chechNpciStatus(Principal p, @ModelAttribute Customer cust, Model m , HttpSession session){

  String username = p.getName();
    	 
  Customer customer = this.cstmrRepo.getUserByUserName(username); 
  
  String account =cust.getAccountNo();

  if( customer.getAccountNo().equals(account) &&   customer.getNpcistatus() != null){
        session.setAttribute("npciStatus", "npciStatus");
        session.removeAttribute("npciDone");
  }else{
    session.setAttribute("npciNotDone", "npciNotDone");

  }

  return "customerService/npciLink";
	}

}
