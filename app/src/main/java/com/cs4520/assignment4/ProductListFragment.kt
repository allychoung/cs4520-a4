package com.cs4520.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs4520.assignment4.databinding.ProductListFragmentBinding

class ProductListFragment : Fragment() {
    private var _binding: ProductListFragmentBinding? = null

    private val binding get() = _binding!!

//    private fun processProduct(p: Product): Product {
//        val date = if (p[2] != null) p[2].toString() else null
//        if (p[1].toString() == "Equipment") {
//            return Equipment(p[0].toString(), date, p[3].toString().toInt())
//        } else if (p[1].toString() == "Food") {
//            return Food(p[0].toString(), date, p[3].toString().toInt())
//        } else {
//            throw IllegalArgumentException("Invalid product type")
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = ProductListFragmentBinding.inflate(inflater, container, false)

        val processedData = listOf<Product>().map{ p -> p } // TODO()
        val customAdapter = ProductListAdapter(processedData)

        binding.productListRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.productListRecyclerView.adapter = customAdapter
        return binding.root
    }
}
