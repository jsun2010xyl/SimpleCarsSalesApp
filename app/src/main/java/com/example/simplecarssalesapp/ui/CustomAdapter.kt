package com.example.simplecarssalesapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simplecarssalesapp.R
import com.example.simplecarssalesapp.data.db.entity.Car
import com.squareup.picasso.Picasso
import kotlin.math.roundToInt

class CustomAdapter(
    private val mList: List<Car>,
    private val onItemClicked: (position: Int) -> Unit,
    private val onCallButtonClicked: (position: Int) -> Unit)
    : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view, onItemClicked, onCallButtonClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mList[position]
        holder.textView1.text = getYearMakeModelTrim(item.year, item.make, item.model, item.trim)
        holder.textView2.text = getPriceMileage(item.currentPrice, item.mileage)
        holder.textView3.text = getLocation(item.city, item.state)
        // images cannot display, maybe sth is wrong with urls
        Picasso.get().load(item.photo).into(holder.imageView);

        // When we use a working uri, the image can be displayed
        //val uri = "https://imageio.forbes.com/specials-images/imageserve/5d3703b3090f4300070d570d/2020-Cadillac-CT5/0x0.jpg?fit=crop&format=jpg&crop=4842,2723,x288,y538,safe"
        //Picasso.get().load(uri).into(holder.imageView);

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(
        carView: View,
        private val onItemClicked: (position: Int) -> Unit,
        private val onCallButtonClicked: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(carView), View.OnClickListener {

        val textView1: TextView = itemView.findViewById(R.id.textView1_YearMakeModelTrim)
        val textView2: TextView = itemView.findViewById(R.id.textView2_priceMileage)
        val textView3: TextView = itemView.findViewById(R.id.textView3_location)
        val imageView: ImageView = itemView.findViewById(R.id.imageView1_carPhoto)
        val callButton: Button = itemView.findViewById(R.id.button1_callDealer)

        init {
            itemView.setOnClickListener(this)
            callButton.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            if (v == callButton){
                onCallButtonClicked(position)
            }else{
                onItemClicked(position)
            }

        }

    }
}