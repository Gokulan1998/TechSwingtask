package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoClass {
	@Autowired
	Repos r;
	public String add(List<EntityClass> ec) {
		r.saveAll(ec);
		return "saved";
	}
	public List<EntityClass> view() {
		return r.findAll();
	}
	public String delete(int id) {
		r.deleteById(id);
		return "deleted";
	}
	public String edit(EntityClass e) {
		r.save(e);
		return "saved";
	}
	public EntityClass getObj(int id) {
		// TODO Auto-generated method stub
		return r.findById(id).get();
	}
}
