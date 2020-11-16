package br.com.alura.forum.repository;

import br.com.alura.forum.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
//    List<Topico> findByCurso_Nome(String nomeCurso);

    @Query("select t from Topico t where t.curso.nome = :nomeCurso")
    Page<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso, Pageable paginacao);
}

