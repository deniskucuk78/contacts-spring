package fr.gtm.contacts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.entities.Contact;

@Repository
public interface ContactDAO extends JpaRepository<Contact, Long> {
	
	List<Contact> getByNomStartingWith(String nom);
	
	@Query("SELECT c FROM Contact c JOIN FETCH c.adresses WHERE c.id = ?1")
	Contact getContactById(long id);


}
