package Desafio3.Class.Lanche
import Desafio3.Class.Produto

abstract class Lanche(nomeDoLanche: String,
                      precoDoLanche: Double) : Produto(nomeDoLanche, precoDoLanche) {}