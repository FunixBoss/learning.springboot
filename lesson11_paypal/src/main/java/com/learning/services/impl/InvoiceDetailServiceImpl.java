package com.learning.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.models.InvoiceDetail;
import com.learning.repositories.InvoiceDetailRepository;
import com.learning.services.InvoiceDetailService;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService{

	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;

	@Override
	public InvoiceDetail save(InvoiceDetail invoiceDetail) {
		return invoiceDetailRepository.save(invoiceDetail);
	}
	

}
