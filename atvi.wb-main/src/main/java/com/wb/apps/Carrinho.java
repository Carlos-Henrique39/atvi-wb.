package com.wb.apps;


import com.wb.io.Entrada;
import com.wb.listar.Listagem;
import com.wb.listar.ListarTodosClientes;
import com.wb.listar.ListarTodosProdutos;
import com.wb.listar.ListarTodosServicos;
import com.wb.modelo.Empresa;
import com.wb.modelo.ProdutoConsumido;
import com.wb.modelo.ServicoConsumido;

public class Carrinho extends Execucao{
	private Empresa empresa;
	
	public Carrinho(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void executar() {
		
		boolean carrinho = true;
		
		while ( carrinho ) {
			
			Listagem listagemCli = new ListarTodosClientes(empresa.getClientes());
			listagemCli.listar();
			
			System.out.println("\nDigite o n?mero do cliente que voc? deseja colocar no carrinho");
			Entrada entrada = new Entrada();
			int cli = entrada.receberNumeroInteiro();
			
			System.out.println("\nVoc? deseja adicionar:");
			System.out.println("1 - Produtos");
			System.out.println("2 - Servi?os");
			System.out.println("0 - Voltar");
			int adicionar = entrada.receberNumeroInteiro();
			
			switch (adicionar) {
			case 1:
				String parar = "sim";
				while (parar.equals("sim")) {
					Listagem listagemProd = new ListarTodosProdutos(empresa.getProdutos());
					listagemProd.listar();
					int numProd = 0;
					while (true) {
						System.out.println("Digite o n?mero do produto que voc? deseja adicionar:");
						numProd = entrada.receberNumeroInteiro();
						if (numProd >= 0 && numProd < empresa.getProdutos().size()) {
							break;
						}
					System.out.println("N?mero de produto inv?lido! Verifique se o n?mero inserido est? correto.");
					}
					
					System.out.println("Digite a quantidade de consumo do Produto:");
					int quant = entrada.receberNumeroInteiro();
					ProdutoConsumido prodCons = new ProdutoConsumido((empresa.getProdutos().get(numProd)), quant);
					empresa.getClientes().get(cli).getProdutosConsumidos().add(prodCons);
					
					System.out.println("Produto adicionado com sucesso!");
					System.out.println("\nDigite sim para adicionar outro produto e nao para continuar");
					parar = entrada.receberTexto();
				}
				break;
				
			case 2:
				String stop = "sim";
				while (stop.equals("sim")) {
					Listagem listagemServ = new ListarTodosServicos(empresa.getServicos());
					listagemServ.listar();
					int numServ = 0;
					while (true) {
						System.out.println("Digite o n?mero do Servi?o que voc? deseja adicionar:");
						numServ = entrada.receberNumeroInteiro();
						if (numServ >= 0 && numServ < empresa.getServicos().size()) {
							break;
						}
					System.out.println("N?mero de Servi?o inv?lido! Verifique se o n?mero inserido est? correto.");
					}
					
					System.out.println("Digite a quantidade de consumo do Servi?o:");
					int quant = entrada.receberNumeroInteiro();
					ServicoConsumido servCons = new ServicoConsumido((empresa.getServicos().get(numServ)), quant);
					empresa.getClientes().get(cli).getServicosConsumidos().add(servCons);
					
					System.out.println("Produto adicionado com sucesso!");
					System.out.println("\nDigite sim para adicionar outro Servi?o e nao para continuar");
					stop = entrada.receberTexto();
				}
				break;
			
			case 0:
				System.out.println("Voltando para o menu inicial!");
				carrinho = false;
				break;
			}
		}
	}
	
}