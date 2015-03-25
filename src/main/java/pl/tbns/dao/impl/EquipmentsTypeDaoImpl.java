
package pl.tbns.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


import pl.tbns.api.dao.AbstractGenericDao;
import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.model.EquipmentsType;

/**
 * @author Szymon Iwański
 * @author Maciej Skowyra
 *
 */
@Repository("equipmentsTypeDao")
public class EquipmentsTypeDaoImpl extends AbstractGenericDao<EquipmentsType> implements EquipmentsTypeDao {

	/** The logger. */
    static Logger logger = Logger.getLogger(EquipmentsTypeDaoImpl.class);
}
