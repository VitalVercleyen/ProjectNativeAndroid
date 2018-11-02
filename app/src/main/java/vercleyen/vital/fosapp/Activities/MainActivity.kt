package vercleyen.vital.fosapp.Activities

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import vercleyen.vital.fosapp.Fragments.PresenceListFragment
import vercleyen.vital.fosapp.Fragments.ProgramFragment
import vercleyen.vital.fosapp.R
import vercleyen.vital.fosapp.SharedPreferences.SharedPreferencesClass

class MainActivity : AppCompatActivity() {

    private var sharedPreferences : SharedPreferencesClass? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentContainer.id, PresenceListFragment())
        transaction.commit()
        sharedPreferences = SharedPreferencesClass(this)
        setTitle(sharedPreferences!!.getTotem())
        navigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)
    }

    private val OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_home -> {
                changeFragment(PresenceListFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                changeFragment(ProgramFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    fun showToast(context: Context, message : String) {
        context.toast(message)
    }

    fun getTak(){
        sharedPreferences!!.getTak()
    }



    //Function to change the fragment currently displayed
    fun changeFragment(fragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentContainer.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
