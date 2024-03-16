package com.cs4520.assignment4

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment4.databinding.ProductListFragmentBinding
import com.cs4520.assignment4.databinding.ProductListItemBinding

class ProductListAdapter(private var dataset: List<Product>): RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    fun updateProductList(data: List<Product>) {
        dataset = data
    }

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val nameText: TextView = itemView.findViewById(R.id.product_name)
        private val imageView: ImageView = itemView.findViewById(R.id.product_image)
        private val dateText: TextView = itemView.findViewById(R.id.product_date)
        private val priceText: TextView = itemView.findViewById(R.id.product_price)


        private fun getBackgroundImg(type: String): Int {
            if (type == "Equipment") {
                return R.drawable.equipment
            }
            return R.drawable.food
        }

        fun bind(p: Product) {

            nameText.text = p.name
            imageView.setBackgroundResource(getBackgroundImg(p.type))
            if (p.expDate == null) {
                dateText.visibility = View.INVISIBLE
            } else {
                dateText.visibility = View.VISIBLE
                dateText.text = p.expDate
            }
            priceText.text = "$ ${p.price}"
            if (p.type == "Food") {
                itemView.setBackgroundColor(Color.parseColor("#FFD965"))
            } else if (p.type == "Equipment") {
                itemView.setBackgroundColor(Color.parseColor("#E06666"))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_item, parent, false)

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
