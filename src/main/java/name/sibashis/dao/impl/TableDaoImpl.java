package name.sibashis.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import name.sibashis.dao.TableDao;
import name.sibashis.entity.TableEntity;
import name.sibashis.service.TableStateService;

@Repository
public class TableDaoImpl implements TableDao {
	
	@Autowired
	private SessionFactory session;
	@Autowired
	private TableStateService tableStateService;
	
	@Override
	public TableEntity getTable(int tableID) {
		return (TableEntity)session.getCurrentSession().get(TableEntity.class, tableID);
	}

	@Override
	public void updateTableState(int tableID, String updBy) {
		TableEntity editedTable = getTable (tableID);
		editedTable.setTableStateEntity(tableStateService.getTableState(editedTable.getTableStateEntity().getNextState()));
		editedTable.setUpdBy(updBy);
		editedTable.setUpdDt(new Date());
		session.getCurrentSession().update(editedTable);
	}
	
	@Override
	public void updateTableState(int tableID, int newState, String updBy) {
		TableEntity editedTable = getTable (tableID);
		editedTable.setTableStateEntity(tableStateService.getTableState(newState));
		editedTable.setUpdBy(updBy);
		editedTable.setUpdDt(new Date());
		session.getCurrentSession().update(editedTable);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TableEntity> getAllTables() {
		return session.getCurrentSession().createQuery("from TableEntity").list();
	}

}
