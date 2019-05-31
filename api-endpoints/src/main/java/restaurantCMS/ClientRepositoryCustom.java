package restaurantCMS;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

public interface ClientRepositoryCustom {
	
	/*To get(retrieve) client(s)' information from the database by date*/
	List<Clients> getClientsByDate(String date);
	
	/*To get(retrieve) a client's information from the database by mobile number*/
	List<Clients> getClientsByMobile(Long mobile);
	
	/*To get(retrieve) a client's information from the database by email id*/
	List<Clients> getClientsByEmail(String email);
	
	/*To get(retrieve) a client's information from the database by name*/
	List<Clients> getClientsByName(String name);
	
	/*To get(retrieve) client(s)' information from the database by payment method*/
	List<Clients> getClientsByPaymentMethod(String paymentMethod);
	
	/*To send an offer to all the clients on account of some festival or special occasion*/
	void sendOffer(String offerMessage) throws MailException, MessagingException;	

}
