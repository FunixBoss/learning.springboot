package com.learning.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.models.Invoice;
import com.learning.models.InvoiceDetail;
import com.learning.models.InvoiceDetailId;

@Repository
public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetail, InvoiceDetailId>{

}
