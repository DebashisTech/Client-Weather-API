package com.qsp.listener;

import com.qsp.modelmapper.ClientMapper;
import com.qsp.modelmapper.ResponseEntityMapper;
import com.qsp.repository.AuditRepository;
import com.qsp.repository.ClientRepository;
import com.qsp.requestdto.ClientSaveDto;
import com.qsp.util.CacheUtil;

import java.util.Map;
import java.util.UUID;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.qsp.entity.Audit;
import com.qsp.entity.Client;
import com.qsp.event.ClientSaveEvent;

@Component
public class AddClientListener {

	@Autowired
	private JavaMailSender mailsender;

	@Autowired
	@Qualifier("otpholder")
	private Map<String, Object[]> otpholder;

	@Autowired
	private AuditRepository auditrepo;

	@Autowired
	private ClientRepository clientrepo;

	@Autowired
	private ClientMapper clientmapper;

	@EventListener
	@Async
	public void addClient(ClientSaveEvent event) {
		Object objects[] = otpholder.get(event.getEmailid());
		ClientSaveDto dto = (ClientSaveDto) objects[0];
		Client client = clientmapper.clientSaveDtoToClient(dto, new Client());
		clientrepo.save(client);

	}

	@EventListener
	@Async
	public void notifyClient(ClientSaveEvent event) {
		SimpleMailMessage message = new SimpleMailMessage();
		Object object[] = otpholder.get(event.getEmailid());
		String name = ((ClientSaveDto) object[0]).getName();
		message.setFrom("raja2002pradhan@gmail.com");
		message.setTo(event.getEmailid());
		message.setSubject("Notification from Weather App");
		StringBuilder builder = new StringBuilder();
		builder.append("Dear " + name + " \n\nThank you for your subscription. \nRegards, \nWeather Service");
		message.setText(builder.toString());
		mailsender.send(message);

	}

	@EventListener
	@Async
	public void auditAddClient(ClientSaveEvent event) {
		Audit audit = Audit.builder().auditid(UUID.randomUUID().toString()).user(event.getEmailid()).action("REGISTER")
				.message("New User subscribed").build();
		auditrepo.save(audit);
	}
}
