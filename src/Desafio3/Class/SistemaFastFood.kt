package Desafio3.Class

import MSG_VALOR_FINALIZAR
import MSG_VALOR_INVALIDO
import kotlin.system.exitProcess

class SistemaFastFood {
    private var contador = 0
    private var sistema = mutableMapOf<Int, Produto>()
    private var valorFinal : Double = 0.0
    private var dinheiro: Double = 0.0

    private fun guardarProdutoPrincipal(produto: Produto):Int{
        contador++
        sistema[contador] = produto
        return contador
    }

    fun guardarProduto(produto: Produto) {
        produto.precoFinal(produto.precoProduto,produto.informaQtd())
        guardarProdutoPrincipal(produto)

    }

    fun mostrarOsProdutos(){
        sistema.forEach { (t, u) ->
            println("$t - ${u.quantidadeInformada} ${u.nomeProduto} - ${u.utimoPreco}")

        }
    }

    fun calcularValor(){
        sistema.forEach { (t, u) ->
            valorFinal =  u.utimoPreco
        }
        println("O valor dos produto é : $valorFinal")
    }
    fun dinheiro(){
        try {
            println("Quanto você vai pagar?")
            dinheiro= readln().toDouble()
            validarDinheiro()
        } catch (ex: Exception){
            println(MSG_VALOR_INVALIDO)
        }

    }
    private fun validarDinheiro(){

        if (dinheiro >= valorFinal){
            val troco = dinheiro - valorFinal
            println("O seu troco é $troco")
            println(MSG_VALOR_FINALIZAR)
            exitProcess(0)
        }else {
            println("valor insuficiente")
        }

    }

    fun devolverPecas(numero:Int) {
        sistema.remove(numero)
    }
}