const API_URL = "http://localhost:8080/usuarios";

function getReferralLink() {
    const params = new URLSearchParams(window.location.search);
    return params.get('ref'); 
}

function saveUserSession(userId, userLink) {
    localStorage.setItem('userId', userId);
    localStorage.setItem('userLink', userLink);
}

function logoutUser() {
    localStorage.removeItem('userId');
    localStorage.removeItem('userLink');
    window.location.href = 'index.html';
}

const form = document.getElementById('cadastro-form');

if (form) {
    const inputNome = document.getElementById('nome');
    const inputEmail = document.getElementById('email');
    const inputSenha = document.getElementById('senha');
    const inputTelefone = document.getElementById('telefone');
    const feedbackMsg = document.getElementById('feedback-message');
    const senhaFeedback = document.getElementById('senha-feedback');

    function validarSenha(senha) {
        
        if (senha.length < 8) {
            senhaFeedback.textContent = "Mínimo 8 caracteres.";
            return false;
        }
        if (!/[a-zA-Z]/.test(senha) || !/\d/.test(senha)) {
            senhaFeedback.textContent = "Deve conter letras e números.";
            return false;
        }
        senhaFeedback.textContent = "";
        return true;
    }

    function validarEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
    
    
    inputSenha.addEventListener('input', () => validarSenha(inputSenha.value));

    
    form.addEventListener('submit', function(event) {
        event.preventDefault();
        
        const nome = inputNome.value.trim();
        const email = inputEmail.value.trim();
        const senha = inputSenha.value;
        const telefone = inputTelefone.value.trim();
        
        
        if (!validarEmail(email)) {
            feedbackMsg.textContent = "E-mail inválido.";
            feedbackMsg.classList.remove('hidden');
            feedbackMsg.style.backgroundColor = '#f8d7da'; 
            return;
        }
        if (!validarSenha(senha)) {
            feedbackMsg.textContent = "Senha inválida. Corrija o campo.";
            feedbackMsg.classList.remove('hidden');
            feedbackMsg.style.backgroundColor = '#f8d7da';
            return;
        }

        
        const linkIndicacaoPai = getReferralLink();
        
        
        fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            body: JSON.stringify({
                nome: nome,
                email: email,
                senha: senha,
                telefone: telefone,
                linkIndicacaoPai: linkIndicacaoPai 
            })
        })
        .then(res => {
            if (!res.ok) {
                throw new Error(`Erro de servidor: ${res.status}`);
            }
            return res.json();
        })
        .then(usuarioSalvo => {
            
            saveUserSession(usuarioSalvo.id, usuarioSalvo.linkIndicacao);
            alert("Cadastro realizado com sucesso! Redirecionando para o perfil.");
            window.location.href = 'perfil.html'; 
        })
        .catch(error => {
            
            console.error('Erro no cadastro:', error);
            feedbackMsg.textContent = `Falha ao cadastrar: ${error.message}.`;
            feedbackMsg.classList.remove('hidden');
            feedbackMsg.style.backgroundColor = '#f8d7da';
        });
    });
}


const perfilNome = document.getElementById('perfil-nome');

if (perfilNome) { 
    const userId = localStorage.getItem('userId');
    const userLinkUUID = localStorage.getItem('userLink');
    const btnCopiar = document.getElementById('btn-copiar');
    const linkInput = document.getElementById('link-indicacao-text');
    const btnLogout = document.getElementById('btn-logout');

    
    if (!userId || !userLinkUUID) {
       
        window.location.href = 'index.html'; 
    } else {
        
        const urlBase = window.location.origin;
        
        const linkCompleto = `${urlBase}/index.html?ref=${userLinkUUID}`;
        linkInput.value = linkCompleto;
        

        fetch(`${API_URL}/${userId}`)
            .then(res => {
                if (!res.ok) throw new Error("Usuário não encontrado.");
                return res.json();
            })
            .then(usuario => {
                document.getElementById('perfil-nome').textContent = usuario.nome;
                document.getElementById('perfil-pontuacao').textContent = usuario.pontuacao;
            })
            .catch(err => {
                console.error("Erro ao carregar dados do perfil:", err);
                 
            });

        
        btnCopiar.addEventListener('click', () => {
            linkInput.select();
            
            navigator.clipboard.writeText(linkInput.value)
                .then(() => {
                    alert("Link de indicação copiado!");
                })
                .catch(err => {
                    
                    alert("Link copiado! (Método antigo)");
                });
        });
        
        
        btnLogout.addEventListener('click', logoutUser);
    }
}