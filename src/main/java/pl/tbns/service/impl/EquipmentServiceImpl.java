/**
 * 
 */
package pl.tbns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.model.Equipment;
import pl.tbns.service.EquipmentService;

/**
 * @author Szymon Iwański
 *
 */
@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentDao equipmentDao;
	@Autowired
	private EquipmentsTypeDao equipmentsTypeDao;
	
	public Equipment getEquipmentById(Long id) {
		return this.equipmentDao.get(id);
	}

	public void createEquipment(Equipment equipment) {
		equipmentDao.create(equipment);
	}

	public void modifyEquipment(Equipment equipment, Long equipmentsTypeId) {
		// TODO Auto-generated method stub
	}

	public void deleteEquipmentById(Long id) {
		this.equipmentDao.deleteById(id);
	}

	public Equipment findEquipmentById(Long id) {
		return this.equipmentDao.get(id);
	}

}
