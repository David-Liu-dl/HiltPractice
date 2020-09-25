package com.practice.hiltpractice.presentation.byviewmodel

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.practice.hiltpractice.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingVMFragment : Fragment(R.layout.fragment_landing) {
    companion object {
        const val PASSED_IN_INFO = "passed_in_info"
        const val RETAINED_INFO = "retained_info"

        fun instance(tracking: String) = LandingVMFragment().apply {
            arguments = Bundle().apply {
                putString(PASSED_IN_INFO, tracking)
            }
        }
    }

    private val viewModel: LandingVMViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.hostName = arguments?.getString(PASSED_IN_INFO) ?: "null"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.text_view_info).text = information()
        view.findViewById<TextView>(R.id.text_view_bundle).text = bundle()
        view.findViewById<EditText>(R.id.edit_text_bundle)
            .setOnEditorActionListener { v, actionId, event ->
                if (event?.keyCode == KeyEvent.KEYCODE_ENTER || actionId == EditorInfo.IME_ACTION_DONE) {
                    viewModel.saveBundle(v.text.toString())
                }

                false
            }
    }

    private fun information() =
        "${viewModel.loadContent()} \n Fragment-ID: ${System.identityHashCode(this)}"

    private fun bundle() = "Bundle: ${viewModel.loadBundle() ?: "null"}"
}
