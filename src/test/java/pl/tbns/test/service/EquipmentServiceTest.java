
package pl.tbns.test.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.model.Equipment;
import pl.tbns.model.EquipmentsType;
import pl.tbns.service.EquipmentService;
import junit.framework.TestCase;

/**
 * @author Szymon Iwański
 * @author Maciej Skowyra
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/application-context-test.xml", "/spring/hibernate-context-test.xml" })
public class EquipmentServiceTest extends TestCase{

	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private EquipmentDao equipmentDao;
	@Autowired
	private EquipmentsTypeDao equipmentsTypeDao;
	
	@Before
	@Transactional
	public void setUp() {
		EquipmentsType equipmentsType1 = new EquipmentsType();
		equipmentsType1.setName("Basic equipments 1 type for equipments test");
		equipmentsTypeDao.create(equipmentsType1);
		
		EquipmentsType equipmentsType2 = new EquipmentsType();
		equipmentsType2.setName("Basic equipments 2 type for equipments test");
		equipmentsTypeDao.create(equipmentsType2);
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testCreateEquipment() {
		Long equipmentsTypeId = equipmentsTypeDao.getAll().get(0).getId();
		
		Equipment equipment = new Equipment();
		equipment.setName("Some equipment");
		
		equipmentService.createEquipment(equipment, equipmentsTypeId);
		
		Assert.assertNotNull("No equipment created", equipmentService.findEquipmentById(equipment.getId()));
	}
	
	
	@Test
	@Transactional
//	@Rollback(false)
	public void testUpdateEquipment() {
		Long equipmentsTypeId = equipmentsTypeDao.getAll().get(1).getId();
		
		Equipment equipment = new Equipment();
		equipment.setName("Some equipment");
		
		equipmentService.modifyEquipment(equipment, equipmentsTypeId);
		
		Assert.assertNotNull("No equipment created", equipmentService.findEquipmentById(equipment.getId()));
	}
	
//	@Ignore
	@Test
	@Transactional
	public void testDeleteEquipment() {
		Long equipmentsTypeId = equipmentsTypeDao.getAll().get(0).getId();
		
		Equipment equipment = new Equipment();
		equipment.setName("Some equipment");
		
		equipmentService.createEquipment(equipment, equipmentsTypeId);
		equipmentService.deleteEquipmentById(equipmentDao.getAll().get(0).getId());
		
		Assert.assertNull("No equipment deleted", equipmentService.findEquipmentById(equipment.getId()));
	}
}
