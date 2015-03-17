package pl.tbns.test.service;
import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.model.EquipmentsType;
import pl.tbns.service.EquipmentsTypeService;

/**
 * @author Szymon Iwański
 * @author Maciej Skowyra
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/application-context-test.xml", "/spring/hibernate-context-test.xml" })
public class EquipmentsTypeServiceTest extends TestCase{

	@Autowired
	private EquipmentsTypeService equipmentsTypeService;
	@Autowired
	private EquipmentsTypeDao equipmentsTypeDao;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testCreateEquipmentsType() {
		EquipmentsType equipmentsType = new EquipmentsType();
		equipmentsType.setName("Basic equipments type");
		
		equipmentsTypeService.createEquipmentType(equipmentsType);
		
		Assert.assertNotNull("No equipments type added", equipmentsTypeService.findById(equipmentsType.getId()));
	}
	
	@Test
	@Transactional
	public void testDeleteEquipmentsType() {
		EquipmentsType equipmentsType = new EquipmentsType();
		equipmentsType.setName("Basic equipments type for delete");
		
		equipmentsTypeService.createEquipmentType(equipmentsType);
		equipmentsTypeService.deleteEqiupmentTypeById(equipmentsTypeDao.getAll().get(0).getId());
		
		Assert.assertNull("Error! No delete equipments type", equipmentsTypeService.findById(equipmentsType.getId()));
	}
}
