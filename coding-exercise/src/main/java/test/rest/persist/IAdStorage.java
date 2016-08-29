package test.rest.persist;

import java.util.List;

import test.rest.model.Ad;


/**
 * The storage serviec
 * @author Mahesh
 *
 */
public interface IAdStorage {

	public void store(Ad ad);
	
	public Ad getAd(String partner_id);

	List<Ad> getAllAds();
}
