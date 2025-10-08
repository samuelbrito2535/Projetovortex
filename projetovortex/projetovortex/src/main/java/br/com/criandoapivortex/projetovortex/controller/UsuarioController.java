package br.com.criandoapivortex.projetovortex.controller;

import br.com.criandoapivortex.projetovortex.DAO.InterfaxUsuario;
import br.com.criandoapivortex.projetovortex.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private InterfaxUsuario dao;

    public static class CadastroRequest {
        public String nome;
        public String email;
        public String senha;
        public String telefone;
        public String linkIndicacaoPai;
    }




    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criaUsuario(@RequestBody CadastroRequest request) {


        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(request.nome);
        novoUsuario.setEmail(request.email);
        novoUsuario.setSenha(request.senha);
        novoUsuario.setTelefone(request.telefone);


        Usuario usuarioSalvo = dao.save(novoUsuario);


        if (request.linkIndicacaoPai != null && !request.linkIndicacaoPai.isEmpty()) {

            Optional<Usuario> indicadorOpt = dao.findByLinkIndicacao(request.linkIndicacaoPai);

            if (indicadorOpt.isPresent()) {
                Usuario indicador = indicadorOpt.get();


                usuarioSalvo.setIndicadoPorId(indicador.getId());


                indicador.setPontuacao(indicador.getPontuacao() + 1);


                dao.save(indicador);
            }
        }


        return dao.save(usuarioSalvo);
    }




    @GetMapping("/{id}")
    public Optional<Usuario> buscarUsuarioPorId(@PathVariable Integer id) {
        return dao.findById(id);
    }


    @GetMapping
    public List<Usuario> listaUsuarios() {
        return dao.findAll();
    }

    @PutMapping
    public Usuario editarUsuario(@RequestBody Usuario usuario) {
        return dao.save(usuario);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) 
    public void excluirUsuario(@PathVariable Integer id) {
        if (!dao.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado.");
        }
        dao.deleteById(id);
    }
}
