/**
 * 
 */
package pl.tbns.dao.impl;

import org.springframework.stereotype.Repository;

import pl.tbns.api.dao.AbstractGenericDao;
import pl.tbns.dao.MagazineDao;
import pl.tbns.model.Magazine;

/**
 * @author Szymon Iwański
 *
 */
@Repository("magazineDao")
public class MagazineDaoImpl extends AbstractGenericDao<Magazine> implements MagazineDao {

}
