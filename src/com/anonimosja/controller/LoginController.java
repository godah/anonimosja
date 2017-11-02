package com.anonimosja.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import com.anonimosja.dao.DaoImplementacao;
import com.anonimosja.dao.DaoInterface;
import com.anonimosja.model.Freelancer;
import com.google.gson.Gson;



@Controller
@RequestMapping(value = "/login")
public class LoginController extends DaoImplementacao<Freelancer>
		implements DaoInterface<Freelancer> {
	
	public LoginController(Class<Freelancer> persistenceClass) {
		super(persistenceClass);
	}
	
	@CrossOrigin
	@RequestMapping(value = "list/{login}:{senha}", method = RequestMethod.GET)
	public @ResponseBody
	String buscar(@PathVariable("login") String login,@PathVariable("senha") String senha)
			throws Exception {
		
		String sql = "SELECT * FROM freelancer where login = '"+login+"' and senha = '"+senha+"'";
		@SuppressWarnings("unchecked")
		List<Freelancer> results = this.sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity("freelancer", Freelancer.class).list();
		System.out.println("/login/{"+login+"}:{"+senha+"}");
		for (Object item : results) {
			System.out.println(item.toString());
		}
		
		if(!results.isEmpty()){
			return new Gson().toJson(results.get(0)); 			
		}else{
			return "{}";
		}
	}
	
	
	
}









