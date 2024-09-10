package br.unipar.primeiroprojetoandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Dizer qual a tela que vai ser carregada
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultado = findViewById<TextView>(R.id.txtResultado)
        val inputIdade = findViewById<EditText>(R.id.edIdade)
        val botaoValidar = findViewById<Button>(R.id.btnIdade)

        botaoValidar.setOnClickListener{

            // pega o valor do input da Tela
            val idadeInformada = inputIdade.text.toString();

                                // isNOtEmpty verifica se a variavel está vazia
            if (idadeInformada.isNotEmpty()) {

                                                // toInt a informação recebiada em int
                val idadeInt = idadeInformada.toInt()

                if(idadeInt < 18){
                    resultado.setText("Você é menor de idade")
                }else if (idadeInt >= 18 && idadeInt <=60){
                    resultado.setText("Você está na meia idade")
                }else if (idadeInt >60){
                    resultado.setText("Você é idoso")
                }

            }else{
                resultado.setText("Informe um valor")
            }

        }


    }

    // Outra forma de criar função para o botão
    fun limparValores(view: View){
        val  resultado = findViewById<TextView>(R.id.txtResultado)
        val input = findViewById<TextView>(R.id.edIdade)

        resultado.setText("")
        input.setText("")
    }

}