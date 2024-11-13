package com.example.draftbrasileirao

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class FormationActivity : AppCompatActivity() {

    private lateinit var btnChooseFormation: Button
    private lateinit var tvSelectedFormation: TextView
    private lateinit var buttonDetailsFragment: ButtonDetailsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formation)

        btnChooseFormation = findViewById(R.id.btnChooseFormation)
        tvSelectedFormation = findViewById(R.id.tvSelectedFormation)

        btnChooseFormation.setOnClickListener {
            showFormationDialog(tvSelectedFormation)
        }

        buttonDetailsFragment = supportFragmentManager.findFragmentById(R.id.buttonDetailsFragment) as ButtonDetailsFragment

        buttonDetailsFragment.setOnBackButtonClickListener {
            // Lógica para o botão "Voltar"
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonDetailsFragment.setOnNextButtonClickListener {
            val intent = Intent(this, PlayerSelectionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showFormationDialog(tvSelectedFormation: TextView) {
        val formations = arrayOf("4-3-3")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Escolha a formação")
        builder.setItems(formations) { _, which ->
            val selectedFormation = formations[which]
            tvSelectedFormation.text = "Formação selecionada: $selectedFormation"
        }
        builder.show()
    }
}
