package org.trafficmadness.www.user.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.trafficmadness.www.user.types.AdministratorType;

@XmlRootElement
@Entity
@Table(name="Administrator")
public class Administrator 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADMINISTRATOR_ID", nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AdministratorType administratorType;
}
