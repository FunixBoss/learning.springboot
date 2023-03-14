package com.learning.services;


import com.learning.models.Invoice;

public interface InvoiceService {

	Iterable<Invoice> findAll();
	Invoice save(Invoice invoice);
}
