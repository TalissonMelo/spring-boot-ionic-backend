package talissonMelo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import talissonMelo.cursomc.domain.Produto;

	@Repository
	public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
