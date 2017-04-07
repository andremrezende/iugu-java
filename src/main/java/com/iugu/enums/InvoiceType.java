package com.iugu.enums;

import org.codehaus.jackson.annotate.JsonValue;

public enum InvoiceType {
	PENDING("pending"), DRAFT("draft"), PARTIALLY_PAID("partially_paid"), PAID("paid"), CANCELED("canceled"), REFUNDED(
			"refunded"), EXPIRED("expired");

	private String value;

	private InvoiceType(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
