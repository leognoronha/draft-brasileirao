package com.example.draftbrasileirao

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TeamSummaryActivity : AppCompatActivity() {

    private lateinit var buttonDetailsFragment: ButtonDetailsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_summary)

        val tvPE: TextView = findViewById(R.id.pe)
        val tvATA: TextView = findViewById(R.id.ata)
        val tvPD: TextView = findViewById(R.id.pd)
        val tvMC1: TextView = findViewById(R.id.mc1)
        val tvVOL: TextView = findViewById(R.id.vol)
        val tvMC2: TextView = findViewById(R.id.mc2)
        val tvLE: TextView = findViewById(R.id.le)
        val tvZAG1: TextView = findViewById(R.id.zag1)
        val tvZAG2: TextView = findViewById(R.id.zag2)
        val tvLD: TextView = findViewById(R.id.ld)
        val tvGL: TextView = findViewById(R.id.gl)

        val tvPEName: TextView = findViewById(R.id.pe_name)
        val tvATAName: TextView = findViewById(R.id.ata_name)
        val tvPDName: TextView = findViewById(R.id.pd_name)
        val tvMC1Name: TextView = findViewById(R.id.mc1_name)
        val tvVOLName: TextView = findViewById(R.id.vol_name)
        val tvMC2Name: TextView = findViewById(R.id.mc2_name)
        val tvLEName: TextView = findViewById(R.id.le_name)
        val tvZAG1Name: TextView = findViewById(R.id.zag1_name)
        val tvZAG2Name: TextView = findViewById(R.id.zag2_name)
        val tvLDName: TextView = findViewById(R.id.ld_name)
        val tvGLName: TextView = findViewById(R.id.gl_name)

        val selectedPlayers = intent.getSerializableExtra("selectedPlayers") as? HashMap<String, String>

        // Verificar se os jogadores foram recebidos e exibir nas respectivas posições
        if (selectedPlayers != null) {
            tvGLName.text = selectedPlayers["GL"] ?: "GL"
            tvLDName.text = selectedPlayers["LD"] ?: "LD"
            tvZAG1Name.text = selectedPlayers["ZAG1"] ?: "ZAG1"
            tvZAG2Name.text = selectedPlayers["ZAG2"] ?: "ZAG2"
            tvLEName.text = selectedPlayers["LE"] ?: "LE"
            tvVOLName.text = selectedPlayers["VOL"] ?: "VOL"
            tvMC1Name.text = selectedPlayers["MC1"] ?: "MC1"
            tvMC2Name.text = selectedPlayers["MC2"] ?: "MC2"
            tvPDName.text = selectedPlayers["PD"] ?: "PD"
            tvATAName.text = selectedPlayers["ATA"] ?: "ATA"
            tvPEName.text = selectedPlayers["PE"] ?: "PE"
        }

        buttonDetailsFragment = supportFragmentManager.findFragmentById(R.id.buttonDetailsFragment) as ButtonDetailsFragment

        buttonDetailsFragment.setOnBackButtonClickListener {
            finish()
        }

        buttonDetailsFragment.setOnNextButtonClickListener {
            val intent = Intent(this, FinalizationActivity::class.java)
            startActivity(intent)
        }
    }
}
