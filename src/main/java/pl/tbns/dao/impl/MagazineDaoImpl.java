
package pl.tbns.dao.impl;

import org.apache.log4j.Logger;
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

	/** The logger. */
    static Logger logger = Logger.getLogger(MagazineDaoImpl.class);
}
