package com.qsp.modelmapper;

import org.springframework.stereotype.Component;
import com.qsp.entity.Client;
import com.qsp.requestdto.ClientSaveDto;
import com.qsp.util.ClientType;

@Component
public class ClientMapper {
	public Client clientSaveDtoToClient(ClientSaveDto dto, Client client) {
		client.setEmail(dto.getEmail().trim());
		client.setActive(true);
		client.setName(dto.getName());
		client.setPhoneNumber(dto.getPhonenumber());
		client.setUsertype(ClientType.getUserType(dto.getUsertype()));
		return client;

	}

}
