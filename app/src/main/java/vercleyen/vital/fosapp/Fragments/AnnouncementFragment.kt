package vercleyen.vital.fosapp.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_announcement.view.*
import kotlinx.android.synthetic.main.fragment_presence_list.view.*
import vercleyen.vital.fosapp.Adapters.AankondigingAdapter
import vercleyen.vital.fosapp.Domain.Aankondiging
import vercleyen.vital.fosapp.Domain.DummyDataSuplier

import vercleyen.vital.fosapp.R


class AnnouncementFragment : Fragment() {

    val aankondigingen : ArrayList<Aankondiging> = DummyDataSuplier().AankondigingData()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_announcement, container, false)

        refresh(rootView,  aankondigingen)


        return rootView
    }

    private fun refresh(view : View, list : ArrayList<Aankondiging>){

        view.rv_aankondigingen.layoutManager = LinearLayoutManager(this.context)
        view.rv_aankondigingen.adapter = AankondigingAdapter(list)
    }
}
