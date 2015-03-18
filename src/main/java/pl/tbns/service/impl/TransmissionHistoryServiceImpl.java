/**
 * 
 */
package pl.tbns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.dao.MagazineDao;
import pl.tbns.dao.TransmissionHistoryDao;
import pl.tbns.model.TransmissionHistory;
import pl.tbns.service.TransmissionHistoryService;

/**
 * @author Szymon Iwański
 *
 */
@Service
@Transactional
public class TransmissionHistoryServiceImpl implements
		TransmissionHistoryService {

	@Autowired
	private TransmissionHistoryDao transmissionHistoryDao;
	@Autowired
	private EquipmentDao equipmentDao;
	@Autowired
	private MagazineDao sourceMagazineDao;
	@Autowired
	private MagazineDao destMagazineDao;
	
	
	public TransmissionHistory getTransmissionHistoryById(Long id) {
		return this.transmissionHistoryDao.get(id);
	}

	public void createTransmissionHistory(
			TransmissionHistory transmissionHistory) {
		transmissionHistoryDao.create(transmissionHistory);
	}

	public void modifyTransmissionHistory(
			TransmissionHistory transmissionHistory, Long equipmentId,
			Long sourceMagazineId, Long destMagazineId) {
		// TODO Auto-generated method stub

	}

	public void deleteTransmissionHistoryById(Long id) {
		this.transmissionHistoryDao.deleteById(id);

	}

	public TransmissionHistory findTransmissionHistoryById(Long id) {
		return this.transmissionHistoryDao.get(id);
	}

}
