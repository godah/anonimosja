package com.anonimosja.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anonimosja.dao.DaoImplementacao;
import com.anonimosja.dao.DaoInterface;
import com.anonimosja.model.TipoPessoa;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/tipopessoa")
public class TipoPessoaController extends DaoImplementacao<TipoPessoa>
		implements DaoInterface<TipoPessoa> {
	
	public TipoPessoaController(Class<TipoPessoa> persistenceClass) {
		super(persistenceClass);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonPost)
			throws Exception{
		TipoPessoa objeto = new Gson().fromJson(jsonPost,
				TipoPessoa.class);
		System.out.println(jsonPost);
		super.salvar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "put", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity atualizar(@RequestBody String jsonPut)
			throws Exception{
		TipoPessoa objeto = new Gson().fromJson(jsonPut, TipoPessoa.class);
		System.out.println(jsonPut);
		super.atualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "postorput", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvarOuAtualizar(@RequestBody String jsonPost)
			throws Exception{
		TipoPessoa objeto = new Gson().fromJson(jsonPost,
				TipoPessoa.class);
		
		System.out.println(jsonPost);
		super.salvarOuAtualizar(objeto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String listartodos()
			throws Exception {
		String json = new Gson().toJson(super.lista());
		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "list/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String buscarTipoPessoa(@PathVariable("id") String id)
			throws Exception {
		TipoPessoa objeto = super.loadObjeto(Long.parseLong(id));
		if (objeto == null) {
			return "{}";
		}
		String json = new Gson().toJson(objeto); 
		System.out.println(json);
		return json;
	}
	
	
	@RequestMapping(value = "delete/{idTipoPessoa}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deletar(@PathVariable("idTipoPessoa") String idTipoPessoa)
			throws Exception {
		super.deletar(loadObjeto(Long.parseLong(idTipoPessoa)));
		return "";
	}

}









