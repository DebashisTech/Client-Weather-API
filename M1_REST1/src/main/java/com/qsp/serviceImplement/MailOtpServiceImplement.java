package com.qsp.serviceImplement;

import java.time.LocalDateTime;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.qsp.exceptionhandling.AddClientException;
import com.qsp.repository.ClientRepository;
import com.qsp.requestdto.ClientSaveDto;
import com.qsp.service.MailOtpService;
import com.qsp.event.ClientSaveEvent;

@Service
public class MailOtpServiceImplement implements MailOtpService {

	private final RestTemplate restTemplate;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	@Qualifier("otpholder")
	private Map<String, Object[]> otpholder;

	@Autowired
	private Random random;

	@Autowired
	private JavaMailSender mailsender;

	@Autowired
	private ClientRepository clientrepo;

	MailOtpServiceImplement(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public String sentOtp(String emailid, ClientSaveDto dto) {
		emailid = emailid.trim();
		if (clientrepo.existsByEmail(emailid))
			throw new AddClientException("Email already exist for" + "weather report");
		try {
			Integer otp = 100000 + random.nextInt(900000);
			Object value[] = { dto, otp + "", LocalDateTime.now().plusMinutes(3) };
			otpholder.put(emailid, value);
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("raja2002pradhan@gmail.com");
			message.setTo(emailid);
			message.setSubject("Otp alert from weather app");
			message.setText("otp for mail verification:" + otp);
			mailsender.send(message);
			return "Otp sent to mail :" + emailid;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddClientException("Invalid email id :" + emailid);
		}
	}

	@Override
	public String validateOtp(String emailid, String otp) {
		Object[] value = otpholder.get(emailid);
		if (value == null)
			throw new RuntimeException("Re-register again");
		if (LocalDateTime.now().isAfter((LocalDateTime) value[2]))
			throw new RuntimeException("otp expired");
		String inmemoryotp = (String) value[1];
		if (otp.trim().equals(inmemoryotp)) {
			publisher.publishEvent(new ClientSaveEvent(emailid));
			return "OTP Validated successfully & Client saved";
		} else {
			throw new AddClientException("Invalid otp");
		}
	}

}
