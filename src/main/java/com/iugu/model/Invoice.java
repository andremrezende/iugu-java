package com.iugu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.iugu.enums.PayableWith;
import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

public class Invoice implements Serializable {

	private static final long serialVersionUID = 1719931730355279382L;

	private String id;

	/**
	 * E-Mail do cliente
	 */
	private String email;

	/**
	 * Data de Expiração (DD/MM/AAAA)
	 */
	@JsonProperty("due_date")
	@JsonFormat("dd/MM/yyyy")
	@JsonSerialize(using = DateSerializer.class)
	private Date dueDate;

	/**
	 * Itens da Fatura
	 */
	private List<Item> items = new ArrayList<>();

	/**
	 * Payer
	 */
	private Payer payer;

	/**
	 * Emails de cópia
	 */
	@JsonProperty("cc_emails")
	private String ccEmails;

	/**
	 * Cliente é redirecionado para essa URL após efetuar o pagamento da Fatura
	 * pela página de Fatura da Iugu
	 */
	@JsonProperty("return_url")
	private String returnUrl;

	/**
	 * Cliente é redirecionado para essa URL se a Fatura que estiver acessando
	 * estiver expirada
	 */
	@JsonProperty("expired_url")
	private String expiredUrl;

	/**
	 * ID do cliente
	 */
	@JsonProperty("customer_id")
	private String customerId;

	/**
	 * URL chamada para todas as notificações de Fatura, assim como os webhooks
	 * (Gatilhos) são chamados
	 */
	@JsonProperty("notification_url")
	private String notificationUrl;

	/**
	 * Valor dos Impostos em centavos
	 */
	@JsonProperty("tax_cents")
	private Integer taxCents;

	/**
	 * Booleano para Habilitar ou Desabilitar multa por atraso de pagamento
	 */
	private Boolean fines;

	/**
	 * Determine a multa a ser cobrada para pagamentos efetuados após a data de
	 * vencimento
	 */
	@JsonProperty("late_payment_fine")
	private Double latePaymentFine;

	/**
	 * Booleano que determina se cobra ou não juros por dia de atraso. 1% ao mês
	 * pro rata.
	 */
	@JsonProperty("per_day_interest")
	private Double perDayInterest;

	/**
	 * Valor dos Descontos em centavos
	 */
	@JsonProperty("discount_cents")
	private Integer discountCents;

	@JsonProperty("payable_with")
	private PayableWith payableWith;

	@JsonProperty("ignore_canceled_email")
	private boolean ignoreCanceledEmail;

	@JsonProperty("ignore_due_email")
	private boolean ignoreDueEmail;

	private boolean currentFinesOption;

	public Invoice(String email, Date dueDate, Item... items) {
		this.email = email;
		this.dueDate = dueDate;
		this.items.addAll(Arrays.asList(items)); // FIXME Tratar null pointer
	}

	public Invoice(String id, Date dueDate, boolean ignoreCanceledEmail, boolean ignoreDueEmail,
			boolean currentFinesOption, List<Item> items) {
		this.id = id;
		this.dueDate = dueDate;
		this.ignoreCanceledEmail = ignoreCanceledEmail;
		this.ignoreDueEmail = ignoreDueEmail;
		this.currentFinesOption = currentFinesOption;
		this.items = items;

	}

	public Invoice(String email, Date dueDate, Payer Payer, Item... items) {
		this.email = email;
		this.dueDate = dueDate;
		this.payer = Payer;
		this.items.addAll(Arrays.asList(items)); // FIXME Tratar null pointer
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	@JsonProperty("ignore_canceled_email")
	public boolean isIgnoreCanceledEmail() {
		return ignoreCanceledEmail;
	}

	public void setIgnoreCanceledEmail(boolean ignoreCanceledEmail) {
		this.ignoreCanceledEmail = ignoreCanceledEmail;
	}

	@JsonProperty("ignore_due_email")
	public boolean isIgnoreDueEmail() {
		return ignoreDueEmail;
	}

	public void setIgnoreDueEmail(boolean ignoreDueEmail) {
		this.ignoreDueEmail = ignoreDueEmail;
	}

	@JsonProperty("current_fines_option")
	public boolean isCurrentFinesOption() {
		return currentFinesOption;
	}

	public void setCurrentFinesOption(boolean currentFinesOption) {
		this.currentFinesOption = currentFinesOption;
	}

	public String getEmail() {
		return email;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public List<Item> getItems() {
		return items;
	}

	public Payer getPayer() {
		return payer;
	}

	public void setPayer(Payer Payer) {
		this.payer = Payer;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public Invoice withReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
		return this;
	}

	public String getExpiredUrl() {
		return expiredUrl;
	}

	public Invoice withExpiredUrl(String expiredUrl) {
		this.expiredUrl = expiredUrl;
		return this;
	}

	public String getCustomerId() {
		return customerId;
	}

	public Invoice withCustomerId(String customerId) {
		this.customerId = customerId;
		return this;
	}

	public String getNotificationUrl() {
		return notificationUrl;
	}

	public Invoice withNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
		return this;
	}

	public Integer getTaxCents() {
		return taxCents;
	}

	public Invoice withTaxCents(Integer taxCents) {
		this.taxCents = taxCents;
		return this;
	}

	public Boolean getFines() {
		return fines;
	}

	public Invoice withFines(Boolean fines) {
		this.fines = fines;
		return this;
	}

	public Double getLatePaymentFine() {
		return latePaymentFine;
	}

	public void setLatePaymentFine(Double latePaymentFine) {
		this.latePaymentFine = latePaymentFine;
	}

	public Double getPerDayInterest() {
		return perDayInterest;
	}

	public void setPerDayInterest(Double perDayInterest) {
		this.perDayInterest = perDayInterest;
	}

	public Integer getDiscountCents() {
		return discountCents;
	}

	public void setDiscountCents(Integer discountCents) {
		this.discountCents = discountCents;
	}

	public PayableWith getPayableWith() {
		return payableWith;
	}

	public void setPayableWith(PayableWith payableWith) {
		this.payableWith = payableWith;
	}

	public String getCcEmails() {
		return ccEmails;
	}

	public Invoice withCcEmails(String ccEmails) {
		this.ccEmails = ccEmails;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccEmails == null) ? 0 : ccEmails.hashCode());
		result = prime * result + (currentFinesOption ? 1231 : 1237);
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((discountCents == null) ? 0 : discountCents.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((expiredUrl == null) ? 0 : expiredUrl.hashCode());
		result = prime * result + ((fines == null) ? 0 : fines.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (ignoreCanceledEmail ? 1231 : 1237);
		result = prime * result + (ignoreDueEmail ? 1231 : 1237);
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((latePaymentFine == null) ? 0 : latePaymentFine.hashCode());
		result = prime * result + ((notificationUrl == null) ? 0 : notificationUrl.hashCode());
		result = prime * result + ((payableWith == null) ? 0 : payableWith.hashCode());
		result = prime * result + ((payer == null) ? 0 : payer.hashCode());
		result = prime * result + ((perDayInterest == null) ? 0 : perDayInterest.hashCode());
		result = prime * result + ((returnUrl == null) ? 0 : returnUrl.hashCode());
		result = prime * result + ((taxCents == null) ? 0 : taxCents.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (ccEmails == null) {
			if (other.ccEmails != null)
				return false;
		} else if (!ccEmails.equals(other.ccEmails))
			return false;
		if (currentFinesOption != other.currentFinesOption)
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (discountCents == null) {
			if (other.discountCents != null)
				return false;
		} else if (!discountCents.equals(other.discountCents))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (expiredUrl == null) {
			if (other.expiredUrl != null)
				return false;
		} else if (!expiredUrl.equals(other.expiredUrl))
			return false;
		if (fines == null) {
			if (other.fines != null)
				return false;
		} else if (!fines.equals(other.fines))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ignoreCanceledEmail != other.ignoreCanceledEmail)
			return false;
		if (ignoreDueEmail != other.ignoreDueEmail)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (latePaymentFine == null) {
			if (other.latePaymentFine != null)
				return false;
		} else if (!latePaymentFine.equals(other.latePaymentFine))
			return false;
		if (notificationUrl == null) {
			if (other.notificationUrl != null)
				return false;
		} else if (!notificationUrl.equals(other.notificationUrl))
			return false;
		if (payableWith != other.payableWith)
			return false;
		if (payer == null) {
			if (other.payer != null)
				return false;
		} else if (!payer.equals(other.payer))
			return false;
		if (perDayInterest == null) {
			if (other.perDayInterest != null)
				return false;
		} else if (!perDayInterest.equals(other.perDayInterest))
			return false;
		if (returnUrl == null) {
			if (other.returnUrl != null)
				return false;
		} else if (!returnUrl.equals(other.returnUrl))
			return false;
		if (taxCents == null) {
			if (other.taxCents != null)
				return false;
		} else if (!taxCents.equals(other.taxCents))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", email=" + email + ", dueDate=" + dueDate + ", items=" + items + ", payer="
				+ payer + ", ccEmails=" + ccEmails + ", returnUrl=" + returnUrl + ", expiredUrl=" + expiredUrl
				+ ", customerId=" + customerId + ", notificationUrl=" + notificationUrl + ", taxCents=" + taxCents
				+ ", fines=" + fines + ", latePaymentFine=" + latePaymentFine + ", perDayInterest=" + perDayInterest
				+ ", discountCents=" + discountCents + ", payableWith=" + payableWith + ", ignoreCanceledEmail="
				+ ignoreCanceledEmail + ", ignoreDueEmail=" + ignoreDueEmail + ", currentFinesOption="
				+ currentFinesOption + "]";
	}

}