package name.sibashis.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import name.sibashis.dao.RoleDao;
import name.sibashis.entity.RoleEntity;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory session;

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleEntity> getAllRoles() {
		return session.getCurrentSession().createQuery("from RoleEntity").list();
	}

}
