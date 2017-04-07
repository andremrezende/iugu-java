package com.iugu.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.iugu.IuguConfiguration;
import com.iugu.enums.InvoiceType;
import com.iugu.model.Customer;
import com.iugu.model.Invoice;
import com.iugu.model.Item;
import com.iugu.responses.InvoiceResponse;
import com.iugu.utils.ConvertionUtils;

/**
 * Classe de testes de Invoice.
 * 
 * @author Andre M. Rezende
 *
 */
public class InvoiceServiceTest {
	IuguConfiguration iuguConfiguration = new IuguConfiguration("token");

	/**
	 * Testes de fatura.
	 * 
	 * @author Andre M. Rezende
	 */
	@Test
	public void testFind() {
		InvoiceService service = new InvoiceService(iuguConfiguration);

		CustomerService customerService = new CustomerService(iuguConfiguration);
		Customer customer = new Customer("Test");
		customer.withEmail("<adicionar_email>");

		try {
			customerService.create(customer);
			Item item = new Item("teste de invoice", 2, 1000);
			Invoice invoice = new Invoice("<adicionar_email>", new Date(), item);
			InvoiceResponse invoiceResponse = service.create(invoice);
			// Id de uma fatura criada.
			String id = invoiceResponse.getId();
			System.out.println(id);

			// Buscar fatura
			InvoiceResponse invoiceResponse2 = service.find(id);
			assertTrue(invoiceResponse2.getId().equals(id));

			// Alterar fatura
			if (InvoiceType.PENDING.getValue().equals(invoiceResponse2.getStatus())) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");

				// Nova data de fatura
				String dateInString = "31-08-2017";
				Date date = sdf.parse(dateInString);
				List<Item> items = ConvertionUtils.itemsResponseToItem(invoiceResponse2.getItems());
				for (Item itemResponse : items) {
					 itemResponse.setQuantity(30);
					itemResponse.setDescription("Alterado descricao");
					// Preco inteiro com centavos
					itemResponse.setPriceCents(50);
					// Remover o item, padrao é false
					itemResponse.set_destroy(false);
				}
				Item newItem = new Item("teste de invoice", 2, 2517);
				items.add(newItem);
				
				invoiceResponse = service.changePendingInvoiceById(invoiceResponse2.getId(), date, false, false, false, items);

				// ID invoice
				assertFalse(invoiceResponse.getId().equals(id));
				//Adicionado valor de multa
				assertTrue(invoiceResponse.getItems().size() == 2);
				assertTrue(items.get(0).getQuantity() == 30);
				assertTrue(items.get(0).getPriceCents() == 50);
				assertTrue(invoiceResponse2.getItems().size() < invoiceResponse.getItems().size());
				assertTrue(invoiceResponse.getItems().get(1).getPrice().equals("R$ 0," + items.get(0).getPriceCents()));
			}
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

}
