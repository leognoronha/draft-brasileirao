package com.example.draftbrasileirao

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PlayerSelectionActivity : AppCompatActivity() {

    private val playersByPosition = mapOf(
        "GL" to arrayOf("CÁSSIO", "WEVERTON", "HUGO SOUZA"),
        "LD" to arrayOf("FAGNER", "MARCOS ROCHA", "WILLIAM"),
        "ZAG1" to arrayOf("DAVID LUIZ", "LYANCO", "GUSTAVO GOMEZ"),
        "ZAG2" to arrayOf("CACA", "THIAGO SILVA", "ARBOLEDA"),
        "LE" to arrayOf("ALEX SANDRO", "MARCELO", "ARANA"),
        "VOL" to arrayOf("GERSON", "MATHEUS HENRIQUE", "MARLON FREITAS"),
        "MC1" to arrayOf("GARRO", "ARRASCAETA", "ALMADA"),
        "MC2" to arrayOf("RAFAEL VEIGA", "ZICO", "GANSO"),
        "PD" to arrayOf("ESTEVÃO", "LUIZ HENRIQUE", "LUCAS"),
        "ATA" to arrayOf("PEDRO", "MEMPHIS DEPAY", "HULK"),
        "PE" to arrayOf("NEYMAR", "EVERTON", "SOTELDO")
    )

    private lateinit var buttonDetailsFragment: ButtonDetailsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_selection)

        val tvSelectedGL: TextView = findViewById(R.id.tvSelectedGL)
        val tvSelectedLD: TextView = findViewById(R.id.tvSelectedLD)
        val tvSelectedZAG1: TextView = findViewById(R.id.tvSelectedZAG1)
        val tvSelectedZAG2: TextView = findViewById(R.id.tvSelectedZAG2)
        val tvSelectedLE: TextView = findViewById(R.id.tvSelectedLE)
        val tvSelectedVOL: TextView = findViewById(R.id.tvSelectedVOL)
        val tvSelectedMC1: TextView = findViewById(R.id.tvSelectedMC1)
        val tvSelectedMC2: TextView = findViewById(R.id.tvSelectedMC2)
        val tvSelectedPD: TextView = findViewById(R.id.tvSelectedPD)
        val tvSelectedATA: TextView = findViewById(R.id.tvSelectedATA)
        val tvSelectedPE: TextView = findViewById(R.id.tvSelectedPE)

        val textViewMap = mapOf(
            "GL" to tvSelectedGL,
            "LD" to tvSelectedLD,
            "ZAG1" to tvSelectedZAG1,
            "ZAG2" to tvSelectedZAG2,
            "LE" to tvSelectedLE,
            "VOL" to tvSelectedVOL,
            "MC1" to tvSelectedMC1,
            "MC2" to tvSelectedMC2,
            "PD" to tvSelectedPD,
            "ATA" to tvSelectedATA,
            "PE" to tvSelectedPE
        )

        textViewMap.forEach { (position, textView) ->
            setupSelectionDialog(textView, position)
        }

        buttonDetailsFragment = supportFragmentManager.findFragmentById(R.id.buttonDetailsFragment) as ButtonDetailsFragment

        buttonDetailsFragment.setOnBackButtonClickListener {
            val intent = Intent(this, FormationActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonDetailsFragment.setOnNextButtonClickListener {
            val selectedPlayers = HashMap<String, String>()
            textViewMap.forEach { (position, textView) ->
                val playerName = textView.text.toString()
                if (playerName.isNotBlank() && playerName != "Selecionar jogador") {
                    selectedPlayers[position] = playerName
                } else {
                    selectedPlayers[position] = "Sem jogador"
                }
            }

            val intent = Intent(this, TeamSummaryActivity::class.java)
            intent.putExtra("selectedPlayers", selectedPlayers)
            startActivity(intent)
        }
    }

    private fun setupSelectionDialog(textView: TextView, position: String) {
        textView.setOnClickListener {
            val players = playersByPosition[position] ?: arrayOf()
            if (players.isNotEmpty()) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Escolha um jogador para $position")
                builder.setItems(players) { _, which ->
                    val selectedPlayer = players[which]
                    textView.text = selectedPlayer
                }
                builder.show()
            } else {
                textView.text = "Sem jogadores disponíveis"
            }
        }
    }
}
