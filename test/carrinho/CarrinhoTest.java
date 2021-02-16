package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTest {
	
	Carrinho carrinho;
	
	@BeforeEach
	public void instanciarCarrinho() {
		this.carrinho = new Carrinho();
	}
	
	@Test
	public void testAdicionarProdutoNoCarrinho() {
		Produto camisa = new Produto("Camisa", 39.90);
		carrinho.addItem(camisa);
		assertEquals(camisa.getPreco(), carrinho.getValorTotal());
	}
	
	@Test
	public void testRemoverProdutoDoCarrinho() throws ProdutoNaoEncontradoException {
		Produto camisa1 = new Produto("Camisa", 44.90);
		Produto camisa2 = new Produto("Camiseta", 25.90);
		carrinho.addItem(camisa1);
		carrinho.addItem(camisa2);
		
		//Throws exception
		carrinho.removeItem(camisa1);
		assertEquals(1, carrinho.getQtdeItems());
	}
	
	@Test
	public void testVerificaSeLimpaOCarrinho() {
		Produto camisa = new Produto("Camisa", 99.90);
		Produto bermuda = new Produto("Bermuda", 49.90);
		carrinho.addItem(camisa);
		carrinho.addItem(bermuda);
		
		carrinho.esvazia();
		assertEquals(0, carrinho.getQtdeItems());
	}
	
}
