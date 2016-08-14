package br.pucminas.prod;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.pucminas.prod.entity.Amizade;
import br.pucminas.prod.entity.Cliente;

@RestController
@RequestMapping(value = "/amizades")
@SpringBootApplication
public class RedeSocialServiceApplication {

	private static int nextId = 1;
	private static Map<Integer, Amizade> poolAmizades = new HashMap<>();
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		SpringApplication.run(RedeSocialServiceApplication.class, args);
	}
	

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Amizade solicitarAmizade(@RequestParam Integer idSolicitante, @RequestParam Integer idSolicitado) {
		
		Cliente solicitante = restTemplate.getForObject("http://localhost:8080/clientes/{id}", Cliente.class, idSolicitante);
		Cliente solicitado = restTemplate.getForObject("http://localhost:8080/clientes/{id}", Cliente.class, idSolicitado);
		
		if (solicitante != null && solicitado != null) {
			Amizade amizade = new Amizade();
			amizade.setId(nextId++);
			amizade.setAmigoSolicitado(solicitado);
			amizade.setAmigoSolicitante(solicitante);
			amizade.setSolicitacaoAceita(Boolean.FALSE);
			poolAmizades.put(amizade.getId(), amizade);
			return amizade;
		}
		
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Amizade removerAmizade(@PathVariable Integer id) {
		return poolAmizades.remove(id);
	}
}
