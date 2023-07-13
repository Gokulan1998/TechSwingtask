package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ServiceClass {
	@Autowired
	DaoClass d;
	public String add(List<EntityClass> ec) {
		return d.add(ec);
	}
	public List<EntityClass> view() {
		return d.view();
	}
	public String delete(int id) {
		return d.delete(id);
	}
	public String edit(EntityClass e) {
		return d.edit(e);
	}
	public EntityClass getObj(int id) {
		// TODO Auto-generated method stub
		return d.getObj(id);
	}
}
