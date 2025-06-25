package com.example.flashcards_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flashcards_project.entity.Sessao;
import com.example.flashcards_project.repository.SessaoRepository;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    public void saveSessao(Sessao sessao) {
        sessaoRepository.save(sessao);
    }
    public List<Sessao> getAllSessoes() {
        return sessaoRepository.findAll();
    }
    public void deleteSessaoById(Long id) {
        sessaoRepository.deleteById(id);
    }
    public Sessao getSessaoById(Long id) {
        return sessaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sessao not found"));
    }
    public void updateSessao(Long id, Sessao newSessao) {
        sessaoRepository.findById(id).ifPresent(sessao -> {
            sessao.setUsuario(newSessao.getUsuario());
            sessao.setDataInicio(newSessao.getDataInicio());
            sessao.setDataFim(newSessao.getDataFim());
            sessao.setAcertos(newSessao.getAcertos());
            sessao.setErros(newSessao.getErros());
            sessao.setEstudos(newSessao.getEstudos());
            sessaoRepository.save(sessao);
        });
    }
    public List<Sessao> getSessoesByUsuarioId(Long usuarioId) {
        return sessaoRepository.findByUsuarioId(usuarioId);
    }

}
