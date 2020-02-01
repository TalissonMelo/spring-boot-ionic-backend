package talissonMelo.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import talissonMelo.cursomc.domain.Cliente;
import talissonMelo.cursomc.repositories.ClienteRepository;
import talissonMelo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private EmailService emailService;

	private Random random = new Random();

	public void sendNewPassword(String email) {

		Cliente cliente = clienteRepository.findByEmail(email);

		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado.");
		}

		String newPassword = newPassword();
		cliente.setSenha(bCryptPasswordEncoder.encode(newPassword));
		clienteRepository.save(cliente);

		emailService.sendNewPasswordEmail(cliente, newPassword);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < vet.length; i++) {
			vet[i] = randomChar();
		}

		return new String(vet);
	}

	// https://unicode-table.com/pt/#control-character
	private char randomChar() {
		int opt = random.nextInt(3);
		if (opt == 0) { // Gera número
			return (char) (random.nextInt(10) + 48);
		} else if (opt == 1) { // Gera letra Maiuscula
			return (char) (random.nextInt(26) + 65);
		} else { // Gera letra Minuscula
			return (char) (random.nextInt(26) + 97);
		}
	}
}
