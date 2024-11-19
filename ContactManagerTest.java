package junitinterface;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactManagerTest {

	public ContactManager cm;

	@BeforeEach
	void setUp() {
		cm = new ContactManager();
	}

	@Test
	void testAddContact() {
		assertTrue( cm.addContact( "Dev", "V", "1234567890" ) );
	}

	@Test
	void testAddDuplicateContact() {
		cm.addContact( "Dev", "V", "1234567890" );
		assertFalse( cm.addContact( "Dev", "V", "0987654321" ) );
	}

	@Test
	void testAddContactInvalidPhone() {
		assertFalse( cm.addContact( "Devika", "Vivek", "12345" ) );
	}

	@Test
	void testDeleteContact() {
		cm.addContact( "Dev", "V", "1234567890" );
		assertTrue( cm.deleteContact( "Dev" ) );
		assertFalse( cm.deleteContact( "Dev" ) );
	}

	@Test
	void testDeleteNonExistingContact() {
		assertFalse( cm.deleteContact( "NonExisting" ) );
	}

	@Test
	void testUpdateContact() {
		cm.addContact( "Dev", "V", "1234567890" );
		assertTrue( cm.updateContact( "Dev", "0987654321" ) );
	}

	@Test
	void testUpdateNonExistingContact() {
		cm.addContact( "Dev", "V", "1234567890" );
		assertFalse( cm.updateContact( "NonExisting", "0987654321" ) );
	}

	@Test
	void testViewContact() {
		cm.addContact( "Dev", "V", "1234567890" );
		assertTrue( cm.viewContact( "Dev" ) );
	}

	@Test
	void testViewNonExistingContact() {
		Exception e = assertThrows( IllegalArgumentException.class, () -> {
			cm.viewContact( "NonExisting" );
		} );
		assertEquals( "Contact not found", e.getMessage() );
	}

	@Test
	void testAddNullOrEmptyFirstName() {
		assertFalse( cm.addContact( "", "V", "1234567890" ) );
		assertFalse( cm.addContact( null, "V", "1234567890" ) );
	}

	@Test
	void testAddNullOrEmptyLastName() {
		assertFalse( cm.addContact( "Dev", "", "1234567890" ) );
		assertFalse( cm.addContact( "Dev", null, "1234567890" ) );
	}

	@Test
	void testAddInvalidPhoneNumberFormat() {
		assertFalse( cm.addContact( "Dev", "V", "1234567" ) );
		assertFalse( cm.addContact( "Dev", "V", "12345678901" ) );
	}
	@Test
	void testAddContactWithNonDigits() {
	    assertFalse(cm.addContact("Dev", "V", "12345@7890"));
	    assertFalse(cm.addContact("Dev", "V", "12-34567890"));
	}

	@Test
	void testAddContactWithAlphabeticChars() {
	    assertFalse(cm.addContact("Dev", "V", "abc1234567"));
	    assertFalse(cm.addContact("Dev", "V", "12345abc67"));
	}

	
}
