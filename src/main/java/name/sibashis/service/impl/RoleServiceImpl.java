package name.sibashis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import name.sibashis.dao.RoleDao;
import name.sibashis.entity.RoleEntity;
import name.sibashis.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Transactional
	public List<RoleEntity> getAllRoles() {
		return roleDao.getAllRoles();
	}

}
