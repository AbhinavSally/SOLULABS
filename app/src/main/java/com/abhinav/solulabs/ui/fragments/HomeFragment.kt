package com.abhinav.solulabs.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.abhinav.solulabs.data.models.response.res
import com.abhinav.solulabs.databinding.FragmentHomeBinding
import com.abhinav.solulabs.ui.adapters.ProductsAdapter
import com.abhinav.solulabs.ui.viewmodels.ProductsViewModel
import com.abhinav.solulabs.utils.HelperUtils.showToast
import com.abhinav.solulabs.utils.LoadingScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    val mProductsAdapter by lazy { ProductsAdapter(requireContext()) }

    private  val viewModel: ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.item = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.getProducts()
        binding.rvProducts.adapter = mProductsAdapter
        viewModel.isLoading.observe(viewLifecycleOwner) {
            LoadingScreen.operateDialog(it, requireContext())
        }
        viewModel.isFailure.observe(viewLifecycleOwner) {
            it?.let {
                requireContext().showToast(it)
            }
        }
        viewModel.productsResponse.observe(viewLifecycleOwner) {
it.let {
    try {
            mProductsAdapter.setProducts(it.list)
        }catch (e:Exception)
    {requireContext().showToast(e.toString()+it)}}}
        return binding.root
    }

}