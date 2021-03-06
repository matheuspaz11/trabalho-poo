/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufc.poo.sorveteria.services;

import com.ufc.poo.sorveteria.model.Produto;
import com.ufc.poo.sorveteria.repository.ProdutoRepository;
import com.ufc.poo.sorveteria.exceptions.NotFoundException;
import java.util.NoSuchElementException;

/**
 *
 * @author cristiano
 */

public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService() {
        produtoRepository = new ProdutoRepository();
    }

    public Produto cadastrar(Produto produto) throws NotFoundException {
        try {
            produtoRepository.save(produto);
            System.out.println("Produto salvo com sucesso.\n");
            return produto;
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    public void remover(Integer id) throws NotFoundException {
        try {
            produtoRepository.remove(id);
            System.out.println("Produto removido com sucesso.\n");
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    public Produto editar(Produto produto) throws NotFoundException {
        try {
            produtoRepository.edit(produto);
            System.out.println("Produto editado com sucesso.\n");
            return produto;
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    public Produto buscar(Integer id) {
        try {
            return produtoRepository.findById(id);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Nenhum produto encontrado com o id '" + id + "'");
        }
    }
}
