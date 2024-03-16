package com.cs4520.assignment4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs4520.assignment4.databinding.ProductListFragmentBinding

class ProductListFragment : Fragment() {
    private var _binding: ProductListFragmentBinding? = null

    private val binding get() = _binding!!
//    private val viewModel: ProductListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = ProductListFragmentBinding.inflate(inflater, container, false)

        val processedData = listOf<Product>().map { p -> p } // TODO()
        val customAdapter = ProductListAdapter(processedData)

        binding.productListRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.productListRecyclerView.adapter = customAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel = ViewModelProvider(this)[MVVMViewModel::class.java]
//
//        viewModel!!.result.observe(viewLifecycleOwner, Observer {
//            binding.calcResult.text = "Result: $it"
//        })
    }
}