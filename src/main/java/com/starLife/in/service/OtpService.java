package com.starLife.in.service;

import com.starLife.in.ExceptionHandler.OtpException;

public interface OtpService {

  public String generateOtp()  throws OtpException;
  public Boolean verifyOtp(String otp)  throws OtpException;
  
}
