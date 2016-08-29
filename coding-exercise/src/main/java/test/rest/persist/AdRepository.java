package test.rest.persist;

import org.springframework.data.jpa.repository.JpaRepository;

import test.rest.model.Ad;

/**
 * Expecting auto initialization wiht some simpleXXJPA
 * @author Mahesh
 *
 */
public interface AdRepository extends JpaRepository<Ad, String> {

}
