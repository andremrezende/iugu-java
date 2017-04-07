package com.iugu.model;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.iugu.enums.PayableWith;

public class Subscription {

	public Subscription(String customerId) {
		this.customerId = customerId;

	}

	@JsonProperty("customer_id")
	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	@JsonProperty("plan_identifier")
	public String planIdentifier;

	@JsonProperty("expires_at")
	public Date expiresAt;

	@JsonProperty("only_on_charge_sucess")
	public String onlyOnChargeSucess;

	@JsonProperty("payable_with")
	public PayableWith payableWith;

	@JsonProperty("credits_based")
	public boolean creditsBased;

	@JsonProperty("price_cents")
	public int priceCents;

	@JsonProperty("credits_cycle")
	public int creditsCycle;

	@JsonProperty("credits_min")
	public int creditsMin;

	@JsonProperty("custom_variables")
	public List<CustomVariable> customVariables;

	@JsonProperty("subitems")
	public List<SubItem> subItems;

	@JsonProperty("suspended")
	private boolean suspended;

	@JsonProperty("skip_charge")
	private boolean skip_charge;

	public String getPlanIdentifier() {
		return planIdentifier;
	}

	public void setPlanIdentifier(String planIdentifier) {
		this.planIdentifier = planIdentifier;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public String getOnlyOnChargeSucess() {
		return onlyOnChargeSucess;
	}

	public void setOnlyOnChargeSucess(String onlyOnChargeSucess) {
		this.onlyOnChargeSucess = onlyOnChargeSucess;
	}

	public PayableWith getPayableWith() {
		return payableWith;
	}

	public void setPayableWith(PayableWith payableWith) {
		this.payableWith = payableWith;
	}

	public boolean isCreditsBased() {
		return creditsBased;
	}

	public void setCreditsBased(boolean creditsBased) {
		this.creditsBased = creditsBased;
	}

	public int getPriceCents() {
		return priceCents;
	}

	public void setPriceCents(int priceCents) {
		this.priceCents = priceCents;
	}

	public int getCreditsCycle() {
		return creditsCycle;
	}

	public void setCreditsCycle(int creditsCycle) {
		this.creditsCycle = creditsCycle;
	}

	public int getCreditsMin() {
		return creditsMin;
	}

	public void setCreditsMin(int creditsMin) {
		this.creditsMin = creditsMin;
	}

	public List<CustomVariable> getCustomVariables() {
		return customVariables;
	}

	public void setCustomVariables(List<CustomVariable> customVariables) {
		this.customVariables = customVariables;
	}

	public List<SubItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<SubItem> subItems) {
		this.subItems = subItems;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public boolean isSkip_charge() {
		return skip_charge;
	}

	public void setSkip_charge(boolean skip_charge) {
		this.skip_charge = skip_charge;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (creditsBased ? 1231 : 1237);
		result = prime * result + creditsCycle;
		result = prime * result + creditsMin;
		result = prime * result + ((customVariables == null) ? 0 : customVariables.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((expiresAt == null) ? 0 : expiresAt.hashCode());
		result = prime * result + ((onlyOnChargeSucess == null) ? 0 : onlyOnChargeSucess.hashCode());
		result = prime * result + ((payableWith == null) ? 0 : payableWith.hashCode());
		result = prime * result + ((planIdentifier == null) ? 0 : planIdentifier.hashCode());
		result = prime * result + priceCents;
		result = prime * result + (skip_charge ? 1231 : 1237);
		result = prime * result + ((subItems == null) ? 0 : subItems.hashCode());
		result = prime * result + (suspended ? 1231 : 1237);
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
		Subscription other = (Subscription) obj;
		if (creditsBased != other.creditsBased)
			return false;
		if (creditsCycle != other.creditsCycle)
			return false;
		if (creditsMin != other.creditsMin)
			return false;
		if (customVariables == null) {
			if (other.customVariables != null)
				return false;
		} else if (!customVariables.equals(other.customVariables))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (expiresAt == null) {
			if (other.expiresAt != null)
				return false;
		} else if (!expiresAt.equals(other.expiresAt))
			return false;
		if (onlyOnChargeSucess == null) {
			if (other.onlyOnChargeSucess != null)
				return false;
		} else if (!onlyOnChargeSucess.equals(other.onlyOnChargeSucess))
			return false;
		if (payableWith != other.payableWith)
			return false;
		if (planIdentifier == null) {
			if (other.planIdentifier != null)
				return false;
		} else if (!planIdentifier.equals(other.planIdentifier))
			return false;
		if (priceCents != other.priceCents)
			return false;
		if (skip_charge != other.skip_charge)
			return false;
		if (subItems == null) {
			if (other.subItems != null)
				return false;
		} else if (!subItems.equals(other.subItems))
			return false;
		if (suspended != other.suspended)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscription [customerId=" + customerId + ", planIdentifier=" + planIdentifier + ", expiresAt="
				+ expiresAt + ", onlyOnChargeSucess=" + onlyOnChargeSucess + ", payableWith=" + payableWith
				+ ", creditsBased=" + creditsBased + ", priceCents=" + priceCents + ", creditsCycle=" + creditsCycle
				+ ", creditsMin=" + creditsMin + ", customVariables=" + customVariables + ", subItems=" + subItems
				+ ", suspended=" + suspended + ", skip_charge=" + skip_charge + "]";
	}

}
