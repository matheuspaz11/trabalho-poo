/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufc.poo.sorveteria.repository;

import com.ufc.poo.sorveteria.model.Produto;
import com.ufc.poo.sorveteria.exceptions.NotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author cristiano
 */
public class ProdutoRepository {
    private static List<Produto> produtos;

    public ProdutoRepository() {
        if (produtos == null) {
            produtos = new ArrayList<>();
        }
    }

    public void save(Produto produto) throws NotFoundException {
        if (produto == null) {
            throw new NotFoundException("Produto é nulo");
        }

        produto.setCreatedAt(new Timestamp(new Date().getTime()));

        produtos.add(produto);
    }

    public Produto findById(Integer id) {
        return produtos.stream().filter(produto -> produto.getId().equals(id)).findFirst().get();
    }

    public void edit(Produto produto) throws NotFoundException {
        Produto produtoEdit = this.findById(produto.getId());
        if (produtoEdit == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        if (!produto.getNome().isEmpty()) {
            produtoEdit.setNome(produto.getNome());
        }

        if (produto.getTipo() != null) {
            produtoEdit.setTipo(produto.getTipo());
        }

        if (!produto.getPreco().isNaN()) {
            produtoEdit.setPreco(produto.getPreco());
        }

        if (produto.getQuantidadeDisponivel() != null) {
            produtoEdit.setQuantidadeDisponivel(produto.getQuantidadeDisponivel());
        }

        produtoEdit.setUpdatedAt(new Timestamp(new Date().getTime()));
        this.remove(produtoEdit.getId());// vai remover o valor antigo do array

        produtos.add(produtoEdit);// atualiza o array
    }

    public void remove(Integer id) throws NotFoundException {
        if (this.findById(id) == null) {
            throw new NotFoundException("Cliente não encontrado");
        }

        produtos = produtos.stream().filter(produtoSalvo -> !produtoSalvo.getId().equals(id))
                .collect(Collectors.toList());
    }
}
