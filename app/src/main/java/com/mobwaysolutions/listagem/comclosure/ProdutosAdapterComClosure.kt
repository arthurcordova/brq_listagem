package com.mobwaysolutions.listagem.comclosure

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.listagem.R
import com.mobwaysolutions.listagem.cominterface.Produto
import com.mobwaysolutions.listagem.cominterface.ProdutosViewHolder
import com.mobwaysolutions.listagem.sealedclass.TipoInteracao

/**
 * É o responsável por fazer toda a mecanica da lista, juntar o item com a lista e mandar para o recycler view
 */
class ProdutosAdapterComClosure(
    val listDeProdutos: List<Produto>,
    private val onClick: (Produto, TipoInteracao) -> Unit
) :
    RecyclerView.Adapter<ProdutosViewHolder>() {

    /**
     * Cria um view holder para cada elemento da lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val viewQueVemDoXML: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_produto, parent, false)
        return ProdutosViewHolder(viewQueVemDoXML)
    }

    /**
     * Recebe por parametro o viewHolder instanciado e a posiçao para conseguir buscar da lista e preencher os dados
     */
    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val produtoSelecionado = listDeProdutos[position]
        holder.preencherCampos(produtoSelecionado)
        holder.itemView.setOnClickListener {
            onClick.invoke(produtoSelecionado, TipoInteracao.OnClickItem)
        }
        holder.btEditar.setOnClickListener {
            onClick.invoke(produtoSelecionado, TipoInteracao.OnClickEdit)
        }
        holder.btNovo.setOnClickListener {
            onClick.invoke(produtoSelecionado, TipoInteracao.OnClickNew)
        }
    }

    /**
     * Utiliza a quantidade total de elementos na lista para montar o recycler view
     */
    override fun getItemCount(): Int {
        return listDeProdutos.size
    }

}