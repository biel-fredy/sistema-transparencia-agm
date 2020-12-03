package br.gov.sp.fatec.transparencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.transparencia.model.LogSalarios;

@Repository
public interface LogSalariosRepositorio extends JpaRepository<LogSalarios, Long> {

}
