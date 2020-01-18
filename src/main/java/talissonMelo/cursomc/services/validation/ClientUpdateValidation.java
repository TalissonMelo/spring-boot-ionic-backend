package talissonMelo.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import talissonMelo.cursomc.domain.Cliente;
import talissonMelo.cursomc.dto.ClienteDTO;
import talissonMelo.cursomc.repositories.ClienteRepository;
import talissonMelo.cursomc.resources.exception.FieldMessage;

public class ClientUpdateValidation implements ConstraintValidator<ClientUpdate, ClienteDTO> {

	@Override
	public void initialize(ClientUpdate ann) {
	}

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

		List<FieldMessage> list = new ArrayList<>();

		Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
		if (aux != null && aux.getId().equals(uriId)) {
			list.add(new FieldMessage("Email", "Email já existente."));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}