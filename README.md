# 🚀 Frontend - Projeto Vortex (HTML, CSS e JavaScript)

Este é o código da interface do usuário (Frontend) do meu Projeto Vortex. Ele é responsável por tudo que o usuário vê e interage, como formulários e exibição de dados.

## 🛠️ Tecnologias Utilizadas

* **HTML:** Estrutura da página.
* **CSS:** Estilização.
* **JavaScript:**Lógica de interação com o usuário e comunicação com o Backend.



## 💻 Como Rodar o Frontend

O código Frontend **não** roda no terminal. Ele precisa ser executado dentro de um navegador, pois utiliza recursos como o objeto `document` para manipular a interface.

1.  **Localize o arquivo principal:** O arquivo principal index.html. Certifique-se de que você está no diretório correto (`/Projetovortex/`).
2.  **Abra o Navegador:** Localize o arquivo principal do seu frontend (geralmente **`index.html`**) e dê **dois cliques** nele.
3.  **Pronto!** A página será aberta no seu navegador padrão.

⚠️ **Atenção:** Para que a interface funcione corretamente (enviando e recebendo dados), o **Backend do Spring Boot deve estar rodando** em segundo plano.

---

## 🔗 Comunicação com o Backend

O JavaScript neste frontend faz requisições HTTP para a API do Backend Spring Boot. O servidor backend deve estar acessível em `http://localhost:8080` .

## Rodando o BackEnd

# ⚙️ Backend - Projeto Vortex (Spring Boot)

Este é o servidor de Backend do meu Projeto Vortex, construído com Java e Spring Boot. Ele é responsável por toda a lógica de negócio, persistência de dados e fornecimento da API para o Frontend.

## 🛠️ Tecnologias Utilizadas

* **Java:** Linguagem principal.
* **Spring Boot:** Framework para desenvolvimento rápido de APIs.
* **Maven/Gradle:** Ferramenta para gerenciar dependências e a build.
* **MYSQl:** Gerenciamento de dados.



## 💻 Como Rodar o Backend no Terminal

Para iniciar o servidor e disponibilizar a API, você precisa executar o projeto Spring Boot.

1.  **Navegue para a Pasta Raiz:** Abra o terminal (PowerShell, CMD, ou outro) e entre no diretório onde estão os arquivos `pom.xml` ou `build.gradle`.
2.  **Execute o Servidor:** Use o comando apropriado para o seu gerenciador de dependências:

    ### Se você usa **Maven** (com `pom.xml`):
    ```bash
    .\mvnw spring-boot:run
    ```

    ### Se você usa **Gradle** (com `build.gradle`):
    ```bash
    .\gradlew bootRun
    ```

    *(**Nota:** Se o comando com `.\` não funcionar, tente remover o `.\` ou usar o `cmd` tradicional. Geralmente, `.\mvnw` funciona no PowerShell.)*

3.  **Servidor Ativo:** O servidor iniciará e ficará rodando. Procure no log a mensagem confirmando que ele está ativo na porta padrão **8080**.

## 🔄 Status do Servidor

O servidor irá ficar acessível em: `http://localhost:8080`
