package com.mobwaysolutions.listagem.cominterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.listagem.R
import com.mobwaysolutions.listagem.comclosure.ProdutosAdapterComClosure

class ListaProdutosActivity : AppCompatActivity() {

    /**
     * Declarar recycler view
     */
    lateinit var recyclerViewProdutos: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_produtos)

        // Crio a instancia dos produtos que eu quero
        val produto1 = Produto("Cerveja", "Bebida", 3.99)
        val produto2 = Produto("Leite", "Bebida", 5.99)
        val produto3 = Produto("Bolacha", "Comida", 1.99)

        // Add os produtos instanciados na minha lista
        val listaDeProdutos = listOf(produto1, produto2, produto3)

        // Inicializar meu recycler view
        recyclerViewProdutos = findViewById(R.id.rvListaProdutos)
        recyclerViewProdutos.adapter = ProdutosAdapterComClosure(listaDeProdutos,
            onClickItem = {
                onClickLinhaInteira(it)
            }, onClickNovo = {
                onClickButtonNovo(it)
            }, onClickEdit = {
                onClickButtonEditar(it)
            })
        recyclerViewProdutos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun onClickLinhaInteira(produto: Produto) {
        val minhaIntentDeDetalhes = Intent(this, DetalhesProdutoActivity::class.java)
        minhaIntentDeDetalhes.putExtra("parametro_produto", produto)
        minhaIntentDeDetalhes.putExtra("parametro_tipo_tela", false)
        startActivity(minhaIntentDeDetalhes)
    }

    fun onClickButtonEditar(produto: Produto) {
        val minhaIntentDeDetalhes = Intent(this, DetalhesProdutoActivity::class.java)
        minhaIntentDeDetalhes.putExtra("parametro_produto", produto)
        minhaIntentDeDetalhes.putExtra("parametro_tipo_tela", true)
        startActivity(minhaIntentDeDetalhes)
    }

    fun onClickButtonNovo(produto: Produto) {
        val minhaIntentDeDetalhes = Intent(this, DetalhesProdutoActivity::class.java)
        minhaIntentDeDetalhes.putExtra("parametro_produto", produto)
        minhaIntentDeDetalhes.putExtra("mudar_cor_tela", true)
        startActivity(minhaIntentDeDetalhes)
    }

}