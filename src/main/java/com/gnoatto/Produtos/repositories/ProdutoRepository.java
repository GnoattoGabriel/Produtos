package com.gnoatto.Produtos.repositories;

import com.gnoatto.Produtos.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
