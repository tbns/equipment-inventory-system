package pl.tbns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.dao.MagazineDao;
import pl.tbns.model.Equipment;
import pl.tbns.model.EquipmentsType;
import pl.tbns.model.Magazine;
import pl.tbns.service.EquipmentService;

/**
 * @author Maciej Skowyra
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
	@Autowired
	private MagazineDao magazineDao;

	public Equipment getEquipmentById(Long id) {
		return this.equipmentDao.get(id);
	}

	public void createEquipment(Equipment equipment, Long equipmentsTypeId,
			Long magazineId) {

		EquipmentsType equipmentsType = equipmentsTypeDao.get(equipmentsTypeId);
		List<EquipmentsType> newEquipmentsTypes = new ArrayList<EquipmentsType>();

		Magazine magazine = magazineDao.get(magazineId);
		List<Magazine> newMagazine = new ArrayList<Magazine>();

		newMagazine.add(magazine);
		newEquipmentsTypes.add(equipmentsType);

		equipment.setMagazine(newMagazine);
		equipment.setEquipmentsType(newEquipmentsTypes);

		equipmentDao.create(equipment);

	}

	public void modifyEquipment(Equipment equipment, Long equipmentsTypeId,
			Long magazineId) {

		EquipmentsType equipmentsType = equipmentsTypeDao.get(equipmentsTypeId);
		List<EquipmentsType> newEquipmentsTypes = new ArrayList<EquipmentsType>();

		newEquipmentsTypes.add(equipmentsType);
		equipment.setEquipmentsType(newEquipmentsTypes);
		equipmentDao.update(equipment);
	}

	public void deleteEquipmentById(Long id) {
		this.equipmentDao.deleteById(id);
	}

	public Equipment findEquipmentById(Long id) {
		return this.equipmentDao.get(id);
	}

}
