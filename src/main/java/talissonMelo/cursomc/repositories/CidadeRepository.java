package talissonMelo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import talissonMelo.cursomc.domain.Cidade;

	@Repository
	public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
