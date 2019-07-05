package name.sibashis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import name.sibashis.dao.TableDao;
import name.sibashis.entity.TableEntity;
import name.sibashis.service.TableService;

@Service
public class TableServiceImpl implements TableService {
	
	@Autowired
	private TableDao tableDao;

	@Transactional
	public TableEntity getTable(int tableID) {
		return tableDao.getTable(tableID);
	}

	@Transactional
	public void updateTableState(int tableID, String updBy) {
		tableDao.updateTableState(tableID, updBy);
	}

	@Transactional
	public void updateTableState(int tableID, int newState, String updBy) {
		tableDao.updateTableState(tableID, newState, updBy);
	}

	@Transactional
	public List<TableEntity> getAllTables() {
		return tableDao.getAllTables();
	}

}
