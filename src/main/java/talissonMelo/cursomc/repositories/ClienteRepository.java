package talissonMelo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import talissonMelo.cursomc.domain.Cliente;

	@Repository
	public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
