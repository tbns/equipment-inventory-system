package pl.tbns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.dao.MagazineDao;
import pl.tbns.dao.TransmissionHistoryDao;
import pl.tbns.model.Equipment;
import pl.tbns.model.Magazine;
import pl.tbns.model.TransmissionHistory;
import pl.tbns.service.EquipmentService;
import pl.tbns.service.TransmissionHistoryService;

/**
 * @author Maciej Skowyra
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
	private EquipmentService equipmentService;
	@Autowired
	private EquipmentDao equipmentDao;
	@Autowired
	private MagazineDao magazineDao;
	
		
	public TransmissionHistory getTransmissionHistoryById(Long id) {
		return this.transmissionHistoryDao.get(id);
	}

	public void createTransmissionHistory(
			TransmissionHistory transmissionHistory, Long equipmentId,
			Long sourceMagazineId, Long destMagazineId) {
		
			Equipment equipment = equipmentDao.get(equipmentId);
		
			Magazine sourceMagazine = magazineDao.get(sourceMagazineId);
			Magazine destMagazine = magazineDao.get(destMagazineId);
					
			transmissionHistory.setEquipment(equipment);
			transmissionHistory.setSourceMagazine(sourceMagazine);
			transmissionHistory.setDestMagazine(destMagazine);
			
			transmissionHistoryDao.create(transmissionHistory);
	}

	public void changeStatusTransmissionHistory(Long id, boolean status) {
			TransmissionHistory transmissionHistory = transmissionHistoryDao.get(id);
			
			if(status == true){
					Long destMagazine = transmissionHistory.getDestMagazine().getId();
					Equipment equipment = transmissionHistory.getEquipment();
							
					equipmentService.modifyForHistoryTransmissionEquipment(equipment, destMagazine);
					transmissionHistoryDao.update(transmissionHistory);
			}
		
	}
		
	public void modifyTransmissionHistory(TransmissionHistory transmissionHistory, Long equipmentId,
			Long sourceMagazineId, Long destMagazineId) {

	}

	public void deleteTransmissionHistoryById(Long id) {
		this.transmissionHistoryDao.deleteById(id);

	}

	public TransmissionHistory findTransmissionHistoryById(Long id) {
		return this.transmissionHistoryDao.get(id);
	}

	

	

}
