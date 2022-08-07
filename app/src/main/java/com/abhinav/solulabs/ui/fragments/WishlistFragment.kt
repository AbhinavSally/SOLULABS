package com.abhinav.solulabs.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abhinav.solulabs.R
import com.abhinav.solulabs.databinding.FragmentDashbordBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_dashbord.*

@AndroidEntryPoint
class WishlistFragment : Fragment() {
    private lateinit var binding: FragmentDashbordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDashbordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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
                    }
//                    1 -> {
//                        tab.setIcon(R.drawable.contactus_sel)
//                    }
                    1 -> {
//                        tab.setText("Change \n Car")
                    }
//                    3 -> {
//                        tab.setIcon(R.drawable.cart_sel)
//                    }
                    2 -> {
                        tab.setIcon(R.drawable.profile_sel)
                    }

                }
            }
        tabLayoutMediator.attach()
    }
}