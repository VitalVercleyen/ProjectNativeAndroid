package vercleyen.vital.fosapp.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_name_screen.view.*
import vercleyen.vital.fosapp.Activities.MainActivity

import vercleyen.vital.fosapp.R

class NameFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_name_screen, container, false)

        rootView.et_naam.setOnFocusChangeListener{v, hasFocus ->
            if(!hasFocus){
                (activity as MainActivity).hideKeyboard(v)
            }
        }



        return rootView

    }








}
