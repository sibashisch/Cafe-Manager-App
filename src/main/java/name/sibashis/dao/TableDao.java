package name.sibashis.dao;

import java.util.List;

import name.sibashis.entity.TableEntity;

public interface TableDao {
	public TableEntity getTable(int tableID);
	public void updateTableState (int tableId, String updBy);
	public void updateTableState(int tableID, int newState, String updBy);
	
	public List <TableEntity> getAllTables ();
}
