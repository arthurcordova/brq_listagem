package com.mobwaysolutions.listagem.cominterface

import java.io.Serializable


/**
 * Criado modelo para nossos items da lista
 */
class Produto(val nome: String, val categoria: String, val preco: Double) : Serializable