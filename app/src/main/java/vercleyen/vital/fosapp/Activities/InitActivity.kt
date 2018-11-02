package vercleyen.vital.fosapp.Activities

import android.os.Bundle
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import vercleyen.vital.fosapp.R

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_name_screen.*
import kotlinx.android.synthetic.main.fragment_tak.*
import vercleyen.vital.fosapp.Fragments.NameFragment
import vercleyen.vital.fosapp.Fragments.PresenceListFragment
import vercleyen.vital.fosapp.Fragments.TakFragment
import vercleyen.vital.fosapp.SharedPreferences.SharedPreferencesClass
import android.graphics.drawable.ColorDrawable
import android.widget.Button
import android.widget.TextView



class InitActivity : AppCompatActivity() {

    private var sharedPreferences : SharedPreferencesClass? = null
    private var myDialog : Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentContainer.id, NameFragment())
        transaction.commit()
        myDialog = Dialog(this)
        setTitle("")
        sharedPreferences = SharedPreferencesClass(this)
        if(!sharedPreferences!!.getTotem().equals(null)){
            changeActivity()
        }
    }


    fun onVolgendeClicked(view: View){
        val totem = et_naam.text
        sharedPreferences!!.setTotem(totem.toString())
        changeFragment(TakFragment())
    }

    fun chooseTak(rootView: View){
        var tak = ""
        when (rootView.id) {
            btn_bevers.id -> {
                tak = "Bevers"
            }
            btn_welpen.id -> {
                tak = "Welpen"
            }
            btn_wolven.id -> {
                tak = "Wolven"
            }
            btn_jvjg.id -> {
                tak = "Jonge Verkenners & Jonge Gidsen"

            }
            btn_vg.id -> {
                tak = "Verkenners & Gidsen"
            }
            btn_seniors.id -> {
                tak = "Seniors"
            }
        }
        sharedPreferences!!.setTak(tak)


        ShowPopup(rootView)


    }

    fun ShowPopup(v: View) {
        val btnFollow : Button
        val txtTitle : TextView
        val txtDial: TextView
        myDialog!!.setContentView(R.layout.popup)
        txtTitle = myDialog!!.findViewById(R.id.txt_title) as TextView
        txtDial = myDialog!!.findViewById(R.id.txt_dial) as TextView
        btnFollow = myDialog!!.findViewById(R.id.btnfollow) as Button
        txtTitle.text = "Dag " + sharedPreferences!!.getTotem() + "!"
        txtDial.text = getString(R.string.popupDial)
        btnFollow.setOnClickListener {
            myDialog!!.dismiss()
            changeActivity()
        }
        myDialog!!.show()
    }

    fun changeFragment(fragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentContainer.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    fun changeActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
