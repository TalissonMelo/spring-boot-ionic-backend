package talissonMelo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import talissonMelo.cursomc.domain.Endereco;

	@Repository
	public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
