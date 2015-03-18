/**
 * 
 */
package pl.tbns.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.MagazineDao;
import pl.tbns.model.EquipmentsType;
import pl.tbns.model.Magazine;
import pl.tbns.service.MagazineService;
import junit.framework.TestCase;

/**
 * @author Szymon Iwański
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/application-context-test.xml", "/spring/hibernate-context-test.xml" })
public class MagazineServiceTest extends TestCase{

	@Autowired
	private MagazineService magazineService;
	@Autowired
	private MagazineDao magazineDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testCreateMagazine() {
		Magazine magazine = new Magazine();
		magazine.setName("Simple magazine");
		
		magazineService.createMagazine(magazine);
		
		Assert.assertNotNull("No magazine added", magazineService.findMagazineById(magazine.getId()));
	}
	
	@Test
	@Transactional
	public void testDeleteMagazine() {
		Magazine magazine = new Magazine();
		magazine.setName("Basic equipments type for delete");
		
		magazineService.createMagazine(magazine);
		magazineService.deleteMagazineById(magazineDao.getAll().get(0).getId());
		
		Assert.assertNull("Error! No magazine deleted", magazineService.findMagazineById(magazine.getId()));
	}
}
