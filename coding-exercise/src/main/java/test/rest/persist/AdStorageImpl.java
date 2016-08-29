package test.rest.persist;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import test.rest.model.Ad;

/**
 * AdStorage abstraction for DB interaction
 * 
 * @author Mahesh
 *
 */

@Service
@Validated
public class AdStorageImpl implements IAdStorage {

	private AdRepository adRepository;

	@Inject
	public AdStorageImpl(AdRepository adRepository) {
		this.adRepository = adRepository;
	}

	public List<Ad> getAllAds(){
		return adRepository.findAll();
	}
	
	public void store(Ad ad) {

		String intern = ad.getPartner_id().intern();

		Ad oldAd = adRepository.findOne(ad.getPartner_id());

		// Double Idiom check
		if (oldAd != null) {
			throw new IllegalArgumentException("ERROR: The partner_is is already added for duration = "+ oldAd.getDuration());
		}
		
		synchronized (intern) {

			oldAd = adRepository.findOne(ad.getPartner_id());

			// Double Idiom check
			if (oldAd != null) {
				throw new IllegalArgumentException("ERROR: The partner_is is already added for duration = "+ oldAd.getDuration());
			}

			adRepository.saveAndFlush(ad);
		}
	}

	public Ad getAd(String partner_id) {

		Ad oldAd = adRepository.findOne(partner_id);

		return oldAd;
	}
}
