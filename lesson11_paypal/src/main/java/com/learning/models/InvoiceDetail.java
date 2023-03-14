package com.learning.models;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail implements Serializable{

	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "invoiceId", column = @Column(name = "invoice_id", nullable = false)),
		@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)) })
	private InvoiceDetailId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", nullable = false, insertable = false, updatable = false)
	private Invoice invoice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	private Product product;

	@Column(name = "price", nullable = false, precision = 22, scale = 0)
	private double price;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	public InvoiceDetail() {
	}

	public InvoiceDetail(InvoiceDetailId id, Invoice invoice, Product product, double price, int quantity) {
		this.id = id;
		this.invoice = invoice;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}

	public InvoiceDetailId getId() {
		return id;
	}

	public void setId(InvoiceDetailId id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
