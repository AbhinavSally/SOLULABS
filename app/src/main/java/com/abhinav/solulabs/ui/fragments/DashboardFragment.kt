package com.abhinav.solulabs.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abhinav.solulabs.R
import com.abhinav.solulabs.databinding.FragmentDashbordBinding
import com.abhinav.solulabs.ui.adapters.DashboardPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dashbord.*

@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashbordBinding
    val mDashboardPagerAdapter by lazy { DashboardPagerAdapter(requireParentFragment()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDashbordBinding.inflate(layoutInflater)
        binding.vpDashboard.adapter=mDashboardPagerAdapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        attachTabs()
        vpDashboard.isUserInputEnabled = false
    }

    private fun attachTabs() {

        //setting tab layout
        val tabLayoutMediator =
            TabLayoutMediator(
                tlDashboard, vpDashboard
            ) { tab, position ->
                when (position) {
                    0 -> {
                        tab.setIcon(R.drawable.home_sel)
                        tab.setText("Home")
                    }
                    1 -> {
                        tab.setIcon(R.drawable.wishlist_sel)
                        tab.setText("Wishlist")
                    }
                    2 -> {
                        tab.setIcon(R.drawable.scan_sel)
                        tab.setText("Scan")
                    }
                    3 -> {
                        tab.setIcon(R.drawable.collection_sel)
                        tab.setText("Collection")
                    }
                    4 -> {
                        tab.setIcon(R.drawable.profile_sel)
                        tab.setText("Profile")
                    }

                }
            }
        tabLayoutMediator.attach()
    }
}