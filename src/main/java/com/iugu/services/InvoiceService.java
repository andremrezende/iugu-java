package com.iugu.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.iugu.IuguConfiguration;
import com.iugu.exceptions.IuguException;
import com.iugu.model.Invoice;
import com.iugu.model.Item;
import com.iugu.responses.InvoiceResponse;
import com.iugu.utils.ConvertionUtils;

public class InvoiceService {

	private IuguConfiguration iugu;
	private final String CREATE_URL = IuguConfiguration.url("/invoices");
	private final String FIND_URL = IuguConfiguration.url("/invoices/%s");
	private final String DUPLICATE_URL = IuguConfiguration.url("/invoices/%s/duplicate");
	private final String REMOVE_URL = IuguConfiguration.url("/invoices/%s");
	private final String CANCEL_URL = IuguConfiguration.url("/invoices/%s/cancel");
	private final String REFUND_URL = IuguConfiguration.url("/invoices/%s/refund");
	private final String FIND_CUSTOMER_URL=IuguConfiguration.url("/invoices?customer_id=%s");

	public InvoiceService(IuguConfiguration iuguConfiguration) {
		this.iugu = iuguConfiguration;
	}

	public InvoiceResponse create(Invoice invoice) throws IuguException {
		Response response = this.iugu.getNewClient().target(CREATE_URL).request().post(Entity.entity(invoice, MediaType.APPLICATION_JSON));

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		if (ResponseStatus == 200)
			return response.readEntity(InvoiceResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error creating invoice!", ResponseStatus, ResponseText);
	}

	public InvoiceResponse find(String id) throws IuguException {
		Response response = this.iugu.getNewClient().target(String.format(FIND_URL, id)).request().get();

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		if (ResponseStatus == 200)
			return response.readEntity(InvoiceResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error finding invoice with id: " + id, ResponseStatus, ResponseText);
	}

	public InvoiceResponse duplicate(String id, Date date) throws IuguException {
		SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
		Form form = new Form();

		form.param("due_date", sm.format(date));

		Response response = this.iugu.getNewClient().target(String.format(DUPLICATE_URL, id)).request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		if (ResponseStatus == 200)
			return response.readEntity(InvoiceResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error duplicating invoice with id: " + id, ResponseStatus, ResponseText);
	}

	public InvoiceResponse duplicate(String id, Date date, boolean ignoreCanceledEmail, boolean currentFinesOption) throws IuguException {
		SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
		Form form = new Form();

		form.param("due_date", sm.format(date));
		form.param("ignore_canceled_email", ConvertionUtils.booleanToString(ignoreCanceledEmail));
		form.param("current_fines_option", ConvertionUtils.booleanToString(currentFinesOption));

		Response response = this.iugu.getNewClient().target(String.format(DUPLICATE_URL, id)).request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		if (response.getStatus() == 200)
			return response.readEntity(InvoiceResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error duplicating invoice with id: " + id, ResponseStatus, ResponseText);
	}

	public InvoiceResponse remove(String id) throws IuguException {
		Response response = this.iugu.getNewClient().target(String.format(REMOVE_URL, id)).request().delete();

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		if (ResponseStatus == 200)
			return response.readEntity(InvoiceResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error removing invoice with id: " + id, ResponseStatus, ResponseText);
	}

	public InvoiceResponse cancel(String id) throws IuguException {
		Response response = this.iugu.getNewClient().target(String.format(CANCEL_URL, id)).request().put(null);

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		if (ResponseStatus == 200)
			return response.readEntity(InvoiceResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error canceling invoice with id: " + id, ResponseStatus, ResponseText);

	}

	public InvoiceResponse refund(String id) throws IuguException {
		Response response = this.iugu.getNewClient().target(String.format(REFUND_URL, id)).request().post(null);

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		if (ResponseStatus == 200)
			return response.readEntity(InvoiceResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error refunding invoice with id: " + id, ResponseStatus, ResponseText);
	}

	public InvoiceResponse findByCustomerId(String id) throws IuguException {
		Response response = this.iugu.getNewClient().target(String.format(FIND_CUSTOMER_URL, id)).request().get();

		int ResponseStatus = response.getStatus();
		String ResponseText = null;

		if (ResponseStatus == 200)
			return response.readEntity(InvoiceResponse.class);

		// Error Happened
		if (response.hasEntity())
			ResponseText = response.readEntity(String.class);

		response.close();

		throw new IuguException("Error finding invoice with customerId: " + id, ResponseStatus, ResponseText);
	}
	
	/**
	 * Alterar faturas pendentes, caso elas não tenha status pendente, será retornado erro.
	 * @param id Identificação da fatura
	 * @param date Nova data
	 * @param ignoreCanceledEmail Ignora o envio do e-mail de cancelamento da fatura atual.
	 * @param ignoreDueEmail Ignora o envio do e-mail de cobrança da nova fatura.
	 * @param currentFinesOption Caso seja enviado 'true', as multas da fatura atual são aplicadas à segunda via.
	 * @param items [] Adicione, altere ou remova itens a nova fatura. @see com.iugu.responses#ItemResponse
	 * @return InvoiceResponse
	 * @throws IuguException
	 * @author Andre M. Rezende
	 */
	public InvoiceResponse changePendingInvoiceById(String id, Date date, boolean ignoreCanceledEmail, boolean ignoreDueEmail, boolean currentFinesOption, List<Item> items) throws IuguException {
		if (items == null || items.size() < 1) {
			throw new IuguException("Items is null or empty.");
		}

		if (id == null || "".equals(id.trim())) {
			throw new IuguException("Invoice ID is null.");
		}

		Response response = null;
		InvoiceResponse invoiceResponse = null;
		try {
			 response = this.iugu.getNewClient().target(String.format(FIND_URL, id)).request().get();

			int responseStatus = response.getStatus();
			String responseText = null;

			// Invoice not found
			if (!response.hasEntity()) {
				responseText = response.readEntity(String.class);
				throw new IuguException("Error finding invoice with id: " + id, responseStatus, responseText);
			}
			
			Invoice invoice = new Invoice(id, date,  ignoreCanceledEmail,  ignoreDueEmail,  currentFinesOption, items);
			response = this.iugu.getNewClient().target(String.format(DUPLICATE_URL, id)).request().post(Entity.entity(invoice, MediaType.APPLICATION_JSON));

			responseStatus = response.getStatus();
			responseText = null;		
			
			// Error Happened
			if (!response.hasEntity()) {
				responseText = response.readEntity(String.class);
				throw new IuguException("Error duplicating invoice with id: " + id, responseStatus, responseText);			
			}
			
			if (response.getStatus() == 200) {
				invoiceResponse = response.readEntity(InvoiceResponse.class);
			} else {
				responseText = response.readEntity(String.class);
				throw new IuguException("Error duplicating invoice with id: " + id, responseStatus, responseText);			
			}

			return invoiceResponse;					
		} finally {
			if (response != null) {
				response.close();
			}
		}
	}

	// TODO Listar as faturas
}