/**
 * 
 */
package pl.tbns.service;

import pl.tbns.model.EquipmentsType;

/**
 * @author Szymon Iwański
 *
 */
public interface EquipmentsTypeService {

	public EquipmentsType getEquipmentTypeById(long id);
	public void createEquipmentType(EquipmentsType eqipmentType);
	public void deleteEqiupmentTypeById(Long id);
	public EquipmentsType findById(Long id);
}
