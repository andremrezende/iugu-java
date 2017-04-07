package com.iugu.responses;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.iugu.serializers.DateSerializer;
import com.iugu.serializers.JsonFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceResponse implements Serializable {

	private static final long serialVersionUID = -4229186497940178039L;

	private String id;

	@JsonProperty("due_date")
	@JsonFormat("yyyy-MM-dd")
	@JsonSerialize(using = DateSerializer.class)
	private String dueDate;

	private String currency;

	@JsonProperty("discount_cents")
	private Integer discountCents;

	private String email;

	@JsonProperty("items_total_cents")
	private Integer itemsTotalCents;

	@JsonProperty("notification_url")
	private String notificationUrl;

	@JsonProperty("return_url")
	private String returnUrl;

	private String status;

	@JsonProperty("tax_cents")
	private Integer taxCents;

	@JsonProperty("updated_at")
	@JsonFormat("yyyy-MM-dd'T'HH:mm:ssZ")
	@JsonSerialize(using = DateSerializer.class)
	private Date updatedAt;

	@JsonProperty("total_cents")
	private Integer totalCents;

	@JsonProperty("paid_at")
	private Date paidAt;

	@JsonProperty("secure_id")
	private String secureId;

	@JsonProperty("secure_url")
	private String secureUrl;

	@JsonProperty("customer_id")
	private String customerId;

	@JsonProperty("user_id")
	private Long userId;

	@JsonProperty("total")
	private String total;

	@JsonProperty("total_paid")
	private String totalPaid;

	@JsonProperty("total_on_occurrence_day")
	private String totalOnOccurrenceDay;

	@JsonProperty("taxes_paid")
	private String taxesPaid;

	private String interest;

	private String discount;

	private Boolean refundable;

	private String installments;

	@JsonProperty("bank_slip")
	private BankSlipResponse bankSlip;

	private List<ItemResponse> items;

	private List<VariableResponse> variables;

	private List<LogResponse> logs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getDiscountCents() {
		return discountCents;
	}

	public void setDiscountCents(Integer discountCents) {
		this.discountCents = discountCents;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getItemsTotalCents() {
		return itemsTotalCents;
	}

	public void setItemsTotalCents(Integer itemsTotalCents) {
		this.itemsTotalCents = itemsTotalCents;
	}

	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTaxCents() {
		return taxCents;
	}

	public void setTaxCents(Integer taxCents) {
		this.taxCents = taxCents;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getTotalCents() {
		return totalCents;
	}

	public void setTotalCents(Integer totalCents) {
		this.totalCents = totalCents;
	}

	public Date getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	public String getSecureId() {
		return secureId;
	}

	public void setSecureId(String secureId) {
		this.secureId = secureId;
	}

	public String getSecureUrl() {
		return secureUrl;
	}

	public void setSecureUrl(String secureUrl) {
		this.secureUrl = secureUrl;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTaxesPaid() {
		return taxesPaid;
	}

	public void setTaxesPaid(String taxesPaid) {
		this.taxesPaid = taxesPaid;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Boolean getRefundable() {
		return refundable;
	}

	public void setRefundable(Boolean refundable) {
		this.refundable = refundable;
	}

	public String getInstallments() {
		return installments;
	}

	public void setInstallments(String installments) {
		this.installments = installments;
	}

	public BankSlipResponse getBankSlip() {
		return bankSlip;
	}

	public void setBankSlip(BankSlipResponse bankSlip) {
		this.bankSlip = bankSlip;
	}

	public List<ItemResponse> getItems() {
		return items;
	}

	public void setItems(List<ItemResponse> items) {
		this.items = items;
	}

	public List<VariableResponse> getVariables() {
		return variables;
	}

	public void setVariables(List<VariableResponse> variables) {
		this.variables = variables;
	}

	public List<LogResponse> getLogs() {
		return logs;
	}

	public void setLogs(List<LogResponse> logs) {
		this.logs = logs;
	}

	public String getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}

	public String getTotalOnOccurrenceDay() {
		return totalOnOccurrenceDay;
	}

	public void setTotalOnOccurrenceDay(String totalOnOccurrenceDay) {
		this.totalOnOccurrenceDay = totalOnOccurrenceDay;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankSlip == null) ? 0 : bankSlip.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((discountCents == null) ? 0 : discountCents.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((installments == null) ? 0 : installments.hashCode());
		result = prime * result + ((interest == null) ? 0 : interest.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((itemsTotalCents == null) ? 0 : itemsTotalCents.hashCode());
		result = prime * result + ((logs == null) ? 0 : logs.hashCode());
		result = prime * result + ((notificationUrl == null) ? 0 : notificationUrl.hashCode());
		result = prime * result + ((paidAt == null) ? 0 : paidAt.hashCode());
		result = prime * result + ((refundable == null) ? 0 : refundable.hashCode());
		result = prime * result + ((returnUrl == null) ? 0 : returnUrl.hashCode());
		result = prime * result + ((secureId == null) ? 0 : secureId.hashCode());
		result = prime * result + ((secureUrl == null) ? 0 : secureUrl.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((taxCents == null) ? 0 : taxCents.hashCode());
		result = prime * result + ((taxesPaid == null) ? 0 : taxesPaid.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((totalCents == null) ? 0 : totalCents.hashCode());
		result = prime * result + ((totalOnOccurrenceDay == null) ? 0 : totalOnOccurrenceDay.hashCode());
		result = prime * result + ((totalPaid == null) ? 0 : totalPaid.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((variables == null) ? 0 : variables.hashCode());
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
		InvoiceResponse other = (InvoiceResponse) obj;
		if (bankSlip == null) {
			if (other.bankSlip != null)
				return false;
		} else if (!bankSlip.equals(other.bankSlip))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (installments == null) {
			if (other.installments != null)
				return false;
		} else if (!installments.equals(other.installments))
			return false;
		if (interest == null) {
			if (other.interest != null)
				return false;
		} else if (!interest.equals(other.interest))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (itemsTotalCents == null) {
			if (other.itemsTotalCents != null)
				return false;
		} else if (!itemsTotalCents.equals(other.itemsTotalCents))
			return false;
		if (logs == null) {
			if (other.logs != null)
				return false;
		} else if (!logs.equals(other.logs))
			return false;
		if (notificationUrl == null) {
			if (other.notificationUrl != null)
				return false;
		} else if (!notificationUrl.equals(other.notificationUrl))
			return false;
		if (paidAt == null) {
			if (other.paidAt != null)
				return false;
		} else if (!paidAt.equals(other.paidAt))
			return false;
		if (refundable == null) {
			if (other.refundable != null)
				return false;
		} else if (!refundable.equals(other.refundable))
			return false;
		if (returnUrl == null) {
			if (other.returnUrl != null)
				return false;
		} else if (!returnUrl.equals(other.returnUrl))
			return false;
		if (secureId == null) {
			if (other.secureId != null)
				return false;
		} else if (!secureId.equals(other.secureId))
			return false;
		if (secureUrl == null) {
			if (other.secureUrl != null)
				return false;
		} else if (!secureUrl.equals(other.secureUrl))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (taxCents == null) {
			if (other.taxCents != null)
				return false;
		} else if (!taxCents.equals(other.taxCents))
			return false;
		if (taxesPaid == null) {
			if (other.taxesPaid != null)
				return false;
		} else if (!taxesPaid.equals(other.taxesPaid))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (totalCents == null) {
			if (other.totalCents != null)
				return false;
		} else if (!totalCents.equals(other.totalCents))
			return false;
		if (totalOnOccurrenceDay == null) {
			if (other.totalOnOccurrenceDay != null)
				return false;
		} else if (!totalOnOccurrenceDay.equals(other.totalOnOccurrenceDay))
			return false;
		if (totalPaid == null) {
			if (other.totalPaid != null)
				return false;
		} else if (!totalPaid.equals(other.totalPaid))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (variables == null) {
			if (other.variables != null)
				return false;
		} else if (!variables.equals(other.variables))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceResponse [id=" + id + ", dueDate=" + dueDate + ", currency=" + currency + ", discountCents="
				+ discountCents + ", email=" + email + ", itemsTotalCents=" + itemsTotalCents + ", notificationUrl="
				+ notificationUrl + ", returnUrl=" + returnUrl + ", status=" + status + ", taxCents=" + taxCents
				+ ", updatedAt=" + updatedAt + ", totalCents=" + totalCents + ", paidAt=" + paidAt + ", secureId="
				+ secureId + ", secureUrl=" + secureUrl + ", customerId=" + customerId + ", userId=" + userId
				+ ", total=" + total + ", totalPaid=" + totalPaid + ", totalOnOccurrenceDay=" + totalOnOccurrenceDay
				+ ", taxesPaid=" + taxesPaid + ", interest=" + interest + ", discount=" + discount + ", refundable="
				+ refundable + ", installments=" + installments + ", bankSlip=" + bankSlip + ", items=" + items
				+ ", variables=" + variables + ", logs=" + logs + "]";
	}

}