package vercleyen.vital.fosapp.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_presence_list.view.*
import vercleyen.vital.fosapp.Adapters.ScoutsKidAdapter
import vercleyen.vital.fosapp.Domain.Aanwezigheid
import vercleyen.vital.fosapp.Domain.DummyDataSuplier
import vercleyen.vital.fosapp.Domain.ScoutsKid

import vercleyen.vital.fosapp.R


class PresenceListFragment : Fragment() {


    private lateinit var aanwezigheid : Aanwezigheid

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView =  inflater.inflate(R.layout.fragment_presence_list, container, false)
        aanwezigheid = DummyDataSuplier().AanwezigheidData()
        rootView.tv_Datum.setText(aanwezigheid.Date)
        rootView.rv_scoutsKidLijst.layoutManager = LinearLayoutManager(this.context)
        rootView.rv_scoutsKidLijst.adapter = ScoutsKidAdapter(aanwezigheid.Kids!!)

        return rootView
    }


}
