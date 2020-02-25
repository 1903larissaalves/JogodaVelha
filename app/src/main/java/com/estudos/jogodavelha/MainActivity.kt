package com.estudos.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var jogador01 = ArrayList<Int>()
    var jogador02 = ArrayList<Int>()
    var vez = 1
    var ganhador = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun jogando(posicao: Int, selecionado: Button){
        if (vez == 1){
            selecionado.text = "X"
            selecionado.setBackgroundResource(R.color.jogador01)
            jogador01.add(posicao)
            vez = 2
        }else{
            selecionado.text = "O"
            selecionado.setBackgroundResource(R.color.jogador02)
            jogador02.add(posicao)
            vez = 1
        }
        selecionado.isClickable = false

        verificarGanhador()

    }
    fun posicaoBotao (clicado: View) = when(clicado.id){
        R.id.btn01 -> jogando(1, clicado as Button)
        R.id.btn02 -> jogando(2, clicado as Button)
        R.id.btn03 -> jogando(3, clicado as Button)
        R.id.btn04 -> jogando(4, clicado as Button)
        R.id.btn05 -> jogando(5, clicado as Button)
        R.id.btn06 -> jogando(6, clicado as Button)
        R.id.btn07 -> jogando(7, clicado as Button)
        R.id.btn08 -> jogando(8, clicado as Button)
        R.id.btn09 -> jogando(9, clicado as Button)
        else -> jogando(0, clicado as Button)
    }

    fun verificarGanhador(){
        val linha01 = listOf(1,2,3)
        val linha02 = listOf(4,5,6)
        val linha03 = listOf(7,8,9)
        val coluna01 = listOf(1,4,7)
        val coluna02 = listOf(2,5,8)
        val coluna03 = listOf(3,6,9)
        val diagona01 = listOf(1,5,9)
        val diagona02 = listOf(3,5,7)

        if (jogador01.containsAll(linha01) || jogador01.containsAll(linha02) || jogador01.containsAll(linha03) ||
            jogador01.containsAll(coluna01) || jogador01.containsAll(coluna02) || jogador01.containsAll(coluna03) ||
            jogador01.containsAll(diagona01) || jogador01.containsAll(diagona02)){

            ganhador = 1

            Toast.makeText(applicationContext, "Jogador 01 venceu!", Toast.LENGTH_LONG).show()
        }

        if (jogador02.containsAll(linha01) || jogador02.containsAll(linha02) || jogador02.containsAll(linha03) ||
            jogador02.containsAll(coluna01) || jogador02.containsAll(coluna02) || jogador02.containsAll(coluna03) ||
            jogador02.containsAll(diagona01) || jogador02.containsAll(diagona02)){

            ganhador = 1

            Toast.makeText(applicationContext, "Jogador 02 venceu!", Toast.LENGTH_LONG).show()
        }

    }

    fun reiniciarJogo(view: View){
        jogador01.clear()
        jogador02.clear()
        setContentView(R.layout.activity_main)
    }
}
