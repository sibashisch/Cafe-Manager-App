package name.sibashis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import name.sibashis.entity.UserEntity;
import name.sibashis.service.RoleService;
import name.sibashis.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/userlist")
	public String setupView (Map<String, Object> map) {
		UserEntity userEntity = new UserEntity();
		map.put("user", userEntity);
		map.put("userList", userService.getAllUsers());
		map.put("roleList", roleService.getAllRoles());
		return "userview";
	}
	
	@RequestMapping(value="/user.do", method=RequestMethod.POST)
	public String doAction (@ModelAttribute UserEntity userEntity, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map) {
		UserEntity userResult = new UserEntity ();
		switch (action.toLowerCase()) {
			case "add":
				userEntity.setCrtBy("WEB-ADD");
				userEntity.setUserPass(userEntity.getUserName());
				userService.addUser(userEntity);
				userResult = userEntity;
				break;
			case "edit":
				UserEntity editedUser = userService.getUser(userEntity.getUserID());
				userEntity.setUserPass(editedUser.getUserPass());
				userEntity.setCrtBy(editedUser.getCrtBy());
				userEntity.setUpdBy("WEB-EDIT");
				userService.editUser(userEntity);
				userResult = userEntity;
				break;
			case "delete":
				userService.deleteUser(userEntity.getUserID());
				userResult = new UserEntity ();
				break;
			case "search":
				UserEntity searchedUser = userService.getUser(userEntity.getUserID());
				userResult = searchedUser != null ? searchedUser : new UserEntity ();
				break;
		}
		map.put("user", userResult);
		map.put("userList", userService.getAllUsers());
		map.put("roleList", roleService.getAllRoles());
		return "userview";
	}
}
