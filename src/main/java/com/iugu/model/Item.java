package com.iugu.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class Item {

	private String id;

	private String description;

	private Integer quantity;

	private boolean _destroy;

	
	private Integer priceCents;

	public Item(String description, Integer quantity, Integer priceCents) {
		this.description = description;
		this.quantity = quantity;
		this.priceCents = priceCents;
	}
	
	public Item(String id, String description, Integer quantity, Integer priceCents, boolean _destroy) {
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.priceCents = priceCents;
		this._destroy= _destroy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("price_cents")
	public Integer getPriceCents() {
		return priceCents;
	}

	public void setPrice_cents(Integer priceCents) {
		this.priceCents = priceCents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean is_destroy() {
		return _destroy;
	}

	public void set_destroy(boolean _destroy) {
		this._destroy = _destroy;
	}

	public void setPriceCents(Integer priceCents) {
		this.priceCents = priceCents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (_destroy ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((priceCents == null) ? 0 : priceCents.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Item other = (Item) obj;
		if (_destroy != other._destroy)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (priceCents == null) {
			if (other.priceCents != null)
				return false;
		} else if (!priceCents.equals(other.priceCents))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", description=" + description + ", quantity=" + quantity + ", _destroy=" + _destroy
				+ ", priceCents=" + priceCents + "]";
	}

}
