package acme.features.administrator.advertisement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorAdvertisementCreateService implements AbstractCreateService<Administrator, Advertisement>{

	// Internal state ------------------------------------------------------------------
	@Autowired
	AdministratorAdvertisementRepository repository;
	
	@Override
	public boolean authorise(Request<Advertisement> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(Request<Advertisement> request, Advertisement entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
		
	}

	@Override
	public void unbind(Request<Advertisement> request, Advertisement entity, Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title", "picture", "displayPeriod","creationMoment", "text", "discounts");
		
	}

	@Override
	public Advertisement instantiate(Request<Advertisement> request) {
		Advertisement result = new Advertisement();
		Date moment = new Date(System.currentTimeMillis() - 1);
		result.setCreationMoment(moment);
		return result;
	}

	@Override
	public void validate(Request<Advertisement> request, Advertisement entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void create(Request<Advertisement> request, Advertisement entity) {
		assert request != null;
		assert entity != null;

		Date moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);

		this.repository.save(entity);
		
	}

}
