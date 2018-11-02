package vercleyen.vital.fosapp.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_presence_list.view.*
import kotlinx.android.synthetic.main.fragment_program_tab_one.view.*
import vercleyen.vital.fosapp.Activities.MainActivity
import vercleyen.vital.fosapp.Adapters.ProgrammaAdapter
import vercleyen.vital.fosapp.Adapters.ScoutsKidAdapter
import vercleyen.vital.fosapp.Domain.Activiteit
import vercleyen.vital.fosapp.Domain.DummyDataSuplier

import vercleyen.vital.fosapp.R


class ProgramTabOneFragment : Fragment() {

    private var fileUrl : String? = null
    private var activiteiten : ArrayList<Activiteit> = DummyDataSuplier().ActiviteitData()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootview =  inflater.inflate(R.layout.fragment_program_tab_one, container, false)
        rootview.tv_tak.setText("Programma" + (activity as MainActivity).getTak())
        rootview.rv_programma.layoutManager = LinearLayoutManager(this.context)
        rootview.rv_programma.adapter = ProgrammaAdapter(activiteiten)


        return rootview
    }


}
