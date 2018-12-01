package com.envelope.pickyapp.ui.newshome

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomeViewpager(fm:FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {

    when(position){
        0->{
            return NewsHomeFragment.newInstance()
        }
        1->{
            return PinnedItemFragment.newInstance()
        }
        2->{
            return LiveNewsFragment.newInstance()
        }
        else->{
            return NewsHomeFragment.newInstance()
        }
        }
    }

    override fun getCount() = 3

}