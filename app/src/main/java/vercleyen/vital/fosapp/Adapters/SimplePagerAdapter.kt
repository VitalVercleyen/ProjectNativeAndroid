package vercleyen.vital.fosapp.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import vercleyen.vital.fosapp.Fragments.ProgramTabOneFragment
import vercleyen.vital.fosapp.Fragments.ProgramTabTwoFragment

class SimplePagerAdapter(fm : FragmentManager, intNumOfTabs : Int) : FragmentStatePagerAdapter(fm){

    private var intNumOfTabs : Int = intNumOfTabs

    override fun getItem(position: Int): Fragment? {

        when (position) {
            0 -> return ProgramTabOneFragment()
            1 -> return ProgramTabTwoFragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return intNumOfTabs
    }

}