package com.puzzle.bench.navigationcontroler1.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.puzzle.bench.navigationcontroler1.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        button.setOnClickListener {
            view?.let {
                val action = MainFragmentDirections.actionMainFragmentToButton1Fragment()
                action.name = "Test"
                Navigation.findNavController(
                    it
                ).navigate(action)
            }
        }
        button2.setOnClickListener {
            view?.let {
                Navigation.findNavController(
                    it
                ).navigate(R.id.button2Fragment)
            }
        }
    }

}
