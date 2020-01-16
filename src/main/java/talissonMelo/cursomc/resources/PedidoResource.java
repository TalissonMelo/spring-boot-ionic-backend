package talissonMelo.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import talissonMelo.cursomc.domain.Pedido;
import talissonMelo.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
	
	public class PedidoResource {
	
		@Autowired
		private PedidoService service;
		
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public ResponseEntity<Pedido> find(@PathVariable Integer id) {
			
			Pedido obj = service.find(id);
			return  ResponseEntity.ok().body(obj);

		}
}
