# Advantage Online Shopping Automation

### Tecnologias Utilizadas:

- Cucumber 6.11.0
- Spring Framework 2.6.4
- Rest Assured 4.4.0
- Selenium 3.141.59
- GitHub
- Junit Jupiter 5.8.2
- Eclipse 4.20.0
- Maven 4.0.0
- Docker 4.1.1
- MySQL Workbench 8.0
- Postman


### Definição do Projeto: 

Realizar a Automação com Selenium dos seguintes cenários:

##### Cenário 1 – Validar especificações do produto

o Acessar o site https://advantageonlineshopping.com
o No menu, clicar na opção “Special Offer”
o Clicar no botão “See offer”
o Validar que as especificações do produto de acordo com as informações retornadas do banco de
automação

##### Cenário 2 – Validar alteração de cor do produto no carrinho

o Acessar o site https://advantageonlineshopping.com
o No menu, clicar na opção “Special Offer”
o Clicar no botão “See offer”
o Alterar a cor do produto de acordo com a cor informada no banco de automação
o Clicar no botão “Add to cart”
o Validar que produto foi adicionado ao carrinho com a cor selecionada

##### Cenário 3 – Validar página de checkout

o Acessar o site https://advantageonlineshopping.com
o Pesquisar o produto clicando no ícone de lupa (Seguir o nome do produto do banco de
automação)
o Selecionar produto pesquisado
o Alterar a cor do produto para uma diferente da existente no banco de automação
o Alterar a quantidade de produtos que deseja comprar
o Clicar no botão “Add to cart”
o Acessar a página de checkout
o Validar que a soma dos preços corresponde ao total apresentado na página de checkout
o Realizar um update no banco de automação alterar a cor existente no banco para a cor
selecionada no teste.

##### Cenário 4 – Remover produto do carrinho de compras

o Acessar o site https://advantageonlineshopping.com
o No menu, clicar na opção “Special Offer”
o Clicar no botão “See offer”
o Clicar no botão “Add to cart”
o Clicar no carrinho de compras
o Remover produto do carrinho de compras
o Validar que o carrinho de compras está vazio

### Passo a passo para execução


- Utilizar o Banco de dados MySQL 
Obs: caso não tenha instalado, baixar o MySQL Workbench no site https://www.mysql.com/products/workbench/

- Caso deseje, utilizar o Docker para rodar a imagem do MySQL.
Obs: instruções para instalação do Docker em https://docs.docker.com/desktop/windows/install/
     instruções para baixar uma imagem do MySQL no Docker em : https://phoenixnap.com/kb/mysql-docker-container
     
- Utilizar alguma IDE (Estou usando Eclipse, mas pode ser Intelliji ou qualquer outra IDE para Java)
- Criar o Banco de Automação :

![image](https://user-images.githubusercontent.com/58869569/158082155-dc0de039-de51-4049-be90-dc27bcf85cec.png)
![image](https://user-images.githubusercontent.com/58869569/158082162-2e26f0b4-3941-49b8-9505-7876e758cf6b.png)

- Rodar a imagem do MySQL no Docker (caso esteja utilizando o Docker)

![image](https://user-images.githubusercontent.com/58869569/158082211-a729de74-21d2-4cba-bd8f-49067547b5a0.png)

- Baixar o projeto do GitHub e abrir na IDE
- Baixar o projeto da ProdutoAPI do GitHub e abrir na sua IDE
- OBS : API em SpringBoot Java criada para consumir e manipular os dados do banco.
 ![image](https://user-images.githubusercontent.com/58869569/158082347-cbdf036a-a70e-480b-9d86-e910709f925f.png)

- Após abrir a API ProdutoAPI na IDE, rodar a aplicação.

![image](https://user-images.githubusercontent.com/58869569/158082379-f6d1c9eb-74d4-47e9-96bc-d186e92cb80b.png)
![image](https://user-images.githubusercontent.com/58869569/158082398-8246100b-eacf-4219-9836-0e2811e1328f.png)


- Após abrir o AdvantageOnlineShopping em sua IDE, rodar a automação. 
-#### OBS: A ProdutoAPI deve estar rodando durante a execução da automação.

![image](https://user-images.githubusercontent.com/58869569/158082505-8abb2fa5-b120-47fd-aff9-377fc288b56d.png)

#### OBS : foi utilizado no projeto o ChromeDriver para a versão
![image](https://user-images.githubusercontent.com/58869569/158082545-ae103498-4276-451d-9ff8-56d2ff114af6.png)
do Chrome e encontra-se na pasta do projeto :
![image](https://user-images.githubusercontent.com/58869569/158082566-b8414b7f-b93e-42f3-b7d5-59e9bac891b5.png)
Caso seu navegador esteja desatualizado, existem duas opções:
- Atualizar o navegador ou baixar o driver compatível com sua versão em : https://chromedriver.chromium.org/downloads




