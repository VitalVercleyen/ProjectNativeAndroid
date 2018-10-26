package vercleyen.vital.fosapp.Activities

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import vercleyen.vital.fosapp.R

import kotlinx.android.synthetic.main.activity_init.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_name_screen.*
import kotlinx.android.synthetic.main.fragment_tak.*
import vercleyen.vital.fosapp.Fragments.NameFragment
import vercleyen.vital.fosapp.Fragments.PresenceListFragment
import vercleyen.vital.fosapp.Fragments.TakFragment
import vercleyen.vital.fosapp.SharedPreferences.SharedPreferencesClass

class InitActivity : AppCompatActivity() {

    private var sharedPreferences : SharedPreferencesClass? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentContainer.id, NameFragment())
        transaction.commit()

        sharedPreferences = SharedPreferencesClass(this)
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

        changeActivity()
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
