# language: pt

Funcionalidade: Validações do produto

Como um usuário
Gostaria de incluir e excluir produtos do carrinho
Para que eu posso validar as informações do carrinho

Contexto: 
	Dado que acessei o site AdvantageOnlineShopping
	E no menu clicar na opção Special Offer
	
@Cenario1
Cenario: Validar especificações do produto
	E clicar no botão See Offer
	Então vou validar as especificações do produto

@Cenario2
Cenario: Validar alteração de cor do produto no carrinho
	E clicar no botão See Offer
	E selecionar a cor do banco
	E clicar no botão Add to cart
	Então o produto foi adicionado ao carrinho

@Cenario3
Cenario: Validar página de checkout
 	E pesquisar o produto clicando no ícone de lupa
 	E selecionar o produto pesquisado
 	E alterar a cor
 	E alterar a quantidade de produtos
 	E clicar no botão Add to cart
 	E acessar a página de checkout
 	Então vou validar que a soma dos preços corresponde ao total da página de checkout
 	Então vou realizar um update no banco para a cor escolhida
 	
 @Cenario4
 Cenario: Remover produto do carrinho de compras
 	E clicar no botão See Offer
  E clicar no botão Add to cart
  E clicar no carrinho de compras
 	Quando remover o produto do carrinho de compras
 	Então o carinho de compras estará vazio
 	
 	
