package vercleyen.vital.fosapp.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_presence_list.view.*
import vercleyen.vital.fosapp.Adapters.ScoutsKidAdapter
import vercleyen.vital.fosapp.Domain.Aanwezigheid
import vercleyen.vital.fosapp.Domain.DummyDataSuplier
import vercleyen.vital.fosapp.Domain.ScoutsKid

import vercleyen.vital.fosapp.R


class PresenceListFragment : Fragment() {


    private lateinit var aanwezigheid : Aanwezigheid
    private var searchBox: EditText? = null
    private var filteredAanw : Aanwezigheid = DummyDataSuplier().AanwezigheidData()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView =  inflater.inflate(R.layout.fragment_presence_list, container, false)
        aanwezigheid = DummyDataSuplier().AanwezigheidData()
        rootView.tv_Datum.setText(aanwezigheid.Date)
        rootView.rv_scoutsKidLijst.layoutManager = LinearLayoutManager(this.context)
        rootView.rv_scoutsKidLijst.adapter = ScoutsKidAdapter(aanwezigheid.Kids!!)
        rootView.btn_voegToe.setOnClickListener { voegKidToe(rootView) }
        searchBox = rootView.et_search


        setFilterList(searchBox!!, rootView)
        return rootView
    }

    private fun voegKidToe(view: View){
        aanwezigheid.voegToe("kindje")
        refresh(view, aanwezigheid.Kids!!)
    }

    private fun setFilterList(searchBox : EditText, rootView : View){

        searchBox.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(edited: Editable?) { }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(edited: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filteredAanw.Kids!!.clear()
                for (i in 0 until aanwezigheid.Kids!!.size) {
                    if (searchBox.text.length <= aanwezigheid.Kids!![i].Name.length) {
                        if (aanwezigheid.Kids!![i].Name.toLowerCase().trim().contains(
                                        searchBox.text.toString().toLowerCase().trim())) {
                            filteredAanw.Kids!!.add(aanwezigheid.Kids!![i])
                        }
                    }
                }
               refresh(rootView, filteredAanw.Kids!!)
            }
        })
    }

    private fun refresh(view : View, list : ArrayList<ScoutsKid>){

        view.rv_scoutsKidLijst.layoutManager = LinearLayoutManager(this.context)
        view.rv_scoutsKidLijst.adapter = ScoutsKidAdapter(list)
    }


}
