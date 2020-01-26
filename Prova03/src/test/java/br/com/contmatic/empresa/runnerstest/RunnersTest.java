package br.com.contmatic.empresa.runnerstest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.empresa.enderecotest.BairroTest;
import br.com.contmatic.empresa.enderecotest.CidadeTest;
import br.com.contmatic.empresa.enderecotest.EnderecoTest;
import br.com.contmatic.empresa.enderecotest.TipoDeEnderecoTest;
import br.com.contmatic.empresa.enderecotest.UfBrasilTest;
import br.com.contmatic.empresa.funcionariotest.FuncionarioTest;
import br.com.contmatic.empresa.telefonetest.DddTest;
import br.com.contmatic.empresa.telefonetest.TelefoneTest;
import br.com.contmatic.empresa.telefonetest.TipoDeTelefoneTest;
import br.com.contmatic.empresatest.EmailTest;
import br.com.contmatic.empresatest.EmpresaTest;
import br.com.contmatic.empresatest.SitesEmpresaTest;

@RunWith(Suite.class)
@SuiteClasses({ EmailTest.class, EmpresaTest.class, SitesEmpresaTest.class, BairroTest.class, CidadeTest.class,
		EnderecoTest.class, TipoDeEnderecoTest.class, UfBrasilTest.class, FuncionarioTest.class, DddTest.class,
		TelefoneTest.class, TipoDeTelefoneTest.class })
public class RunnersTest {

}
