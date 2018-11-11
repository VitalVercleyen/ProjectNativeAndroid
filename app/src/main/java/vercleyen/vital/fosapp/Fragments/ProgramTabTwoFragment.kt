package vercleyen.vital.fosapp.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_program.*
import kotlinx.android.synthetic.main.fragment_program.view.*
import kotlinx.android.synthetic.main.fragment_program_tab_two.view.*
import vercleyen.vital.fosapp.Activities.MainActivity

import vercleyen.vital.fosapp.R


class ProgramTabTwoFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootview =  inflater.inflate(R.layout.fragment_program_tab_two, container, false)
        wijzigView(rootview)
        setupKeyboardHide(rootview.et_beschr)
        setupKeyboardHide(rootview.et_benodigdheden)
        return rootview
    }

    private fun setupKeyboardHide(editText : EditText){
        editText.setOnFocusChangeListener{v, hasFocus ->
            if(!hasFocus){
                (activity as MainActivity).hideKeyboard(v)
            }
        }
    }

    private fun opslaanView(view: View){
        (activity as MainActivity).showToast(this.context!!, "wijzigen enabled")
        view.et_beschr.isEnabled = true
        view.et_benodigdheden.isEnabled = true
        view.btn_wijzig.setText("opslaan")
        view.btn_wijzig.setOnClickListener {
            wijzigView(view)
            (activity as MainActivity).showToast(this.context!!, "opgeslagen")
        }
    }

    private fun wijzigView(view: View){
        view.et_benodigdheden.isEnabled = false
        view.et_beschr.isEnabled = false
        view.btn_wijzig.setText("wijzig")
        view.btn_wijzig.setOnClickListener { opslaanView(view)}
    }



}
