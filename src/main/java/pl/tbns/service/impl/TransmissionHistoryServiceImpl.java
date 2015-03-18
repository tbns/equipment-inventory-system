/**
 * 
 */
package pl.tbns.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.dao.MagazineDao;
import pl.tbns.dao.TransmissionHistoryDao;
import pl.tbns.model.Equipment;
import pl.tbns.model.Magazine;
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
			TransmissionHistory transmissionHistory, Long equipmentId,
			Long sourceMagazineId, Long destMagazineId) {
		if (equipmentId != null && sourceMagazineId != null && destMagazineId != null) {
			transmissionHistoryDao.create(transmissionHistory);
		}
		else {
			Equipment equipment = new Equipment();
			Magazine sourceMagazine = new Magazine();
			Magazine destMagazine = new Magazine();
			transmissionHistory.setEquipment(equipment);
			transmissionHistory.setSourceMagazine(sourceMagazine);
			transmissionHistory.setDestMagazine(destMagazine);
			transmissionHistory.setDateCreated(new Date());
			transmissionHistoryDao.create(transmissionHistory);
		}
	}

	public void modifyTransmissionHistory(
			TransmissionHistory transmissionHistory, Long equipmentId,
			Long sourceMagazineId, Long destMagazineId) {
		if (equipmentId != null && sourceMagazineId != null && destMagazineId != null) {
			this.transmissionHistoryDao.update(transmissionHistory);
		}
		else {
			Equipment equipment = new Equipment();
			Magazine sourceMagazine = new Magazine();
			Magazine destMagazine = new Magazine();
			transmissionHistory.setEquipment(equipment);
			transmissionHistory.setSourceMagazine(sourceMagazine);
			transmissionHistory.setDestMagazine(destMagazine);
			this.transmissionHistoryDao.update(transmissionHistory);
		}

	}

	public void deleteTransmissionHistoryById(Long id) {
		this.transmissionHistoryDao.deleteById(id);

	}

	public TransmissionHistory findTransmissionHistoryById(Long id) {
		return this.transmissionHistoryDao.get(id);
	}

}
