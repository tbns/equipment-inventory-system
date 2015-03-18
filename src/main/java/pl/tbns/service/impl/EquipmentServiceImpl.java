/**
 * 
 */
package pl.tbns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.model.Equipment;
import pl.tbns.model.EquipmentsType;
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

	@SuppressWarnings("unchecked")
	public void createEquipment(Equipment equipment, Long equipmentsTypeId) {
		if(equipmentsTypeId != null) {
			equipmentDao.create(equipment);
		}
		else {
			EquipmentsType equipmentsType = new EquipmentsType();
			equipment.setEquipmentsType((List<EquipmentsType>) equipmentsType);
			equipmentDao.create(equipment);
		}
	}

	@SuppressWarnings("unchecked")
	public void modifyEquipment(Equipment equipment, Long equipmentsTypeId) {
		if(equipmentsTypeId != null) {
			this.equipmentDao.update(equipment);
		}
		else {
			EquipmentsType equipmentsType = new EquipmentsType();
			equipment.setEquipmentsType((List<EquipmentsType>) equipmentsType);
			this.equipmentDao.update(equipment);
		}
	}

	public void deleteEquipmentById(Long id) {
		this.equipmentDao.deleteById(id);
	}

	public Equipment findEquipmentById(Long id) {
		return this.equipmentDao.get(id);
	}

}
