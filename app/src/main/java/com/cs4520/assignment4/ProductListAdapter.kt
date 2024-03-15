package com.cs4520.assignment4

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductListAdapter(private val dataset: List<Product>): RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameText: TextView = itemView.findViewById(R.id.product_name)
        private val imageView: ImageView = itemView.findViewById(R.id.product_image)
        private val dateText: TextView = itemView.findViewById(R.id.product_date)
        private val priceText: TextView = itemView.findViewById(R.id.product_price)

        fun bind(p: Product) {
            nameText.text = p.name
            imageView.setBackgroundResource(p.getBackgroundImg())
            if (p.expirationDate == null) {
                dateText.visibility = View.INVISIBLE
            } else {
                dateText.visibility = View.VISIBLE
                dateText.text = p.expirationDate
            }
            priceText.text = "$ ${p.price}"
            if (p is Food) {
                itemView.setBackgroundColor(Color.parseColor("#FFD965"))
            } else if (p is Equipment) {
                itemView.setBackgroundColor(Color.parseColor("#E06666"))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_item, parent, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
