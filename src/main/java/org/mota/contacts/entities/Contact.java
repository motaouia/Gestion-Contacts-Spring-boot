package org.mota.contacts.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contact implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContact;
	private String prenomContact;
	private String nomContact;
	@Temporal(TemporalType.DATE)
	private Date dateNaissanceContact;
	private long telContacts;
	private String emailContact;
	private String photoContact;

	public Contact() {
	}

	public Contact(String prenomContact, String nomContact, Date dateNaissanceContact, long telContacts,
			String emailContact, String photoContact) {
		super();
		this.prenomContact = prenomContact;
		this.nomContact = nomContact;
		this.dateNaissanceContact = dateNaissanceContact;
		this.telContacts = telContacts;
		this.emailContact = emailContact;
		this.photoContact = photoContact;
	}

	public Long getIdContact() {
		return idContact;
	}

	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}

	public String getPrenomContact() {
		return prenomContact;
	}

	public void setPrenomContact(String prenomContact) {
		this.prenomContact = prenomContact;
	}

	public String getNomContact() {
		return nomContact;
	}

	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}

	public Date getDateNaissanceContact() {
		return dateNaissanceContact;
	}

	public void setDateNaissanceContact(Date dateNaissanceContact) {
		this.dateNaissanceContact = dateNaissanceContact;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public String getPhotoContact() {
		return photoContact;
	}

	public void setPhotoContact(String photoContact) {
		this.photoContact = photoContact;
	}

	public long getTelContacts() {
		return telContacts;
	}

	public void setTelContacts(long telContacts) {
		this.telContacts = telContacts;
	}

}