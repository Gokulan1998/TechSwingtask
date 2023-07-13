package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {
	@Autowired
	ServiceClass s;
	@PostMapping(value = "add")
	public String add(@RequestBody List<EntityClass> ec) {
		return s.add(ec);
	}
		@GetMapping(value="view")
		public List<EntityClass> view() {
			return s.view();
		}
	
	@GetMapping("/get/{id}")
	public EntityClass getObj(@PathVariable("id") int id) {
		return s.getObj(id);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public String delete(@PathVariable int id) {
		return s.delete(id);
	}
	@PatchMapping(value = "edit")
	public String edit(@RequestBody EntityClass e) {
		return s.edit(e);
	}
}
