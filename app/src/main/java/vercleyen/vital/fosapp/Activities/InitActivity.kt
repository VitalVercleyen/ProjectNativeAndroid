package vercleyen.vital.fosapp.Activities

import android.app.Activity
import android.os.Bundle
import android.app.Dialog
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import vercleyen.vital.fosapp.R

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_name_screen.*
import kotlinx.android.synthetic.main.fragment_tak.*
import vercleyen.vital.fosapp.Fragments.NameFragment
import vercleyen.vital.fosapp.Fragments.TakFragment
import vercleyen.vital.fosapp.SharedPreferences.SharedPreferencesClass
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
     /*   if(sharedPreferences!!.getFirstStart() == "1"){
           changeActivity()
        }*/
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
                tak = "JVJG"

            }
            btn_vg.id -> {
                tak = "VG"
            }
            btn_seniors.id -> {
                tak = "Seniors"
            }
            btn_stam.id -> {
                tak = "Stam"
            }
        }
        sharedPreferences!!.setTak(tak)

        if(sharedPreferences!!.getFirstStart() == "2"){
            changeActivity()
        }
        ShowPopup(rootView)


    }

    fun ShowPopup(v: View) {
        val btnFollow : Button
        val txtTitle : TextView
        val txtDial: TextView
        myDialog!!.setContentView(R.layout.init_popup)
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
        sharedPreferences!!.setFirstStart("1")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
