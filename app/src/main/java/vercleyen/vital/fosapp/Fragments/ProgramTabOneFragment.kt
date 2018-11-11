package vercleyen.vital.fosapp.Fragments

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
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
    private var myDialog : Dialog? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootview =  inflater.inflate(R.layout.fragment_program_tab_one, container, false)
        rootview.rv_programma.layoutManager = LinearLayoutManager(this.context)
        rootview.rv_programma.adapter = ProgrammaAdapter(activiteiten) { activiteit -> activiteitClickedPopUp()}
        myDialog = Dialog(this.context)

        return rootview
    }

    private fun activiteitClickedPopUp(){
        myDialog!!.setContentView(R.layout.edit_activiteit_popup)
        val btnSave = myDialog!!.findViewById(R.id.btn_save) as Button
        val exit = myDialog!!.findViewById(R.id.tv_close) as TextView
        val date = myDialog!!.findViewById(R.id.et_date) as EditText
        val name = myDialog!!.findViewById(R.id.et_ActName) as EditText
        exit.setOnClickListener {
            myDialog!!.dismiss()
        }
        myDialog!!.show()
    }




}
