package vercleyen.vital.fosapp.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_program.view.*

import vercleyen.vital.fosapp.R
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v4.view.ViewPager
import vercleyen.vital.fosapp.Adapters.SimplePagerAdapter


class ProgramFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_program, container, false)
        var tabLayout = rootview.tabs as TabLayout

        tabLayout.addTab(tabLayout.newTab(), 0)
        tabLayout.addTab(tabLayout.newTab(), 1)

        val viewPager = rootview.viewpager as ViewPager
        val mLayoutManager = LinearLayoutManager(activity)
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        viewPager.adapter = SimplePagerAdapter(fragmentManager!!, tabLayout.tabCount)
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.setText("Programma")
        tabLayout.getTabAt(1)!!.setText("Activiteit")
        tabLayout.tabMode = TabLayout.MODE_FIXED
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        return rootview

    }
}
