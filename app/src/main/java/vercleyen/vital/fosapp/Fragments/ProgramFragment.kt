package vercleyen.vital.fosapp.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_program.view.*

import vercleyen.vital.fosapp.R

class ProgramFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootview = inflater.inflate(R.layout.fragment_program, container, false)
        rootview.pdfView.fromAsset("pdf-sample.pdf").load()
        return rootview
    }

}
