# 🚀 Frontend - Projeto Vortex (HTML, CSS e JavaScript)

Este é o código da interface do usuário (Frontend) do meu Projeto Vortex. Ele é responsável por tudo que o usuário vê e interage, como formulários e exibição de dados.

## 🛠️ Tecnologias Utilizadas

* **HTML:** Estrutura da página.
* **CSS:** Estilização.
* **JavaScript:**
* Lógica de interação com o usuário e comunicação com o Backend.



## 💻 Como Rodar o Frontend

O código Frontend **não** roda no terminal. Ele precisa ser executado dentro de um navegador, pois utiliza recursos como o objeto `document` para manipular a interface.

1.  **Localize o arquivo principal:** Certifique-se de que você está no diretório correto (`/Projetovortex/`).
2.  **Abra o Navegador:** Localize o arquivo principal do seu frontend (geralmente **`index.html`**) e dê **dois cliques** nele.
3.  **Pronto!** A página será aberta no seu navegador padrão.

⚠️ **Atenção:** Para que a interface funcione corretamente (enviando e recebendo dados), o **Backend do Spring Boot deve estar rodando** em segundo plano.

---

## 🔗 Comunicação com o Backend

O JavaScript neste frontend faz requisições HTTP para a API do Backend Spring Boot. O servidor backend deve estar acessível em `http://localhost:8080` (ou na porta configurada).
