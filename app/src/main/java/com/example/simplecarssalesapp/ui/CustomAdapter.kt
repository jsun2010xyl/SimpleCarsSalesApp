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
        holder.textView1.text =
            item.year.toString()+" "+item.make+" "+item.model+" "+item.trim
        holder.textView2.text =
            "$"+"%,d".format(item.currentPrice.roundToInt())+"   |   "+
                    (item.mileage/1000).toString()+"k mi"
        holder.textView3.text = item.city + ", " + item.state
        // TODO : images cannot display, maybe sth is wrong with urls
        Picasso.get().load(item.photo).into(holder.imageView);

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(
        carView: View,
        private val onItemClicked: (position: Int) -> Unit,
        private val onCallButtonClicked: (position: Int) -> Unit
    )
        : RecyclerView.ViewHolder(carView), View.OnClickListener {

        // 下面这个itemView是系统变量
        val textView1: TextView = itemView.findViewById(R.id.textView1_YearMakeModelTrim)
        val textView2: TextView = itemView.findViewById(R.id.textView2_priceMileage)
        val textView3: TextView = itemView.findViewById(R.id.textView3_location)
        val imageView: ImageView = itemView.findViewById(R.id.imageView1_carPhoto)
        val callButton: Button = itemView.findViewById(R.id.button1_callDealer)

        init {
            itemView.setOnClickListener(this)
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