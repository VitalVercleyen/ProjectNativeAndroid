package vercleyen.vital.fosapp.Activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import vercleyen.vital.fosapp.Fragments.PresenceListFragment
import vercleyen.vital.fosapp.Fragments.ProgramFragment
import vercleyen.vital.fosapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentContainer.id, PresenceListFragment())
        transaction.commit()
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






    //Function to change the fragment currently displayed
    fun changeFragment(fragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentContainer.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
