package com.learning.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.models.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{

}
