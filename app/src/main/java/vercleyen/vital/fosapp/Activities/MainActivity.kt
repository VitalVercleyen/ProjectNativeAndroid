package vercleyen.vital.fosapp.Activities

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import vercleyen.vital.fosapp.Fragments.AnnouncementFragment
import vercleyen.vital.fosapp.Fragments.PresenceListFragment
import vercleyen.vital.fosapp.Fragments.ProgramFragment
import vercleyen.vital.fosapp.R
import vercleyen.vital.fosapp.SharedPreferences.SharedPreferencesClass

class MainActivity : AppCompatActivity() {

    private var sharedPreferences : SharedPreferencesClass? = null
    private var myDialog : Dialog? = null
    private var logoMap = hashMapOf<String, Int>("Bever" to R.drawable.ic_beaver_head, "Welpen" to R.drawable.ic_animal_track, "Wolven" to R.drawable.ic_wolf, "JVJG" to R.drawable.ic_foot, "VG" to R.drawable.ic_man, "Seniors" to R.drawable.ic_manager, "Stam" to R.drawable.ic_trunk)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentContainer.id, PresenceListFragment())
        transaction.commit()
        myDialog = Dialog(this)
        sharedPreferences = SharedPreferencesClass(this)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(logoMap[sharedPreferences!!.getTak()]!!)
        supportActionBar!!.setDisplayUseLogoEnabled(true)


        setTitle(" " + sharedPreferences!!.getTotem())

        navigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar, menu)
        return true
    }

    fun changeSettings(mi : MenuItem){
        sharedPreferences!!.setFirstStart("2")
        val intent = Intent(this, InitActivity::class.java)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.tv_title ->{
                showSettingMenu()
            }

        }
        return true
    }

    private fun showSettingMenu(){
            myDialog!!.setContentView(R.layout.kid_setting_popup)
            val txtTitle = myDialog!!.findViewById(R.id.tv_title) as TextView
            val exit = myDialog!!.findViewById(R.id.tv_close) as TextView
            val portrait = myDialog!!.findViewById(R.id.iv_kid) as ImageView
            val btnNext = myDialog!!.findViewById(R.id.btn_nextTak) as Button
            val btnPrevious = myDialog!!.findViewById(R.id.btn_previousTak) as Button
            val btnEdit = myDialog!!.findViewById(R.id.btn_edit) as Button
            val btnDelete = myDialog!!.findViewById(R.id.btn_delete) as Button
            exit.setOnClickListener {
                myDialog!!.dismiss()
            }
            myDialog!!.show()

    }

    fun getNaam() : String {
        return sharedPreferences!!.getTotem()
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
                changeFragment(AnnouncementFragment())
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

    fun getTak() : String{
        return sharedPreferences!!.getTak()
    }





    //Function to change the fragment currently displayed
    fun changeFragment(fragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentContainer.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager!!.hideSoftInputFromWindow(view.windowToken, 0)
    }


}
