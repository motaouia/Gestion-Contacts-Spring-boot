package org.mota.contacts.dao;

import org.mota.contacts.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	@Query("select c from Contact c where c.nomContact like :x")
	public Page<Contact> findByKeyWord(@Param("x") String key, Pageable pageable);

}
