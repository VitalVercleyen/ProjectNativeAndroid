package vercleyen.vital.fosapp.Fragments

import android.app.Dialog
import android.content.Context
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_presence_list.view.*
import org.w3c.dom.Text
import vercleyen.vital.fosapp.Adapters.ScoutsKidAdapter
import vercleyen.vital.fosapp.Domain.Aanwezigheid
import vercleyen.vital.fosapp.Domain.DummyDataSuplier
import vercleyen.vital.fosapp.Domain.ScoutsKid

import vercleyen.vital.fosapp.R


class PresenceListFragment : Fragment() {


    private lateinit var aanwezigheid : Aanwezigheid
    private var searchBox: EditText? = null
    private var filteredAanw : Aanwezigheid = DummyDataSuplier().AanwezigheidData()
    private var myDialog : Dialog? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView =  inflater.inflate(R.layout.fragment_presence_list, container, false)
        aanwezigheid = DummyDataSuplier().AanwezigheidData()
        myDialog = Dialog(this.context)
        rootView.tv_Datum.setText(aanwezigheid.Date)
        rootView.rv_scoutsKidLijst.layoutManager = LinearLayoutManager(this.context)
        rootView.rv_scoutsKidLijst.adapter = ScoutsKidAdapter(aanwezigheid.Kids!!)
        rootView.btn_voegToe.setOnClickListener { showPopUp(rootView) }
        searchBox = rootView.et_search


        setFilterList(searchBox!!, rootView)
        return rootView
    }

    private fun showPopUp(view : View){
        var boy : ImageView? = null
        var girl : ImageView? = null
        var name : EditText? = null
        myDialog!!.setContentView(R.layout.add_kid_popup)
        name =  myDialog!!.findViewById(R.id.et_name)
        boy = myDialog!!.findViewById(R.id.iv_boy) as ImageView
        girl = myDialog!!.findViewById(R.id.iv_girl) as ImageView
        boy.setOnClickListener{
            voegKidToe(view, name!!.text.toString() ,true)
            myDialog!!.dismiss()
        }
        girl.setOnClickListener{
            voegKidToe(view, name!!.text.toString(), false)
            myDialog!!.dismiss()
        }


        myDialog!!.show()
    }

    private fun voegKidToe(view: View, name :String,  isBoy : Boolean){

        aanwezigheid.voegToe(name, isBoy)
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
