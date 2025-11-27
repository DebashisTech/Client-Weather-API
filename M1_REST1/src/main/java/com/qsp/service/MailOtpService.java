package com.qsp.service;

import com.qsp.requestdto.ClientSaveDto;

public interface MailOtpService {
    public String sentOtp(String emailid, ClientSaveDto dto);
    public String validateOtp(String emailid,String otp);
}
