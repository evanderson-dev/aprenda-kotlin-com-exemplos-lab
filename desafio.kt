enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val id: Int, val nome: String, val idade: Int, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    var inscritos = mutableListOf<Usuario>()

    fun matricular(usuarios: List<Usuario>) {
        for (usuario in usuarios) {
            if (inscritos.contains(usuario)) {
            	println("Usuário ${usuario.nome} já está matriculado nesta formação!")
        	} else {
            	inscritos.add(usuario)
            	println("Usuário ${usuario.nome} matriculado com sucesso!")
        	}
        }        
    }
}

fun main() {
    val usuario1 = Usuario(1,"Evanderson Ribeiro", 35, "evanderson@email.com")
    val usuario2 = Usuario(2,"Dr. House", 45, "drhouse@email.com")
    
    val conteudos = listOf(ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin"), //POR PADRÃO SERÁ UM CONTEÚDO DE 60 MINUTOS
                           ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin", 120),
                           ConteudoEducacional("Abstraindo Formações da DIO Usando Orientações a Objetos com Kotlin", 120))
    
    val formacao = Formacao("Kotlin Experience", conteudos, Nivel.BASICO)
    println(formacao)
    
    println()
    
    val usuarios = listOf(usuario1, usuario2)
    formacao.matricular(usuarios)
}