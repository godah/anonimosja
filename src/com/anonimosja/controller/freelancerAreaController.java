package com.anonimosja.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anonimosja.dao.DaoImplementacao;
import com.anonimosja.dao.DaoInterface;
import com.anonimosja.model.FreelancerArea;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/freelancerarea")
public class freelancerAreaController extends DaoImplementacao<FreelancerArea>
		implements DaoInterface<FreelancerArea> {
	
	public freelancerAreaController(Class<FreelancerArea> persistenceClass) {
		super(persistenceClass);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonPost)
			throws Exception{
		FreelancerArea objeto = new Gson().fromJson(jsonPost,
				FreelancerArea.class);
		System.out.println(jsonPost);
		
		String sql = "SELECT * FROM freelancerarea where idarea = '"+objeto.getArea().getId()+"'";
		@SuppressWarnings("unchecked")
		List<FreelancerArea> results = this.sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity("freelancerarea", FreelancerArea.class).list();
				
		for (Object item : results) {
			System.out.println(item.toString());
		}
		
		if(results.isEmpty()){
			super.salvarOuAtualizar(objeto);
			return new ResponseEntity(HttpStatus.CREATED);
		}else{
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}		
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "put", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity atualizar(@RequestBody String jsonPut)
			throws Exception{
		FreelancerArea objeto = new Gson().fromJson(jsonPut, FreelancerArea.class);
		System.out.println(jsonPut);
		super.atualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "postorput", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvarOuAtualizar(@RequestBody String jsonPost)
			throws Exception{
		FreelancerArea objeto = new Gson().fromJson(jsonPost,
				FreelancerArea.class);
		System.out.println(jsonPost);
		super.salvarOuAtualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String listartodos()
			throws Exception {
		String json = new Gson().toJson(super.lista());
		System.out.println(json);
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "list/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String buscar(@PathVariable("id") String id)
			throws Exception {
		FreelancerArea objeto = super.loadObjeto(Long.parseLong(id));
		if (objeto == null) {
			return "{}";
		}
		String json = new Gson().toJson(objeto); 
		System.out.println(json);
		return json;
	}
	
	@CrossOrigin
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deletar(@PathVariable("id") String id)
			throws Exception {
		super.deletar(loadObjeto(Long.parseLong(id)));
		return "";
	}

}









