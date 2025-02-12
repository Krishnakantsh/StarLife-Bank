package com.starLife.in.Controllers.PageOpenerController.CustomerPages;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class logoutController {
  
   @GetMapping("/home/customerDashboard/logoutsuccess")
    public String logout(RedirectAttributes redirectAttributes) {
       
        return "redirect:/home";  // Redirect to login page after logout
    }


}
