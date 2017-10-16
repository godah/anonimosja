package curso.angular.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import curso.angular.dao.DaoImplementacao;
import curso.angular.dao.DaoInterface;
import curso.angular.model.Pessoa;

@Controller
@RequestMapping(value = "/pessoa")
public class PessoaController extends DaoImplementacao<Pessoa>
		implements DaoInterface<Pessoa> {
	
	public PessoaController(Class<Pessoa> persistenceClass) {
		super(persistenceClass);
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonPessoa)
			throws Exception{
		Pessoa pessoa = new Gson().fromJson(jsonPessoa,
				Pessoa.class);
		System.out.println(jsonPessoa);
		super.salvarOuAtualizar(pessoa);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "listartodos", method = RequestMethod.GET)
	@ResponseBody
	public String listartodos()
			throws Exception {
		String json = new Gson().toJson(super.lista());
		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "deletar/{idPessoa}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deletar(@PathVariable("idPessoa") String idPessoa)
			throws Exception {
		super.deletar(loadObjeto(Long.parseLong(idPessoa)));
		return "";
	}
	
	@RequestMapping(value = "listar/{idPessoa}", method = RequestMethod.GET)
	public @ResponseBody
	String buscarFornecedor(@PathVariable("idPessoa") String idPessoa)
			throws Exception {
		Pessoa objeto = super.loadObjeto(Long.parseLong(idPessoa));
		if (objeto == null) {
			return "{}";
		}
		String json = new Gson().toJson(objeto); 
		System.out.println(json);
		return json;
	}

	

}









