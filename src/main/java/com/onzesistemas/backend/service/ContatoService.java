package com.onzesistemas.backend.service;

import com.onzesistemas.backend.model.Contato;
import com.onzesistemas.backend.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    // TODO: reativar após configurar SMTP corretamente
    // @Autowired
    // private JavaMailSender mailSender;

    // @Value("${app.mail.destino}")
    // private String mailDestino;

    public Contato salvar(String nome, String email, String mensagem) {
        Contato contato = new Contato(nome, email, mensagem);
        repository.save(contato); // ← salva no banco normalmente

        // TODO: reativar envio de e-mail depois da reunião
        /*
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailDestino);
        msg.setSubject("Novo contato — Onze Sistemas");
        msg.setText(
                "Nome: " + nome + "\n" +
                        "E-mail: " + email + "\n\n" +
                        "Mensagem:\n" + mensagem
        );
        mailSender.send(msg);
        */

        return contato;
    }
}