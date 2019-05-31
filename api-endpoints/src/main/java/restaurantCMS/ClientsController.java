package restaurantCMS;

import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BPrestaurantCMS")
public class ClientsController {
	
	@Autowired
	ClientsDAO cdao;
	
	
	@PostMapping("/clients/add")
	public Clients addNewClient(@Valid @RequestBody Clients client)
	{
		return cdao.addNewClient(client);
	}
	
	
	@GetMapping("/clients")
	public List<Clients> getAllClients()
	{
		return cdao.getAllClients();
	}
	
	
	@GetMapping("clients/name/{name}")
	public List<Clients> getClientsByName(@PathVariable(value="name") String name)
	{
		return cdao.getClientsByName(name);
	}
	
	
	@GetMapping("clients/email/{email}")
	public List<Clients> getClientsByEmail(@PathVariable(value="email") String email)
	{
		return cdao.getClientsByEmail(email);
	}
	
	
	@GetMapping("clients/paymentMethod/{paymentMethod}")
	public List<Clients> getClientsByPaymentMethod(@PathVariable(value="paymentMethod") String paymentMethod)
	{
		return cdao.getClientsByPaymentMethod(paymentMethod);
	}
	
	
	@GetMapping("clients/mobile/{mobile}")
	public List<Clients> getClientsByMobile(@PathVariable(value="mobile") Long mobile) 
	{
		return cdao.getClientsByMobile(mobile);
	}
	
	
	@GetMapping("clients/date/{date}")
	public List<Clients> getClientsByDate(@PathVariable(value="date") String date)
	{
		return cdao.getClientsByDate(date);
	}
	
	
	@PostMapping("clients/sendOffer")
	public void sendOffer(@Valid @RequestBody String offerMessage) throws MailException, MessagingException
	{
		cdao.sendOffer(offerMessage);
	}
}
