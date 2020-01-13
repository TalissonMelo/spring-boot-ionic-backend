package talissonMelo.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import talissonMelo.cursomc.domain.Cliente;
import talissonMelo.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
	
	public class ClienteResource {
	
		@Autowired
		private ClienteService service;
		
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public ResponseEntity<?> find(@PathVariable Integer id) {
			
			Cliente obj = service.busar(id);
			return  ResponseEntity.ok().body(obj);

		}
}
