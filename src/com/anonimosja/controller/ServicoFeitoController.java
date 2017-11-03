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
import com.anonimosja.model.ServicoFeito;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/servicofeito")
public class ServicoFeitoController extends DaoImplementacao<ServicoFeito>
		implements DaoInterface<ServicoFeito> {
	
	public ServicoFeitoController(Class<ServicoFeito> persistenceClass) {
		super(persistenceClass);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonPost)
			throws Exception{
		ServicoFeito objeto = new Gson().fromJson(jsonPost,
				ServicoFeito.class);
		System.out.println("/servicofeito/post "+jsonPost);
		super.salvar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "put", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity atualizar(@RequestBody String jsonPut)
			throws Exception{
		ServicoFeito objeto = new Gson().fromJson(jsonPut, ServicoFeito.class);
		System.out.println("/servicofeito/put "+jsonPut);
		super.atualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "postorput", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvarOuAtualizar(@RequestBody String jsonPost)
			throws Exception{
		ServicoFeito objeto = new Gson().fromJson(jsonPost,
				ServicoFeito.class);
		System.out.println("/servicofeito/postorput "+jsonPost);
		super.salvarOuAtualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String listartodos()
			throws Exception {
		String json = new Gson().toJson(super.lista());
		System.out.println("/servicofeito/list "+json);
		return json;
	}

	@CrossOrigin
	@RequestMapping(value = "list/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String buscar(@PathVariable("id") String id)
			throws Exception {
		ServicoFeito objeto = super.loadObjeto(Long.parseLong(id));
		if (objeto == null) {
			return "{}";
		}
		String json = new Gson().toJson(objeto); 
		System.out.println("/servicofeito/list/{"+id+"}"+json);
		return json;
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/list/pessoa/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String listarPorPessoa(@PathVariable("id") String id)
			throws Exception {
		
		
		String sql = "SELECT * FROM servicofeito where freelancer_id = '"+id+"'";
		@SuppressWarnings("unchecked")
		List<ServicoFeito> results = this.sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity("servicofeito", ServicoFeito.class).list();
				
		System.out.println("/servicofeito/list/pessoa/{"+id+"}");
		for (Object item : results) {
			System.out.println(item.toString());
		}
		/*
		if(!results.isEmpty()){
			return new Gson().toJson(results); 			
		}else{
			
			ServicoFeito vazio = new ServicoFeito();
			vazio.setId(Long.parseLong("00"));
			vazio.setContratante("Vazio");
			vazio.setDescricao("Adicione um serviço!");
			Freelancer freelancer = new Freelancer();
			freelancer.setId(Long.parseLong(id));
			vazio.setFreelancer(freelancer);
			results.add(vazio);
			return new Gson().toJson(results);
			
			return new Gson().toJson(results);
		}
		*/
		return new Gson().toJson(results);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deletar(@PathVariable("id") String id)
			throws Exception {
		System.out.println("/servicofeito/delete/{"+id+"} "+super.loadObjeto(Long.parseLong(id)));
		super.deletar(super.loadObjeto(Long.parseLong(id)));
		return "";
	}

}









