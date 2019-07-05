package name.sibashis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import name.sibashis.entity.TableEntity;
import name.sibashis.service.TableService;
import name.sibashis.service.TableStateService;

@RestController
public class TableStateController {
	
	@Autowired
	private TableService tableService;
	@Autowired
	private TableStateService tableStateService;
	
	@RequestMapping(value = "/gettables", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getTableStatus() {
		JsonObject resp = new JsonObject();
		
		try {
			List<TableEntity> tables = tableService.getAllTables();
			
			JsonArray tableJsonArray = new JsonArray ();
			for (TableEntity table: tables) {
				JsonObject tableJson = table.toJson(tableStateService);
				tableJsonArray.add (tableJson);
			}
			
			resp.add ("TABLES", tableJsonArray);
			resp.addProperty("STATUS", "SUCCESS");
		} catch (Exception ex) {
			resp.addProperty("STATUS", "ERROR");
			resp.addProperty("ERROR", ex.toString());
			
			ex.printStackTrace();
		}
		return resp.toString();
	}
	
	@RequestMapping(value = "/changestate/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String changeTableStatus (@PathVariable("id") int id) {
		JsonObject resp = new JsonObject();
		try {
			System.out.println ("1 Hey: " + id);
			tableService.updateTableState(id, "DVLP");
			resp.addProperty("STATUS", "SUCCESS");
			System.out.println ("2 Hey: " + id);
		} catch (Exception ex) {
			ex.printStackTrace();
			resp.addProperty("STATUS", "ERROR");
			resp.addProperty("ERROR", ex.toString());
		}
		return resp.toString();
	}
	
}
