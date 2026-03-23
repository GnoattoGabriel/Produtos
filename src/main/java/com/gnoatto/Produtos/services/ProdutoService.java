package com.gnoatto.Produtos.services;

import com.gnoatto.Produtos.models.ProdutoModel;
import com.gnoatto.Produtos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> findAll(){
        return produtoRepository.findAll();
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public Optional<ProdutoModel> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoModel){
        Optional<ProdutoModel> produtoNobanco = produtoRepository.findById(id);

        if (produtoNobanco.isPresent()){
            ProdutoModel produtoEditar = produtoNobanco.get();

            produtoEditar.setNome(produtoModel.getNome());
            produtoEditar.setPreco(produtoModel.getPreco());
            produtoEditar.setEstoque(produtoModel.getEstoque());

            return produtoRepository.save(produtoEditar);
        } else return  null;
    }




}
