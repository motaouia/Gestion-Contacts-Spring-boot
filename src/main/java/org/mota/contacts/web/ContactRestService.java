package org.mota.contacts.web;

import java.util.List;

import org.mota.contacts.dao.ContactRepository;
import org.mota.contacts.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestService {

	@Autowired
	private ContactRepository contactRepository;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@RequestMapping(value = "/contacts/{idContact}", method = RequestMethod.GET)
	public Contact getContactById(@PathVariable Long idContact) {
		//spring.jackson.serialization.fail-on-empty-beans=false ==>application.properties
		Contact contact = contactRepository.getOne(idContact);
		if (contact != null) {
			return contact;
		} else {
			return new Contact();
		}
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact contact) {
		return contactRepository.save(contact);
		/*
		 * { "prenomContact" : "Khalid", "nomContact" : "Moncef", "dateNaissanceContact"
		 * : "12/04/1996", "telContacts" : 66719876, "emailContact" :
		 * "khalid.moncef@koko.com", "photoContact" : "khalid.png" }
		 */
	}
	
	@RequestMapping(value = "/contacts/{idContact}", method = RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable Long idContact) {
		//localhost:8080/contacts/id
		Contact contact = contactRepository.getOne(idContact);
		if(contact != null) {
			contactRepository.delete(contact);
			return true;
		}else {
			return false;
		}
	}
	
	@RequestMapping(value = "/contacts/{idContact}", method = RequestMethod.PUT)
	public Contact editContact(@PathVariable Long idContact, @RequestBody Contact contact) {
		contact.setIdContact(idContact);
		return contactRepository.save(contact);
	}
	
	@RequestMapping(value = "/chercherContacts", method = RequestMethod.GET)
	public Page<Contact> getContactsByKeyWord(
			@RequestParam (name = "mc", defaultValue = "") String keyword,
			@RequestParam (name = "page", defaultValue = "0")int page,
			@RequestParam (name = "size", defaultValue = "5")int size) {
		return contactRepository.findByKeyWord("%"+keyword+"%", PageRequest.of(page, size, Sort.unsorted()));
	}

}
