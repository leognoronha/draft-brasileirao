package com.example.draftbrasileirao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FinalizationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finalization)

        val etTeamName: EditText = findViewById(R.id.etTeamName)
        val btnSave: Button = findViewById(R.id.btnSave)
        val btnRestartDraft: Button = findViewById(R.id.btnRestartDraft)

        btnSave.setOnClickListener {
            // Lógica para salvar o time
            val teamName = etTeamName.text.toString().trim()

            if (teamName.isNotEmpty()) {

                // Exibir uma mensagem de confirmação ao salvar
                Toast.makeText(this, "Time '$teamName' salvo com sucesso!", Toast.LENGTH_SHORT).show()

                // Opcional: Limpar o campo de texto após salvar
                etTeamName.text.clear()

                // Opcional: Desabilitar o botão Salvar após salvar
                btnSave.isEnabled = false
            } else {
                // Exibir uma mensagem de erro se o nome do time estiver vazio
                Toast.makeText(this, "Por favor, insira um nome para o time.", Toast.LENGTH_SHORT).show()
            }
        }

        btnRestartDraft.setOnClickListener {

            // Redirecionar para a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
