package com.learning.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.models.Cert;
import com.learning.models.Language;
import com.learning.services.CertService;
import com.learning.services.LanguageService;

@Service
public class CertServiceImpl implements CertService{

	@Override
	public List<Cert> findAll() {
		List<Cert> certs = new ArrayList<>();
		certs.add(new Cert("cert1", "Java"));
		certs.add(new Cert("cert2", "Machine Learning"));
		certs.add(new Cert("cert3", "Deep Learning"));
		certs.add(new Cert("cert4", "Other"));

		return certs;
	}

}
