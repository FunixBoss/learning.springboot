package com.learning.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@Column(name = "name", nullable = false, length = 250)
	private String name;
	
	@Column(name = "payment", nullable = false, length = 250)
	private String payment;
	
	@Column(name = "status", nullable = false, length = 250)
	private String status;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "created", nullable = false, length = 10)
	private Date created;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
	private Set<InvoiceDetail> invoiceDetails = new HashSet<>();

	public Invoice() {

	}

	public Invoice(Account account, String name, String payment, String status, Date created,
			Set<InvoiceDetail> invoiceDetails) {
		super();
		this.account = account;
		this.name = name;
		this.payment = payment;
		this.status = status;
		this.created = created;
		this.invoiceDetails = invoiceDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Set<InvoiceDetail> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(Set<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

}
