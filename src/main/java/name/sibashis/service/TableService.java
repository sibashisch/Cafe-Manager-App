package name.sibashis.service;

import java.util.List;

import name.sibashis.entity.TableEntity;

public interface TableService {
	public TableEntity getTable (int tableID);
	public void updateTableState(int tableID, String updBy);
	public void updateTableState(int tableID, int newState, String updBy);
	
	public List <TableEntity> getAllTables ();
}
