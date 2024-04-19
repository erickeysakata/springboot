package com.example.demo.service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.exception.NotFoundException;
import com.example.demo.dto.PessoaDto;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa create(PessoaDto dto) {
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(dto, pessoa);
        return pessoaRepository.save(pessoa);
    }
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }
    public Optional<Pessoa> getById(Long id) {
        return pessoaRepository.findById(id);
    }

    public void delete(Long id) {
        var pessoa = pessoaRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
        pessoaRepository.delete(pessoa);
    }

    public Pessoa update(Long id, PessoaDto dto) {
        var pessoa = pessoaRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
        var res = pessoa.get();
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setSenha(dto.getSenha());
        return pessoaRepository.save(pessoa);
    }

}
