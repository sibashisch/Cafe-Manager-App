package name.sibashis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import name.sibashis.dao.TableStateDao;
import name.sibashis.entity.TableStateEntity;
import name.sibashis.service.TableStateService;

@Service
public class TableStateServiceImpl implements TableStateService {
	
	@Autowired
	private TableStateDao tableStateDao;

	@Transactional
	public TableStateEntity getTableState(int stateID) {
		return tableStateDao.getTableState(stateID);
	}

}
