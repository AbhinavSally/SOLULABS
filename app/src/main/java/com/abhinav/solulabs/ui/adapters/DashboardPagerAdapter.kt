package com.abhinav.solulabs.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.abhinav.solulabs.ui.fragments.HomeFragment
import com.abhinav.solulabs.ui.fragments.WishlistFragment


class DashboardPagerAdapter(
    fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> return HomeFragment()
            1 -> return WishlistFragment()
            2 -> return WishlistFragment()
            3 -> return WishlistFragment()
            4 -> return WishlistFragment()
            else -> HomeFragment()
        }
    }

}