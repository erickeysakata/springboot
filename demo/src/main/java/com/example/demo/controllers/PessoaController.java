package com.example.demo.controllers;
import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.exception.NotFoundException;
import com.example.demo.dto.PessoaDto;

@RestController
@RequestMapping("/pessoa")

public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) {
        try{
            var res = pessoaService.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        }catch(Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable("id") Long id) {
        var res = pessoaService.getById(id);
        return res.isPresent()
            ? ResponseEntity.ok(res)
            : ResponseEntity.notFound().build();

    }

}
