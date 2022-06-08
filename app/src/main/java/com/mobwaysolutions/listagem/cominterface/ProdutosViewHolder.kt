package com.mobwaysolutions.listagem.cominterface

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.listagem.R

/**
 * Responsável por interagir com um elemento da lista e mostrar ele na tela,
 * recebe o nosso item_produto.xml convertido na variavel itemView
 */
class ProdutosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val btEditar : Button = itemView.findViewById(R.id.btEditar)
    val btNovo : Button = itemView.findViewById(R.id.btNovo)

    /**
     * Recebe por parametro o produto para conseguir mostrar na tela
     */
    fun preencherCampos(produto: Produto) {
        // Carrega os elementos da tela
        val textViewTitulo = itemView.findViewById<TextView>(R.id.tvTitulo)
        val textViewSubtitulo = itemView.findViewById<TextView>(R.id.tvSubtitulo)
        val textViewPreco = itemView.findViewById<TextView>(R.id.tvPreco)

        // Link dos valores do produto com a parte visual
        textViewTitulo.text = produto.nome
        textViewSubtitulo.text = produto.categoria
        textViewPreco.text = produto.preco.toString()
    }

}