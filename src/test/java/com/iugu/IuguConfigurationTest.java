package com.iugu;

import java.util.Date;

import org.junit.Test;

import com.iugu.exceptions.IuguException;
import com.iugu.model.Invoice;
import com.iugu.model.Item;
import com.iugu.responses.InvoiceResponse;
import com.iugu.services.InvoiceService;

public class IuguConfigurationTest {

	@Test
	public void testGetNewClient() {
		IuguConfiguration iuguConfiguration = new IuguConfiguration("token");
		InvoiceResponse response;

		try {
			response = new InvoiceService(iuguConfiguration).create(new Invoice("<adicionar_email>", new Date(), new Item("teste", 1, 100)));
			
			// Retorna ID do Invoice criado (Returns the ID of the created invoice)
			System.out.println(response.getId());
		}
		catch (IuguException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
