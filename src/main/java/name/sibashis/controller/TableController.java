package name.sibashis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import name.sibashis.entity.TableEntity;
import name.sibashis.service.TableService;

@Controller
public class TableController {

	@Autowired
	private TableService tableService;
	
	@RequestMapping ("/tables")
	public String setupView (Map<String, Object> map) {
		return "tableview";
	}
	
	@RequestMapping (value="/table.do", method=RequestMethod.POST)
	public String doAction (@ModelAttribute TableEntity tableEntity, BindingResult bindingResult, @RequestParam String action, Map<String, Object> map) {
		switch (action) {
			case "search":
				map.put("table", tableService.getTable(tableEntity.getTableID()));
				return "tableview";
			case "update":
				tableService.updateTableState(tableEntity.getTableID(), "DVLP");
				map.put("table", tableService.getTable(tableEntity.getTableID()));
				return "tableview";
			default:
				return "tableview";
		}
	}
	
	
}
