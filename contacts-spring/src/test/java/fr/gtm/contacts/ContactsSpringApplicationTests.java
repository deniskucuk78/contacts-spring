package fr.gtm.contacts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import fr.gtm.contacts.dao.ContactDAO;
import fr.gtm.contacts.entities.Adresse;
import fr.gtm.contacts.entities.Contact;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ContactsSpringApplicationTests {
	
	@Autowired ContactDAO dao;

	@Test
	void getAll() {
		List<Contact> contacts = dao.findAll();
		System.out.println(contacts);
		assertTrue(contacts.size() > 0);
 	}
	
	@Test
	void getByNomLike() {
		List<Contact> contacts1 = dao.getByNomStartingWith("Beret");
		System.out.println(contacts1);
		assertTrue(contacts1.size() > 0);
 	}
	/*
	@Test
	void deleteById() {
		List<Contact> contacts1 = dao.findAll();
	    int taille1 = contacts1.size();
	    dao.deleteById(5L);
	    List<Contact> contacts2 = dao.findAll();
	    int taille2 = contacts2.size();
	    assertTrue(taille1 == taille2+1);
	}
	*/
	
	@Test
	void getContactById() {
		Contact contact = dao.getContactById(1L);
		assertEquals(2, contact.getAdresses().size());
	}

}
