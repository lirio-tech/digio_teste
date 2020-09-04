package br.com.digio.digioteste.lancamentocontabil.infrastructure.repository.mongodb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentoCrudRepository extends CrudRepository<LancamentoDocument, String> {

    List<LancamentoDocument> findByContaContabil(Long contaContabil);

}
