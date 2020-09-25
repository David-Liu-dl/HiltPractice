package com.practice.hiltpractice

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.practice.hiltpractice.presentation.byfactory.LandingFactoryFragment
import com.practice.hiltpractice.presentation.byviewmodel.LandingVMFragment

class OptionsFragment : Fragment(R.layout.fragment_options) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_viewmodels).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, LandingVMFragment.instance("HiltPractice-by-viewModels"))
                .addToBackStack(null)
                .commit()
        }

        view.findViewById<Button>(R.id.btn_viewmodelfactory).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, LandingFactoryFragment.instance("HiltPractice-by-ViewModelFactory"))
                .addToBackStack(null)
                .commit()
        }
    }
}