package Desafio3.Class.Menu

import Desafio3.Class.Bebida.Refrigerante
import Desafio3.Class.Bebida.Suco
import Desafio3.Class.Lanche.XBurger
import Desafio3.Class.Lanche.XSalada
import MSG_VALOR_FINALIZAR
import MSG_VALOR_INVALIDO
import Desafio3.Class.SistemaFastFood
import kotlin.system.exitProcess

class Menu {

    private var xBurger = XBurger()
    private var xSalada = XSalada()
    private var refrigerante= Refrigerante()
    private var suco= Suco()
    fun menuPrincipal(sistema: SistemaFastFood) {
        println("-------------")
        println("| 1- Lanche   |")
        println("| 2- Bebida   |")
        println("| 3- Carrinho |")
        println("| 4- Sair     |")
        print(  "Qual opção você deseja:")
        try {
            when (readln().toInt()) {
                1 -> {
                    menuLanche(sistema)
                }
                2 -> {
                    menuBebida(sistema)

                }
                3 -> {
                    menuCarrinho(sistema)

                }
                4-> {
                    exitProcess(0)
                }

                else -> {
                    println(MSG_VALOR_INVALIDO)
                    menuPrincipal(sistema)

                }
            }
        } catch (exception: Exception){
            println("\n Formato inválido, para escolher o item, você deve informar o número dele.\n")
            menuPrincipal(sistema)
        }

    }

    private fun menuLanche(sistema: SistemaFastFood){
        println("-------------")
        println("| 1- X-burger  (R$ 10.00)|")
        println("| 2- X-Salada  (R$ 12.00)|")
        println("| 3- Voltar inicial      |")
        print(  "Escolha o lanche:")
        try {
            when (readln().toInt()) {
                1 -> {
                    sistema.guardarProduto(xBurger)
                    menuLanche(sistema)

                }
                2 -> {
                    sistema.guardarProduto(xSalada)
                    menuLanche(sistema)


                }

                3 -> {
                    menuPrincipal(sistema)
                }

                else -> {
                    println(MSG_VALOR_INVALIDO)
                    menuLanche(sistema)

                }
            }
        } catch (exception: Exception){
            println("\n Formato inválido, para escolher o item, você deve informar o número dele.\n")
            menuLanche(sistema)
        }

    }

    private fun menuBebida(sistema: SistemaFastFood){
        println("-------------")
        println("| 1- Refrigerante (R$ 8.00)|")
        println("| 2- Suco         (R$ 6.00)|")
        println("| 3- Voltar menu inicial   |")
        print(  "Escolha a bebida:")
        try {
            when (readln().toInt()) {
                1 -> {
                    sistema.guardarProduto(refrigerante)
                    menuBebida(sistema)

                }
                2 -> {
                    sistema.guardarProduto(suco)
                    menuBebida(sistema)
                }
                3 -> {
                    menuPrincipal(sistema)
                }
                else -> {
                    println(MSG_VALOR_INVALIDO)
                    menuBebida(sistema)

                }
            }
        } catch (exception: Exception){
            println("\n Formato inválido, para escolher o item, você deve informar o número dele.\n")
            menuBebida(sistema)
        }

    }
    private fun menuCarrinho(sistema: SistemaFastFood){

        println("\n-------------------\n")
        sistema.mostrarOsProdutos()
        println("\n-------------------")
        println("| 1- Remover        |")
        println("| 2- Finalizar      |")
        println("| 3- Voltar         |")
        print(  "Escolha a opção:")
        try {
            when (readln().toInt()) {
                1 -> {
                    println("Informe o codigo do produto :")
                    val numero = readln().toInt()
                    sistema.devolverPecas(numero)
                    menuCarrinho(sistema)
                }
                2-> {
                    menuFinalizarPedido(sistema)
                }
                3-> {
                    menuPrincipal(sistema)
                }

                else -> {
                    println(MSG_VALOR_INVALIDO)
                    menuCarrinho(sistema)

                }
            }
        } catch (exception: Exception){
            println("\n Formato inválido, para escolher o item, você deve informar o número dele.\n")
            menuCarrinho(sistema)
        }

    }

    private fun menuFinalizarPedido(sistema: SistemaFastFood){
        println("\n-------------------")
        println("| 1- Dinheiro          |")
        println("| 2- Cartão de débito  |")
        println("| 3- Cartão de credito |")
        println("| 4- vale refeição     |")
        println("| 5- Voltar menu inical|")
        print(  "Escolha a forma de pagamento:")
        try {
            when (readln().toInt()) {
                1-> {
                    sistema.calcularValor()
                    sistema.dinheiro()
                    menuFinalizarPedido(sistema)

                }
                2 -> {
                    println(MSG_VALOR_FINALIZAR)
                    exitProcess(0)

                }
                3 -> {
                    println(MSG_VALOR_FINALIZAR)
                    exitProcess(0)
                }
                4 -> {
                    println(MSG_VALOR_FINALIZAR)
                    exitProcess(0)
                }
                5 -> {
                    menuPrincipal(sistema)
                }

                else -> {
                    println(MSG_VALOR_INVALIDO)
                    menuCarrinho(sistema)

                }
            }
        } catch (exception: Exception){
            println("\n Formato inválido, para escolher o item, você deve informar o número dele.\n")
            menuCarrinho(sistema)
        }

    }

}