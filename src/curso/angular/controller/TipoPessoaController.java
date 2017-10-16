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
import curso.angular.model.TipoPessoa;

@Controller
@RequestMapping(value = "/tipopessoa")
public class TipoPessoaController extends DaoImplementacao<TipoPessoa>
		implements DaoInterface<TipoPessoa> {
	
	public TipoPessoaController(Class<TipoPessoa> persistenceClass) {
		super(persistenceClass);
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvar(@RequestBody String jsonTipoPessoa)
			throws Exception{
		TipoPessoa tipoPessoa = new Gson().fromJson(jsonTipoPessoa,
				TipoPessoa.class);
		
		System.out.println(jsonTipoPessoa);
		super.salvarOuAtualizar(tipoPessoa);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public String listartodos()
			throws Exception {
		String json = new Gson().toJson(super.lista());
		System.out.println(json);
		return json;
	}

	@RequestMapping(value = "deletar/{idTipoPessoa}", method = RequestMethod.DELETE)
	public @ResponseBody
	String deletar(@PathVariable("idTipoPessoa") String idTipoPessoa)
			throws Exception {
		super.deletar(loadObjeto(Long.parseLong(idTipoPessoa)));
		return "";
	}
	
	@RequestMapping(value = "listar/{idTipoPessoa}", method = RequestMethod.GET)
	public @ResponseBody
	String buscarTipoPessoa(@PathVariable("idTipoPessoa") String idTipoPessoa)
			throws Exception {
		TipoPessoa objeto = super.loadObjeto(Long.parseLong(idTipoPessoa));
		if (objeto == null) {
			return "{}";
		}
		String json = new Gson().toJson(objeto); 
		System.out.println(json);
		return json;
	}

	

}









