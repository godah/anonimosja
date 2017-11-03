package com.anonimosja.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.anonimosja.dao.DaoImplementacao;
import com.anonimosja.dao.DaoInterface;
import com.anonimosja.model.Freelancer;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/freelancer")
public class FreelancerController extends DaoImplementacao<Freelancer>
		implements DaoInterface<Freelancer> {
	
	public FreelancerController(Class<Freelancer> persistenceClass) {
		super(persistenceClass);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonPost)
			throws Exception{
		Freelancer objeto = new Gson().fromJson(jsonPost,
				Freelancer.class);
		System.out.println(jsonPost);
		
		String sql = "SELECT * FROM freelancer where login = '"+objeto.getLogin()+"'";
		@SuppressWarnings("unchecked")
		List<Freelancer> results = this.sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity("freelancer", Freelancer.class).list();
		System.out.println("/freelancer/post");
		for (Object item : results) {
			System.out.println(item.toString());
		}
		
		if(results.isEmpty()){
			super.salvar(objeto);
			return new ResponseEntity(HttpStatus.CREATED);
		}else{
			super.atualizar(objeto);
			return new ResponseEntity(HttpStatus.CREATED);
		}		
		
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "put", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity atualizar(@RequestBody String jsonPut)
			throws Exception{
		Freelancer objeto = new Gson().fromJson(jsonPut, Freelancer.class);
		System.out.println("/freelancer/put "+jsonPut);
		super.atualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/postorput", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvarOuAtualizar(@RequestBody String jsonPost)
			throws Exception{
		Freelancer objeto = new Gson().fromJson(jsonPost,
				Freelancer.class);
		System.out.println("/freelancer/postorput "+jsonPost);
		super.salvarOuAtualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String listartodos()
			throws Exception {
		String json = new Gson().toJson(super.lista());
		System.out.println("/freelancer/list "+json);
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "list/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String buscar(@PathVariable("id") String id)
			throws Exception {
		Freelancer objeto = super.loadObjeto(Long.parseLong(id));
		if (objeto == null) {
			return "{}";
		}
		String json = new Gson().toJson(objeto); 
		System.out.println("/freelancer/list/{"+id+"} "+json);
		return json;
	}
	
	@CrossOrigin
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deletar(@PathVariable("id") String id)
			throws Exception {
		System.out.println("/freelancer/delete/{"+id+"} "+super.loadObjeto(Long.parseLong(id)).toString());
		super.deletar(super.loadObjeto(Long.parseLong(id)));
		return "";
	}

}









