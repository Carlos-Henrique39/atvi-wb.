	package com.wb.apps;

import com.wb.io.Entrada;
import com.wb.listar.*;
import com.wb.modelo.Empresa;
import com.wb.outralistagem.ListarProdServCons;

public class Listar extends Execucao{
	private Empresa empresa;
	
	public Listar(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar() {
		
		boolean  op = true;
		
		while ( op ) {
			System.out.println("\nSelecione umas das op??es para exibir a lista que deseja:");
			System.out.println("1 - Listar todos os Clientes");
			System.out.println("2 - Listar todos os Produtos");
			System.out.println("3 - Listar todos os Servi?os");
			System.out.println("4 - Listar todos os Produtos Consumidos");
			System.out.println("5 - Listar todos os Servi?os Consumidos");
			System.out.println("0 - Voltar");
		
			Entrada entradaList = new Entrada();
			int listagens = entradaList.receberNumeroInteiro();
		
			switch ( listagens ) {
			case 0:
				System.out.println("Voltando para o menu inicial.");
				op = false;
				break;
			case 1:
				Listagem listagemCli = new ListarTodosClientes(empresa.getClientes());
				listagemCli.listar();
				break;
		
			case 2:
				Listagem listagemProd = new ListarTodosProdutos(empresa.getProdutos());
				listagemProd.listar();
				break;
		
			case 3:
				Listagem listagemServ = new ListarTodosServicos(empresa.getServicos());
				listagemServ.listar();
				break;
			case 4:
				Listagem listagemProdCons = new ListarProdutosConsumidos(empresa.getClientes());
				listagemProdCons.listar();
				break;
			case 5:
				Listagem listagemServCons = new ListarServicosConsumidos(empresa.getClientes());
				listagemServCons.listar();
				break;
			case 6:
				Listagem listagemServProdCons = new ListarProdServCons(empresa.getClientes());
				listagemServProdCons.listar();
				break;
			default:
				System.out.println("\nOpera??o n?o entendida");
			}
		}
	}
}
