package com.example.draftbrasileirao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ButtonDetailsFragment : Fragment() {

    private var onBackButtonClick: (() -> Unit)? = null
    private var onNextButtonClick: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buttons_details, container, false)

        val btnBack: Button = view.findViewById(R.id.btnBack)
        val btnNext: Button = view.findViewById(R.id.btnNext)

        btnBack.setOnClickListener {
            onBackButtonClick?.invoke() ?: activity?.finish()
        }

        btnNext.setOnClickListener {
            onNextButtonClick?.invoke()
        }

        return view
    }

    fun setOnBackButtonClickListener(callback: () -> Unit) {
        onBackButtonClick = callback
    }

    fun setOnNextButtonClickListener(callback: () -> Unit) {
        onNextButtonClick = callback
    }
}
