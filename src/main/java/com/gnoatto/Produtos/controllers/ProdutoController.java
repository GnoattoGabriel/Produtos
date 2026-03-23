package com.gnoatto.Produtos.controllers;


import com.gnoatto.Produtos.models.ProdutoModel;
import com.gnoatto.Produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoModel criarLivro(@RequestBody ProdutoModel produtoNovo){
        return produtoService.criarProduto(produtoNovo);
    }

    @GetMapping
    public List<ProdutoModel> buscarTodosProduto(){
        return produtoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizarProduto(@PathVariable Long id,@RequestBody ProdutoModel produtoNovo){
        return produtoService.atualizarProduto(id, produtoNovo);
    }



}
