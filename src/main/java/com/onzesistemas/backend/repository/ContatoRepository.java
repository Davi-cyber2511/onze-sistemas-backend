package com.onzesistemas.backend.repository;

import com.onzesistemas.backend.model.Contato;
import com.onzesistemas.backend.model.PreCadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
