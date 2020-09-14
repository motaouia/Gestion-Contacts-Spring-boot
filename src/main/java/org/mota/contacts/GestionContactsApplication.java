package org.mota.contacts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mota.contacts.dao.ContactRepository;
import org.mota.contacts.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionContactsApplication implements CommandLineRunner {
	
	@Autowired
	private ContactRepository contactRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GestionContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Contact ct1 = new Contact("Ibrahim", "YACOUBI", df.parse("10/01/1990"), 68891122, "ibrahim.yacoubi@koko.com", "ibrahim.jpg");
		contactRepository.save(new Contact("Ibrahim", "YACOUBI", df.parse("10/01/1990"), 68891122, "ibrahim.yacoubi@koko.com", "ibrahim.jpg"));
		contactRepository.save(new Contact("Mohamed", "HASSANI", df.parse("30/03/1992"), 68891122, "Mohamed.HASSANI@koko.com", "Mohamed.jpg"));
		for(Contact ct : contactRepository.findAll()) {
			System.out.println(ct.getEmailContact());
		}*/
	}

}
