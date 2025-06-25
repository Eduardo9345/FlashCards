package com.example.flashcards_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flashcards_project.dto.UsuarioDTO;
import com.example.flashcards_project.entity.Deck;
import com.example.flashcards_project.entity.Usuario;
import com.example.flashcards_project.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private DeckService deckService;

    public Usuario save(UsuarioDTO usuario){
        Usuario usuarioEntity = new Usuario();

        usuarioEntity.setNome(usuario.nome());
        usuarioEntity.setMatricula(usuario.matricula());
        usuarioEntity.setEmail(usuario.email());
        usuarioEntity.setImagem(usuario.imagem());
        usuarioEntity.setPorcentagemAcertos(usuario.porcentagemAcertos());
        usuarioEntity.setPorcentagemErros(usuario.porcentagemErros());
        usuarioEntity.setSenha(usuario.senha());

        return this.repository.save(usuarioEntity);
    }

    public Usuario getUsuarioById(Long id){
        return this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
    }

    public List<Usuario> getAll(){
        return this.repository.findAll();
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }

    public Usuario update(UsuarioDTO usuario){
        Usuario existingUsuario = this.getUsuarioById(usuario.id());
        existingUsuario.setNome(usuario.nome());
        existingUsuario.setMatricula(usuario.matricula());

        this.updateImagem(usuario.id(), usuario.imagem());

        existingUsuario.setEmail(usuario.email());
        existingUsuario.setSenha(usuario.senha());
        existingUsuario.setPorcentagemAcertos(usuario.porcentagemAcertos());
        existingUsuario.setPorcentagemErros(usuario.porcentagemErros());
        
        return this.repository.save(existingUsuario);
    }

    public Usuario getUsuarioByEmail(String email) {
        return this.repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
    }

    public Usuario getUsuarioByMatricula(String matricula) {
        return this.repository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));
    }

    public boolean existsByEmail(String email) {
        return this.repository.findByEmail(email).isPresent();
    }

    public boolean existsByMatricula(String matricula) {
        return this.repository.findByMatricula(matricula).isPresent();
    }
    
    public boolean existsById(Long id) {
        return this.repository.existsById(id);
    }
    
    public boolean addDeckToUsuario(Long id, Long deckId) {
        Usuario usuario = this.getUsuarioById(id);
        if (usuario == null) {
            return false; // Usuario not found
        }

        if (usuario.getDecks() == null) {
            usuario.setDecks(new ArrayList<>());
        }

        Deck deck = deckService.getDeckById(deckId);

        usuario.getDecks().add(deck);
        deck.setUsuario(usuario);
        this.repository.save(usuario);
        return true;
    }

    
    public boolean removeDeckFromUsuario(Long id, Long deckId) {
        Usuario usuario = this.getUsuarioById(id);
        if (usuario == null) {
            return false; // Usuario not found
        }

        List<Deck> decks = usuario.getDecks();
        if (decks != null) {
            for (Deck deck : decks) {
                if (deck.getId().equals(deckId)) {
                    decks.remove(deck);
                    deck.setUsuario(null);
                    this.repository.save(usuario);
                    return true;
                }
            }
        }
        return false; // Deck not found
    }

    public List<Deck> getDecksByUsuarioId(Long id) {
        Usuario usuario = this.getUsuarioById(id);
        if (usuario == null) {
            return new ArrayList<>(); // Usuario not found
        }
        return usuario.getDecks();
    }

    public void updatePorcentagemAcertos(Long id, Double porcentagemAcertos) {
        Usuario usuario = this.getUsuarioById(id);
        usuario.setPorcentagemAcertos(porcentagemAcertos);
        this.repository.save(usuario);
    }

    public void updatePorcentagemErros(Long id, Double porcentagemErros) {
        Usuario usuario = this.getUsuarioById(id);
        usuario.setPorcentagemErros(porcentagemErros);
        this.repository.save(usuario);
    }

    public void updateImagem(Long id, String imagem) {
        Usuario usuario = this.getUsuarioById(id);
        usuario.setImagem(imagem);
        this.repository.save(usuario);
    }
}
