package vercleyen.vital.fosapp.Activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import vercleyen.vital.fosapp.Fragments.NameFragment
import vercleyen.vital.fosapp.Fragments.PresenceListFragment
import vercleyen.vital.fosapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(container.id, PresenceListFragment())
        transaction.commit()
        navigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)
    }

    private val OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var changeTo = Fragment()
        when (item.itemId) {

            R.id.navigation_home -> {
                changeTo = PresenceListFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        changeFragment(changeTo)
        false
    }





    //Function to change the fragment currently displayed
    fun changeFragment(fragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
