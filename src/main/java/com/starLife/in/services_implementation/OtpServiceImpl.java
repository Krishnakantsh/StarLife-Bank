package com.starLife.in.services_implementation;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.starLife.in.ExceptionHandler.OtpException;
import com.starLife.in.service.OtpService;


@Service
public class OtpServiceImpl  implements OtpService {

  @Override
  public String generateOtp() throws OtpException {
  
    int max = 999999;
    int min = 100000;

    Random rd = new Random();
    int otp = rd.nextInt((max - min) + 1) + min; // Ensures a 6-digit number

    return String.valueOf(otp);
    
  }



  @Override
  public Boolean verifyOtp(String otp) throws OtpException {
  
  
     



    return null;

  }
  
}
