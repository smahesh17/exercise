package test.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import test.rest.model.Ad;
import test.rest.persist.IAdStorage;

/**
 * 
 * @author Mahesh
 *
 */
@RestController
public class AdController {

	IAdStorage adStorage;

	@Inject
	public AdController(IAdStorage adStorage) {
		this.adStorage = adStorage;
	}

	@RequestMapping(value = "/ad", method = RequestMethod.POST , consumes =  MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String postAd(@RequestBody Ad ad) {
		adStorage.store(ad);
		return "SUCCESS";
	}

	@RequestMapping(value = "/ad/{partner_id}", method = RequestMethod.GET)
	public Ad getAd(@PathVariable("partner_id") String partner_id) {
		Ad ad = adStorage.getAd(partner_id);
		return ad;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<Ad> getAllAd() {
		return adStorage.getAllAds();
	}

}
