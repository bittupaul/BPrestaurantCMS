package restaurantCMSTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import restaurantCMS.ClientsDAO;
import restaurantCMS.ClientsController;
import restaurantCMS.Clients; 
import restaurantCMS.Application;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ClientsController.class, secure = false)
@ContextConfiguration(classes=Application.class)
public class restaurantCMSTestClass {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClientsDAO cdao;

	Clients mockClient = new Clients(9898707964L,"bittu.1.1999@gmail.com","Bittu","Debit Card",1200F,"28-05-19");

	String sampleClientJson = "{\"name\":\"Bittu P. Paul\",\"mobile\":9898707965,\"email\":\"bittupaulofficial@gmail.com\",\"paymentMethod\":\"Credit Card\",\"billAmount\":1500,\"date\":\"28-05-19\"}";

	@Test
	public void getClientsByName() throws Exception {
		
		List<Clients> mockList = new ArrayList<Clients>();
		mockList.add(mockClient);

		Mockito.when(cdao.getClientsByName(Mockito.anyString())).thenReturn(mockList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/BPrestaurantCMS/clients/name/Bittu").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		String expected="[{name:Bittu}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void getClientsByEmail() throws Exception {
		
		List<Clients> mockList = new ArrayList<Clients>();
		mockList.add(mockClient);

		Mockito.when(cdao.getClientsByEmail(Mockito.anyString())).thenReturn(mockList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/BPrestaurantCMS/clients/email/bittu.1.1999@gmail.com").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		String expected="[{email:bittu.1.1999@gmail.com}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void getClientsByPaymentMethod() throws Exception {
		
		List<Clients> mockList = new ArrayList<Clients>();
		mockList.add(mockClient);

		Mockito.when(cdao.getClientsByPaymentMethod(Mockito.anyString())).thenReturn(mockList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/BPrestaurantCMS/clients/paymentMethod/Debit Card").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		String expected="[{paymentMethod:\"Debit Card\"}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void getClientsByDate() throws Exception {
		
		List<Clients> mockList = new ArrayList<Clients>();
		mockList.add(mockClient);

		Mockito.when(cdao.getClientsByDate(Mockito.anyString())).thenReturn(mockList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/BPrestaurantCMS/clients/date/28-05-19").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		String expected="[{date:28-05-19}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void getClientsByMobile() throws Exception {
	
		List<Clients> mockList = new ArrayList<Clients>();
		mockList.add(mockClient);

		Mockito.when(cdao.getClientsByMobile(Mockito.anyLong())).thenReturn(mockList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/BPrestaurantCMS/clients/mobile/9898707965").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		
		String expected="[{mobile:9898707964}]";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void addNewClient() throws Exception 
	{
	
		Mockito.when(cdao.addNewClient(Mockito.any(Clients.class))).thenReturn(mockClient);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/BPrestaurantCMS/clients/add").accept(MediaType.APPLICATION_JSON)
				.content(sampleClientJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}



}
