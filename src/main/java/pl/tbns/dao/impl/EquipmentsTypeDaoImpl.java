/**
 * 
 */
package pl.tbns.dao.impl;

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

}
