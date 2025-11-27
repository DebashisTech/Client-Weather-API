package com.qsp.entity;


import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.qsp.util.ClientType;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Client {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
	
	@Nonnull
    private String name;
	
	@Nonnull
    private String phoneNumber;
	
	
	@Nonnull
	@Column(unique=true)
    private String email;
	
	@Enumerated(EnumType.STRING)
	private ClientType usertype;
	
	@NonNull
	private Boolean active;
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime createdon;
	
	@LastModifiedDate
	private LocalDateTime lastupdate;
	
}
