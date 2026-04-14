package com.onzesistemas.backend.service;

import com.onzesistemas.backend.model.PreCadastro;
import com.onzesistemas.backend.repository.PreCadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PreCadastroService {

    @Autowired
    private PreCadastroRepository repository;

//    @Autowired
//    private JavaMailSender mailSender;

    @Value("${app.mail.destino}")
    private String mailDestino;

    public PreCadastro salvar(String email) {
        PreCadastro pre = new PreCadastro(email);
        repository.save(pre);

        // TODO: reativar envio de e-mail após configurar SMTP
        // SimpleMailMessage msg = new SimpleMailMessage();
        // msg.setTo(mailDestino);
        // msg.setSubject("Novo pré-cadastro — Onze Sistemas");
        // msg.setText("Um visitante deixou o e-mail:\n\n" + email);
        // mailSender.send(msg);

        return pre;
    }
}