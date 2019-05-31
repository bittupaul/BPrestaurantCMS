package restaurantCMS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ClientRepositoryImpl implements ClientRepositoryCustom
{
	@PersistenceContext
	EntityManager em;
	
	private JavaMailSender jms;
	
	@Autowired
	public ClientRepositoryImpl(JavaMailSender jms)
	{
		this.jms=jms;
	}

	public List<Clients> getClientsByDate(String date) {
		System.out.println("at rep: "+date);
		String sqlquery = "SELECT c.* FROM client_details as c WHERE c.date = '"+date+"'"; 
		Query query = em.createNativeQuery(sqlquery,Clients.class);
		return query.getResultList();
	}

	public List<Clients> getClientsByMobile(Long mobile) {
		String sqlquery = "SELECT c.* FROM client_details as c WHERE c.mobile = "+mobile; 
		Query query = em.createNativeQuery(sqlquery,Clients.class);
		return query.getResultList();
	}

	public List<Clients> getClientsByEmail(String email) {
		String sqlquery = "SELECT c.* FROM client_details as c WHERE c.email = '"+email+"'";
		Query query = em.createNativeQuery(sqlquery,Clients.class);
		return query.getResultList();
	}

	public List<Clients> getClientsByName(String name) {
		String sqlquery = "SELECT c.* FROM client_details as c WHERE c.name = '"+name+"'";
		Query query = em.createNativeQuery(sqlquery,Clients.class);
		return query.getResultList();
	}

	public List<Clients> getClientsByPaymentMethod(String paymentMethod) {
		String sqlquery = "SELECT c.* FROM client_details as c WHERE c.payment_method = '"+paymentMethod+"'";
		Query query = em.createNativeQuery(sqlquery,Clients.class);
		return query.getResultList();
	}
	
	public void sendOffer(String offerMessage) throws MailException, MessagingException
	{
		SimpleMailMessage mail = new SimpleMailMessage();

		String sqlquery="SELECT c.* FROM client_details as c WHERE c.id > 0";
		Query query = em.createNativeQuery(sqlquery, Clients.class);
		List<Clients> recipientClients = query.getResultList(); 
		Iterator<Clients> it = recipientClients.iterator();
		List<String> recipients= new ArrayList<String>();
		while(it.hasNext())
		{
			recipients.add(it.next().getEmail());
		}
		List<Object> distinctRecipients = recipients.stream().distinct().collect(Collectors.toList());
		Iterator<Object> it2 = distinctRecipients.iterator(); 
		while(it2.hasNext())
		{
			mail.setTo(it2.next().toString());
			mail.setSubject("Offer from BP Restaurant");
			mail.setText(offerMessage);
			jms.send(mail);
		}
	}
	
}
