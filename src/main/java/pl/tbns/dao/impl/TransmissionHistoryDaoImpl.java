
package pl.tbns.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import pl.tbns.api.dao.AbstractGenericDao;
import pl.tbns.dao.TransmissionHistoryDao;
import pl.tbns.model.TransmissionHistory;

/**
 * @author Szymon Iwański
 *
 */
@Repository("transmissionHistoryDao")
public class TransmissionHistoryDaoImpl extends AbstractGenericDao<TransmissionHistory> implements TransmissionHistoryDao {

	/** The logger. */
    static Logger logger = Logger.getLogger(TransmissionHistoryDaoImpl.class);
	
}
