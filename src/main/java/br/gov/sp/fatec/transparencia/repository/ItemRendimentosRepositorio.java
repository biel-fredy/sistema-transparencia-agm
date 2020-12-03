package br.gov.sp.fatec.transparencia.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.transparencia.model.ItemRendimentos;

@Repository
@Transactional
public interface ItemRendimentosRepositorio extends JpaRepository<ItemRendimentos, Long>{
	
	List<ItemRendimentos> findByFuncionario(Integer id);

}
