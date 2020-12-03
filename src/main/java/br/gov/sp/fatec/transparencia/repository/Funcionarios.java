package br.gov.sp.fatec.transparencia.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.transparencia.model.Funcionario;

@Repository
@Transactional
public interface Funcionarios extends JpaRepository<Funcionario, Long> {

	@Query("select f from Funcionario f where f.salario >= ?1 "
			+ "and f.salario <= ?2 "
			+ "and f.nome like ?3 "
			+ "and f.cargo like ?4")
	public List<Funcionario> findFuncionarioPorNome(Double salariomin, Double salariomax,
													String nome, String cargo);

	@Query("select f from Funcionario f where f.salario >= ?1 "
			+ "and f.salario <= ?2 "
			+ "and f.nome like ?3")
	public List<Funcionario> findFuncionarioPorNome(Double salariomin, Double salariomax, String nome);

	@Query("select f from Funcionario f where f.salario >= ?1 "
			+ "and f.salario <= ?2 "
			+ "and f.cargo like ?3")
	public List<Funcionario> findFuncionarioPorCargoAndSalario(Double salariomin, Double salariomax, String cargo);

	@Query("select f from Funcionario f where f.cargo like ?1")
	public List<Funcionario> findFuncionarioPorCargo(String cargo);
	
	@Query("select f from Funcionario f where f.salario >= ?1 "
			+ "and f.salario <= ?2")
	public List<Funcionario> findFuncionarioPorSalario(Double salariomin, Double salariomax);

	// List<Funcionario> findBysalarioGreaterThanOrEqual(Double salario);
}
