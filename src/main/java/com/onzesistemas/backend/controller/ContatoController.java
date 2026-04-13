package com.onzesistemas.backend.controller;

import com.onzesistemas.backend.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/contato")
@CrossOrigin(origins = "*")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @PostMapping
    public ResponseEntity<?> contatar(@RequestBody Map<String, String> body) {
        String nome = body.get("nome");
        String email = body.get("email");
        String mensagem = body.get("mensagem");

        if (nome == null || email == null || mensagem == null ||
                nome.isBlank() || email.isBlank() || mensagem.isBlank()) {
            return ResponseEntity.badRequest().body("Todos os campos são obrigatórios.");
        }

        service.salvar(nome, email, mensagem);
        return ResponseEntity.ok("Mensagem enviada com sucesso.");
    }
}