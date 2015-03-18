/**
 * 
 */
package pl.tbns.dao.impl;

import org.springframework.stereotype.Repository;

import pl.tbns.api.dao.AbstractGenericDao;
import pl.tbns.dao.EquipmentDao;
import pl.tbns.model.Equipment;

/**
 * @author Szymon Iwański
 *
 */
@Repository("equipmentDao")
public class EquipmentDaoImpl extends AbstractGenericDao<Equipment> implements EquipmentDao {

}
