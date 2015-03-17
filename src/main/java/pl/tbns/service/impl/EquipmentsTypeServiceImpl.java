/**
 * 
 */
package pl.tbns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.model.EquipmentsType;
import pl.tbns.service.EquipmentsTypeService;

/**
 * @author Szymon Iwański
 * @author Maciej Skowyra
 *
 */
@Service
@Transactional
public class EquipmentsTypeServiceImpl implements EquipmentsTypeService{

	@Autowired
	private EquipmentsTypeDao equipmentsTypeDao;
	
	public EquipmentsType getEquipmentTypeById(long id) {
		return this.equipmentsTypeDao.get(id);
	}

	public void createEquipmentType(EquipmentsType eqipmentType) {
		equipmentsTypeDao.create(eqipmentType);
	}

	public void deleteEqiupmentTypeById(Long id) {
		this.equipmentsTypeDao.deleteById(id);
	}

	public EquipmentsType findById(Long id) {
		return this.equipmentsTypeDao.get(id);
	}

	
}
