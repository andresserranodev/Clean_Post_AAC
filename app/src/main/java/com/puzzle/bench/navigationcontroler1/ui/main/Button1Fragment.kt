package com.puzzle.bench.navigationcontroler1.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.button1_fragment.*
import com.google.android.material.snackbar.Snackbar
import com.puzzle.bench.navigationcontroler1.R


class Button1Fragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = Button1FragmentArgs.fromBundle(it)
            textView1_1.text = "Hello ${safeArgs.name}"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.button1_fragment, container, false)
    }

    companion object {
        fun newIntance() = Button1Fragment()
    }
}