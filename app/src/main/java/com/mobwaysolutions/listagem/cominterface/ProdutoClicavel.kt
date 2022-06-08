package com.mobwaysolutions.listagem.cominterface

/**
 * Interface que irá controlar o evento de click da lista
 */
interface ProdutoClicavel {

    /**
     * Função  que iremos chamar dentro do Adapter já com o produto/posição da lista selecionado
     */
    fun onClickLinhaInteira(produto: Produto)

    fun onClickButtonEditar(produto: Produto)

    fun onClickButtonNovo(produto: Produto)

}