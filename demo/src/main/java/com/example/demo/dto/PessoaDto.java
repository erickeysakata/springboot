package com.example.demo.dto;

public record PessoaDto (
    //only from models
    Long id,
    String nome,
    String email,
    String senha
) {

}
