package com.mobwaysolutions.listagem

import com.mobwaysolutions.listagem.exemplos.Animal
import com.mobwaysolutions.listagem.exemplos.Cachorro
import com.mobwaysolutions.listagem.exemplos.Gato

fun main() {

    val gato = Gato("persa")
    val cachorro = Cachorro("grande")
    verificarAnimal(gato)


    // CLOSURE
    val resultadoSoma = somar(1, 5)
    println(resultadoSoma)

    subtrair(10, 9) { resultadoInt, resultadoFormatado ->
        println(resultadoFormatado)
    }


}

fun somar(n1 : Int, n2 : Int) : Int {
    return (n1 + n2)
}

fun subtrair(n1 : Int, n2 : Int, onResult: (Int, String) -> Unit) {
    val resultado = n1 - n2
    onResult(resultado, "Meu resultado é $resultado")
}


fun verificarAnimal(animal: Animal) {
    if(animal is Gato) {
        println(animal.raca)
    }
    if (animal is Cachorro) {
        println(animal.porte)
    }
}

