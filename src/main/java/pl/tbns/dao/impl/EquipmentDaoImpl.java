
package pl.tbns.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import pl.tbns.api.dao.AbstractGenericDao;
import pl.tbns.dao.EquipmentDao;
import pl.tbns.model.Equipment;

/**
 * @author Maciej Skowyra
 * @author Szymon Iwański
 * @date May 8, 2015 1:45:49 PM
 */
@Repository("equipmentDao")
public class EquipmentDaoImpl extends AbstractGenericDao<Equipment> implements EquipmentDao {

	/** The logger. */
    static Logger logger = Logger.getLogger(EquipmentDaoImpl.class);
}
