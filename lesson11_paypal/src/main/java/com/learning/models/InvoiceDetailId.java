package com.learning.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InvoiceDetailId implements Serializable{

	@Column(name = "invoice_id", nullable = false)
	private int invoiceId;
	
	@Column(name = "product_id", nullable = false)
	private int productId;
	
	public InvoiceDetailId() {
		
	}

	public InvoiceDetailId(int invoiceId, int productId) {
		this.invoiceId = invoiceId;
		this.productId = productId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + this.getInvoiceId();
		result = 37 * result + this.getProductId();
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if((this == other)) return true;
		if((other == null)) return false;
		if(!(other instanceof InvoiceDetailId)) return false;
		InvoiceDetailId castOther = (InvoiceDetailId) other;
		return (this.getInvoiceId() == castOther.getInvoiceId());
	}
	
	
}
