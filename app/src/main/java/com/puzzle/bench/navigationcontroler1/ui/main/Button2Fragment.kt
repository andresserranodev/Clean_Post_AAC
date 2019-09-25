package com.puzzle.bench.navigationcontroler1.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.puzzle.bench.navigationcontroler1.R

class Button2Fragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.button2_fagment, container, false)
    }

    companion object {
        fun newIntance() = Button2Fragment()
    }
}