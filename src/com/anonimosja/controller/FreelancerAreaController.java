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
import com.anonimosja.model.Freelancer;
import com.anonimosja.model.FreelancerArea;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/freelancerarea")
public class FreelancerAreaController extends DaoImplementacao<FreelancerArea>
		implements DaoInterface<FreelancerArea> {
	
	public FreelancerAreaController(Class<FreelancerArea> persistenceClass) {
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
		System.out.println("/freelancerarea/post "+jsonPost);
		
		String sql = "SELECT * FROM freelancerarea where area_id = '"+objeto.getArea().getId()+"'";// and freelancer_id = '"+objeto.getFreelancer().getId()+"'";
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
	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity atualizar(@RequestBody String jsonPut)
			throws Exception{
		FreelancerArea objeto = new Gson().fromJson(jsonPut, FreelancerArea.class);
		System.out.println("/freelancerarea/put "+jsonPut);
		super.atualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/postorput", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvarOuAtualizar(@RequestBody String jsonPost)
			throws Exception{
		FreelancerArea objeto = new Gson().fromJson(jsonPost,
				FreelancerArea.class);
		System.out.println("/freelancerarea/postorput "+jsonPost);
		super.salvarOuAtualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String listartodos()
			throws Exception {
		String json = new Gson().toJson(super.lista());
		System.out.println("/freelancerarea/list "+json);
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String buscar(@PathVariable("id") String id)
			throws Exception {
		FreelancerArea objeto = super.loadObjeto(Long.parseLong(id));
		if (objeto == null) {
			return "{}";
		}
		String json = new Gson().toJson(objeto); 
		System.out.println("/freelancerarea/list/{"+id+"} "+json);
		return json;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/list/freelancer/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String buscarPorFreelancer(@PathVariable("id") String id)
			throws Exception {
		
		String sql = "SELECT * FROM freelancerarea where freelancer_id = '"+id+"'";
		@SuppressWarnings("unchecked")
		List<Freelancer> results = this.sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity("freelancer", Freelancer.class).list();
		System.out.println("/list/freelancer/{"+id+"}");
		for (Object item : results) {
			System.out.println(item.toString());
		}
		
		if(!results.isEmpty()){
			return new Gson().toJson(results.get(0)); 			
		}else{
			return "{}";
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deletar(@PathVariable("id") String id)
			throws Exception {
		System.out.println("/freelancerarea/delete/{"+id+"} "+super.loadObjeto(Long.parseLong(id)));
		super.deletar(super.loadObjeto(Long.parseLong(id)));
		return "";
	}

}









