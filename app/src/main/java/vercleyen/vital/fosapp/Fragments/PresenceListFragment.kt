package vercleyen.vital.fosapp.Fragments

import android.app.Dialog
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
import vercleyen.vital.fosapp.Adapters.ScoutsKidAdapter
import vercleyen.vital.fosapp.Domain.Aanwezigheid
import vercleyen.vital.fosapp.Domain.DummyDataSuplier
import vercleyen.vital.fosapp.Domain.ScoutsKid

import vercleyen.vital.fosapp.R
import android.util.DisplayMetrics
import vercleyen.vital.fosapp.Activities.MainActivity
import android.app.Activity
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.fragment_name_screen.view.*


class PresenceListFragment : Fragment() {


    private lateinit var aanwezigheid : Aanwezigheid
    private var aanwezigKids : ArrayList<ScoutsKid> = ArrayList()
    private var vieruurtjeKids : ArrayList<ScoutsKid> = ArrayList()
    private var searchBox: EditText? = null
    private var filteredAanw : Aanwezigheid = DummyDataSuplier().AanwezigheidData()
    private var myDialog : Dialog? = null
    private var genderMap : HashMap<String, Int> = hashMapOf("boy" to R.drawable.boy, "girl" to R.drawable.girl,"x" to R.drawable.xgender)




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView =  inflater.inflate(R.layout.fragment_presence_list, container, false)
        aanwezigheid = DummyDataSuplier().AanwezigheidData()
        myDialog = Dialog(this.context)
        refresh(rootView, aanwezigheid.Kids!!)
        rootView.btn_save.setOnClickListener{opslaan(rootView.tv_aantal)}
        rootView.btn_voegToe.setOnClickListener { voegKidToePopUp(rootView) }
        searchBox = rootView.et_search
        searchBox!!.setOnFocusChangeListener { v, hasFocus ->  }
        setFilterList(searchBox!!, rootView)
        setupKeyboardHide(rootView.et_search)
        (activity as MainActivity).hideKeyboard(rootView)
        return rootView
    }

    private fun opslaan(aantal : TextView){
        aantal.setText(aanwezigKids.size.toString())
        aantal.setBackgroundResource(R.drawable.popup_border)
    }

    private fun setupKeyboardHide(editText : EditText){
        editText.setOnFocusChangeListener{v, hasFocus ->
            if(!hasFocus){
                (activity as MainActivity).hideKeyboard(v)
            }
        }
    }

    private fun scoutsKidClickedPopUp(scoutsKid : ScoutsKid){
        myDialog!!.setContentView(R.layout.kid_setting_popup)
        val txtTitle = myDialog!!.findViewById(R.id.tv_title) as TextView
        val exit = myDialog!!.findViewById(R.id.tv_close) as TextView
        val portrait = myDialog!!.findViewById(R.id.iv_kid) as ImageView
        val btnNext = myDialog!!.findViewById(R.id.btn_nextTak) as Button
        val btnPrevious = myDialog!!.findViewById(R.id.btn_previousTak) as Button
        val btnEdit = myDialog!!.findViewById(R.id.btn_edit) as Button
        val btnDelete = myDialog!!.findViewById(R.id.btn_delete) as Button
        txtTitle.text = scoutsKid.Name
        portrait.setImageResource(genderMap[scoutsKid.gender]!!)
        exit.setOnClickListener {
            myDialog!!.dismiss()
        }
        myDialog!!.show()
    }


    private fun voegKidToePopUp(view : View){

        myDialog!!.setContentView(R.layout.add_kid_popup)
        val name =  myDialog!!.findViewById(R.id.et_ActName) as EditText
        val boy = myDialog!!.findViewById(R.id.iv_boy) as ImageView
        val girl = myDialog!!.findViewById(R.id.iv_girl) as ImageView
        val x = myDialog!!.findViewById(R.id.iv_x) as ImageView
        val exit = myDialog!!.findViewById(R.id.tv_close) as TextView
        boy.setOnClickListener{
            voegKidToe(view, name.text.toString() ,"boy")
            myDialog!!.dismiss()
        }
        girl.setOnClickListener{
            voegKidToe(view, name.text.toString(), "girl")
            myDialog!!.dismiss()
        }
        x.setOnClickListener {
            voegKidToe(view, name.text.toString(), "x")
            myDialog!!.dismiss()
        }
        exit.setOnClickListener {
            myDialog!!.dismiss()
        }

        myDialog!!.show()
    }

    private fun voegKidToe(view: View, name :String,  gender : String){
        aanwezigheid.voegToe(name, gender, (activity as MainActivity).getTak())
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


    private fun scoutsKidCheckBoxClicked(list : ArrayList<ScoutsKid>, scoutsKid: ScoutsKid){
        if(list.contains(scoutsKid)){
            list.remove(scoutsKid)
        } else {
            list.add(scoutsKid)
        }

    }




    private fun refresh(view : View, list : ArrayList<ScoutsKid>){

        view.rv_scoutsKidLijst.layoutManager = LinearLayoutManager(this.context)
        val itemClickedListener : (ScoutsKid) -> Unit = {scoutsKid -> scoutsKidClickedPopUp(scoutsKid)}
        val aanwezigClickedListener : (ScoutsKid) -> Unit = {scoutsKid -> scoutsKidCheckBoxClicked(aanwezigKids, scoutsKid)}
        val vierUuClickedListener : (ScoutsKid) -> Unit = {scoutsKid -> scoutsKidCheckBoxClicked(vieruurtjeKids, scoutsKid)}
        view.rv_scoutsKidLijst.adapter = ScoutsKidAdapter(list,itemClickedListener, aanwezigClickedListener, vierUuClickedListener)
    }


}
