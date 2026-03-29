package com.gnoatto.Produtos.controllers;


import com.gnoatto.Produtos.models.ProdutoModel;
import com.gnoatto.Produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criarLivro(@RequestBody ProdutoModel produtoNovo){
        ProdutoModel produto = produtoService.criarProduto(produtoNovo);
        return ResponseEntity.status(2010).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> buscarTodosProduto(){
        return ResponseEntity.ok(produtoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizarProduto(@PathVariable Long id,@RequestBody ProdutoModel produtoNovo){
        ProdutoModel produto = produtoService.atualizarProduto(id, produtoNovo);
        return ResponseEntity.ok(produto);
    }



}
