package com.onzesistemas.backend.controller;

import com.onzesistemas.backend.service.PreCadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/precadastro")
@CrossOrigin(origins = "*")
public class PreCadastroController {

    @Autowired
    private PreCadastroService service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        if (email == null || email.isBlank()) {
            return ResponseEntity.badRequest().body("E-mail obrigatório.");
        }
        service.salvar(email);
        return ResponseEntity.ok("Cadastrado com sucesso.");
    }
}