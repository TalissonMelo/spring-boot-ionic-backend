package talissonMelo.cursomc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import talissonMelo.cursomc.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;

	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {

		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());                    //Destinátario
		sm.setFrom(sender);										 //Remetente
		sm.setSubject("Pedido confirmado COD: " + obj.getId()); //Assunto do Email
		sm.setSentDate(new Date(System.currentTimeMillis()));  //Data com horário do meu servidor
		sm.setText(obj.toString());							  //Corpo do Email
		return sm;
	}
}
