package com.wb.apps;

import com.wb.cadastro.Cadastro;
import com.wb.cadastro.CadastroCliente;
import com.wb.cadastro.CadastroProduto;
import com.wb.cadastro.CadastroServico;
import com.wb.io.Entrada;
import com.wb.modelo.Empresa;

public class Cadastrar extends Execucao {
	private Empresa empresa;
	
	public Cadastrar(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar() {
		
		boolean op = true;
		
		while ( op ) {
			System.out.println("\nEscolha o tipo de cadastro voc? deseja fazer:");
			System.out.println("1 - Cadastro de Clientes");
			System.out.println("2 - Cadastro de Produtos");
			System.out.println("3 - Cadastro de Servi?os");
			System.out.println("0 - Cancelar");

			Entrada entradaCad = new Entrada();
			int cadastros = entradaCad.receberNumeroInteiro();
			
			switch ( cadastros ) {
			case 0:
				System.out.println("Voltando para o menu inicial.");
				op = false;
				break;
			case 1:
				Cadastro cadastroCli = new CadastroCliente(empresa.getClientes());
				cadastroCli.cadastrar();
				break;
			case 2:
				Cadastro cadastroProd = new CadastroProduto(empresa.getProdutos());
				cadastroProd.cadastrar();
				break;
			case 3:
				Cadastro cadastroServ = new CadastroServico(empresa.getServicos());
				cadastroServ.cadastrar();
				break;
			default:
				System.out.println("\nOpera??o n?o entendida");
			}
		}
	}

}
