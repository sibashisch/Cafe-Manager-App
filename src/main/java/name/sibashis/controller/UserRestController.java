package name.sibashis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import name.sibashis.entity.UserEntity;
import name.sibashis.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "text/html")
	@ResponseBody
	public String test() {
		System.out.println ("HIT");
		return "Hello!";
	}
	
	@RequestMapping(value = "/getusers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getUsers() {
		
		List<JsonObject> returnVal = new ArrayList<>();
		List<UserEntity> listOfUsers = userService.getAllUsers();
		System.out.println ("8 list prep: " + listOfUsers.size());
		
		for (UserEntity user: listOfUsers) {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty ("user-name", user.getUserName());
			jsonObject.addProperty ("user-role", user.getUserRole());
			returnVal.add(jsonObject);
		}
		
		return returnVal.toString();
	}
	
}
