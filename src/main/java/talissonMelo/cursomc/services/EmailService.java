package talissonMelo.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import talissonMelo.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}
