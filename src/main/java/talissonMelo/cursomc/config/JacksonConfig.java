package talissonMelo.cursomc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import talissonMelo.cursomc.domain.PagamentoComBoleto;
import talissonMelo.cursomc.domain.PagamentoComCartao;

@Configuration
public class JacksonConfig {
// https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PagamentoComCartao.class); // registra a subClasses PagamentoComCartao
				objectMapper.registerSubtypes(PagamentoComBoleto.class); // registra PagamentoComBoleto
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}