package Desafio3.Class

import MSG_VALOR_INVALIDO

abstract class Produto(var nomeProduto: String="", val precoProduto: Double= 0.0){
    var quantidadeInformada : Int = 0
    var utimoPreco: Double = 0.0

    fun informaQtd():Int{
        try {
            println("Por favor informe a quantidade:")
            quantidadeInformada= readln().toInt()
           return quantidadeInformada
        } catch (ex: Exception){
            println(MSG_VALOR_INVALIDO)
        }
      return 0
    }

    fun precoFinal(precoProduto: Double, qtd: Int){
        utimoPreco = precoProduto * qtd

    }


}