package com.example.mycoffeelist


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CoffeeAdapter(private val coffeeList: List<CoffeeData>) : RecyclerView.Adapter<CoffeeAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val coffeeImage: ImageView
        val coffeeTitle: TextView
        val coffeeDescription: TextView

        init {
            // Find our RecyclerView item's ImageView for future use
            coffeeImage = view.findViewById(R.id.coffee_image)
            coffeeTitle = view.findViewById(R.id.coffee_title)
            coffeeDescription = view.findViewById(R.id.coffee_description)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.coffee, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return coffeeList.size  // get the size of the dataset
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coffeeItem = coffeeList[position]

        holder.coffeeTitle.text = coffeeItem.title
        holder.coffeeDescription.text = coffeeItem.description

        Glide.with(holder.itemView.context)
            .load(coffeeItem.image)
            .centerCrop()
            .into(holder.coffeeImage)

    }
}