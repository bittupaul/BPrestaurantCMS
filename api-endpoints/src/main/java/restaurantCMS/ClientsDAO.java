package restaurantCMS;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service
public class ClientsDAO {
	
	@Autowired
	ClientRepository cr;

	/*To insert a new client into the database*/
	public Clients addNewClient(Clients c)
	{
		return cr.save(c);
	}
	
	/*To send an offer to all the clients on an occasion*/
	public void sendOffer(String offerMessage) throws MailException, MessagingException
	{
		cr.sendOffer(offerMessage);
	}
		
	/*To get(retrieve) all the clients from the database*/
	public List<Clients> getAllClients()
	{
		return cr.findAll();
	}
	
	public List<Clients> getClientsByName(String name)
	{
		List<Clients> list = cr.getClientsByName(name);
		if(list.isEmpty())
		{
			Clients c= new Clients();
			c.setName("Client with the submitted name not found");
			c.setBillAmount(null);
			c.setEmail(null);
			c.setMobile(00L);
			c.setPaymentMethod(null);
			list.add(c);
			return list;
		}
		else
			return list;
	}
	
	public List<Clients> getClientsByMobile(Long mobile)
	{
		List<Clients> list = cr.getClientsByMobile(mobile);
		if(list.isEmpty())
		{
			Clients c= new Clients();
			c.setName("Client with the submitted mobile number not found");
			c.setBillAmount(null);
			c.setEmail(null);
			c.setMobile(00L);
			c.setPaymentMethod(null);
			list.add(c);
			return list;
		}
		else
			return list;
	}
	
	public List<Clients> getClientsByEmail(String email)
	{
		List<Clients> list = cr.getClientsByEmail(email);
		if(list.isEmpty())
		{
			Clients c= new Clients();
			c.setName("Client with the submitted email not found");
			c.setBillAmount(null);
			c.setEmail(null);
			c.setMobile(00L);
			c.setPaymentMethod(null);
			list.add(c);
			return list;
		}
		else
			return list;
	}
	
	public List<Clients> getClientsByPaymentMethod(String paymentMethod)
	{
		List<Clients> list = cr.getClientsByPaymentMethod(paymentMethod);
		if(list.isEmpty())
		{
			Clients c= new Clients();
			c.setName("Clients with the submitted paymentMethod not found");
			c.setBillAmount(null);
			c.setEmail(null);
			c.setMobile(00L);
			c.setPaymentMethod(null);
			list.add(c);
			return list;
		}
		else
			return list;
	}

	public List<Clients> getClientsByDate(String date) 
	{
		List<Clients> list = cr.getClientsByDate(date);
		if(list.isEmpty())
		{
			Clients c= new Clients();
			c.setName("No one checked in, on the given date.");
			c.setBillAmount(null);
			c.setEmail(null);
			c.setMobile(00L);
			c.setPaymentMethod(null);
			list.add(c);
			return list;
		}
		else
			return list;
	}
	
	
}
