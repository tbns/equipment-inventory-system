/**
 * 
 */
package pl.tbns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.MagazineDao;
import pl.tbns.model.Magazine;
import pl.tbns.service.MagazineService;

/**
 * @author Szymon Iwański
 *
 */
@Service
@Transactional
public class MagazineServiceImpl implements MagazineService {

	@Autowired
	private MagazineDao magazineDao;
	
	public Magazine getMagazineByID(Long id) {
		return this.magazineDao.get(id);
	}

	public void createMagazine(Magazine magazine) {
		magazineDao.create(magazine);
	}

	public void modifyMagazine(Magazine magazine) {
		this.magazineDao.update(magazine);
	}

	public void deleteMagazineById(Long id) {
		this.magazineDao.deleteById(id);
	}

	public Magazine findMagazineById(Long id) {
		return this.magazineDao.get(id);
	}

}
