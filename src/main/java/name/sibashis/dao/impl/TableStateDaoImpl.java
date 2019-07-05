package name.sibashis.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import name.sibashis.dao.TableStateDao;
import name.sibashis.entity.TableStateEntity;

@Repository
public class TableStateDaoImpl implements TableStateDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public TableStateEntity getTableState(int stateID) {
		return (TableStateEntity)session.getCurrentSession().get(TableStateEntity.class, stateID);
	}

}
