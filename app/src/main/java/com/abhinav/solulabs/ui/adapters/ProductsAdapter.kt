package com.abhinav.solulabs.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.solulabs.data.models.response.res
import com.abhinav.solulabs.databinding.ProductCellBinding
import com.abhinav.solulabs.utils.ViewUtils.load


class ProductsAdapter(
    var context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mLayoutInflater by lazy { LayoutInflater.from(context) }
    private var productsList = arrayListOf<res>()
    lateinit var binding: ProductCellBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        binding = ProductCellBinding.inflate(mLayoutInflater, parent, false)
        return UserViewHolder(binding.root)

    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserViewHolder).bindUser(productsList[position])
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindUser(product: res) {
            //setting data
            with(product)
            {
                try {
                    binding.ivProduct.load(this.pictures.front.url)
                } catch (e: Exception) {
                }
            }
            try {
                binding.tvProduct.text = product.name
            } catch (e: Exception) {
            }
        }


}

fun setProducts(data: ArrayList<res>) {
    productsList.clear()
    productsList = data
    notifyDataSetChanged()
}

}
