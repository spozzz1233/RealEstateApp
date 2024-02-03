package com.example.realestateapp.ui.main

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.realestateapp.R
import com.example.realestateapp.domain.model.PropertyResponse
import com.example.realestateapp.domain.model.property
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MainAdapter(
    private val clickListener: HomeClick,
) : RecyclerView.Adapter<MainAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.HomeViewHolder {
        val cardMusicView =
            LayoutInflater.from(parent.context).inflate(R.layout.realestate_mini, parent, false)
        return MainAdapter.HomeViewHolder(cardMusicView)
    }

    override fun onBindViewHolder(holder: MainAdapter.HomeViewHolder, position: Int) {
        holder.bind(property[position])
        val part = property[position]
        holder.itemView.setOnClickListener {
            clickListener.onClick(part)
        }

    }

    override fun getItemCount(): Int = property.size
    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val realEstateName: TextView = itemView.findViewById(R.id.name)
        private val realEstatePrice: TextView = itemView.findViewById(R.id.price)
        private val image: ImageView = itemView.findViewById(R.id.image)


        fun bind(realEstate: PropertyResponse) {
            realEstateName.text = realEstate.typeOfEstate
            realEstatePrice.text = realEstate.price.toString() + " $"

            Glide.with(itemView.context)
                .load(R.drawable.real_estate)
                .transform(RoundedCorners(8))
                .into(image)
        }
    }

    fun interface HomeClick {
        fun onClick(realEstate: PropertyResponse)
    }

    fun setItems(newParts: ArrayList<PropertyResponse>) {
        property = newParts
        notifyDataSetChanged()
    }

}
