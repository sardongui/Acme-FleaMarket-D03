package acme.features.administrator.dashboard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.advertisements.Advertisement;
import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShow implements AbstractShowService<Administrator, Dashboard>{

	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "numberNews", "numberMaterialSheets", "numberToolSheets", 
				"numberSuggestions", "numberFigments", "minDiscountAdvertisements", 
				"maxDiscountAdvertisements", "averageSmallDiscountAdvertisements", "averageAverageDiscountAdvertisements",
				"averageLargeDiscountAdvertisements","stddevSDiscountAdvertisements", "stddevADiscountAdvertisements",
				"stddevLDiscountAdvertisements");
	}


	@Override
	public Dashboard findOne(Request<Dashboard> request) {

		assert request != null;

		Dashboard res = new Dashboard();

		Integer numNews = this.repository.numberNews();
		res.setNumberNews(numNews);
		Integer numMaterialSheets = this.repository.numberMaterialSheets();
		res.setNumberMaterialSheets(numMaterialSheets);
		Integer numberToolSheets = this.repository.numberToolSheets();
		res.setNumberToolSheets(numberToolSheets);
		Integer numberSuggestions = this.repository.numberSuggestions();
		res.setNumberSuggestions(numberSuggestions);
		Integer numberFigments = this.repository.numberFigments();
		res.setNumberFigments(numberFigments);
		Double minDiscountAdvertisements = this.repository.minDiscountAdvertisements();
		res.setMinDiscountAdvertisements(minDiscountAdvertisements);
		Double maxDiscountAdvertisements = this.repository.maxDiscountAdvertisements();
		res.setMaxDiscountAdvertisements(maxDiscountAdvertisements);
		Double averageSmallDiscountAdvertisements = this.repository.averageSmallDiscountAdvertisements() / this.repository.numberAdvertisement();
		res.setAverageSmallDiscountAdvertisements(averageSmallDiscountAdvertisements);
		Double averageAverageDiscountAdvertisements = this.repository.averageAverageDiscountAdvertisements() / this.repository.numberAdvertisement();
		res.setAverageAverageDiscountAdvertisements(averageAverageDiscountAdvertisements);
		Double averageLargeDiscountAdvertisements = this.repository.averageLargeDiscountAdvertisements() / this.repository.numberAdvertisement();
		res.setAverageLargeDiscountAdvertisements(averageLargeDiscountAdvertisements);
		//STDDEV Advertisement
		Collection<Advertisement> stddevSDiscountAdvertisements = this.repository.stddevDiscountAdvertisements();
		List<Advertisement> advertisement = (List<Advertisement>) stddevSDiscountAdvertisements;
		List<Double> maxAndMinSAdv = new ArrayList<Double>();
		for (int i = 0; i < stddevSDiscountAdvertisements.size(); i++) {
			maxAndMinSAdv.add(advertisement.get(i).getItem());
			maxAndMinSAdv.add(advertisement.get(i).getItem());
		}
		Double stddevSAdv = AdministratorDashboardShow.stdev(maxAndMinSAdv, averageSmallDiscountAdvertisements);
		res.setStddevSDiscountAdvertisements(stddevSAdv);
		
		Collection<Advertisement> stddevADiscountAdvertisements = this.repository.stddevDiscountAdvertisements();
		List<Advertisement> advertisement2 = (List<Advertisement>) stddevADiscountAdvertisements;
		List<Double> maxAndMinAAdv = new ArrayList<Double>();
		for (int i = 0; i < stddevADiscountAdvertisements.size(); i++) {
			maxAndMinAAdv.add(advertisement2.get(i).getItem());
			maxAndMinAAdv.add(advertisement2.get(i).getItem());
		}
		Double stddevAAdv = AdministratorDashboardShow.stdev(maxAndMinAAdv, averageAverageDiscountAdvertisements);
		res.setStddevADiscountAdvertisements(stddevAAdv);
		
		Collection<Advertisement> stddevLDiscountAdvertisements = this.repository.stddevDiscountAdvertisements();
		List<Advertisement> advertisement3 = (List<Advertisement>) stddevLDiscountAdvertisements;
		List<Double> maxAndMinLAdv = new ArrayList<Double>();
		for (int i = 0; i < stddevLDiscountAdvertisements.size(); i++) {
			maxAndMinLAdv.add(advertisement3.get(i).getItem());
			maxAndMinLAdv.add(advertisement3.get(i).getItem());
		}
		Double stddevLAdv = AdministratorDashboardShow.stdev(maxAndMinLAdv, averageLargeDiscountAdvertisements);
		res.setStddevLDiscountAdvertisements(stddevLAdv);
		return res;
	}

	public static double stdev(final List<Double> list, final Double mean) {
		double num = 0.0;
		double numi = 0.0;
		for (Double i : list) {
			numi = Math.pow(i - mean, 2);
			num += numi;
		}
		return Math.sqrt(num / list.size());
	}

}