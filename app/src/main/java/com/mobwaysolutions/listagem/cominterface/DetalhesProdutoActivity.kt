package com.mobwaysolutions.listagem.cominterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.mobwaysolutions.listagem.R

class DetalhesProdutoActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvCategoria: TextView
    lateinit var tvPreco: TextView
    lateinit var btEditar: Button
    lateinit var telaInteira: LinearLayout

    lateinit var nossoProdutoRecebidoDaLista: Produto
    var isEditMode: Boolean = false
    var eParaMudarACorDaTela: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_produto)

        // Buscamos o nosso parametro dentro da intent e fazemos a conversao para o tipo da variavel que vamos trabalhar
        nossoProdutoRecebidoDaLista = intent.getSerializableExtra("parametro_produto") as Produto
        isEditMode = intent.getBooleanExtra("parametro_tipo_tela", false)
        eParaMudarACorDaTela = intent.getBooleanExtra("mudar_cor_tela", false)


        // Inicializamos nossos componentes da tela
        tvNome = findViewById(R.id.tvNome)
        tvCategoria = findViewById(R.id.tvCategoria)
        tvPreco = findViewById(R.id.tvPreco)
        btEditar = findViewById(R.id.btEditar)
        telaInteira = findViewById(R.id.llTelaInteira)

        // atribuimos o valor do produto que recebemos por parametro para nossa tela
        tvNome.text = nossoProdutoRecebidoDaLista.nome
        tvCategoria.text = nossoProdutoRecebidoDaLista.categoria
        tvPreco.text = nossoProdutoRecebidoDaLista.preco.toString()

        if (isEditMode) {
            btEditar.visibility = View.VISIBLE
        }

        if (eParaMudarACorDaTela) {
            telaInteira.setBackgroundColor( resources.getColor(R.color.vermelho) )
        }

    }

}