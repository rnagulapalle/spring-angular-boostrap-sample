package com.eoutletz.domain.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eoutletz.domain.Partner;
import com.eoutletz.repository.PartnerRepository;

public class BeforeCreatePartnerValidator implements Validator {

	private PartnerRepository partnerRepository;
	
	public BeforeCreatePartnerValidator(final PartnerRepository partnerRepository) {
		this.partnerRepository = partnerRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Partner.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg, Errors errors) {
		Partner partner = (Partner) arg;
		int count = partnerRepository.getPartnerCountWithEmail(partner.getEmail());
	
		if(count > 0) 
		{
			errors.rejectValue("email", null, "The partner already exists with email " + partner.getEmail());
		}
	}

}
