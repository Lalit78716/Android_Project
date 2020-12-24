package com.example.flipr_app.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flipr_app.R

class MyViewPagerAdapter(var context: Context) : RecyclerView.Adapter<MyViewPagerAdapter.MyViewHolder>()  {
    var color_icon_matrix= arrayOf<IntArray>(
        intArrayOf(android.R.color.white,R.drawable.sync),
        intArrayOf(android.R.color.white,R.drawable.cloudsecurity),
        intArrayOf(android.R.color.white,R.drawable.cloudfolder),
        intArrayOf(android.R.color.white,R.drawable.drivecloud)


    )
    public var heading_Array= arrayOf<String>(
        "Sync",
        "Secure",
        "Auto Sync Folder",
        "Cloud Memory Storage"
    )
    public var desc_Array= arrayOf<String>(
        "Sync all the data from your Device and store in Cloud(Google drive)",
        "Full secure application",
        "Auto Syncing your device selected folder based on given period of time",
        "Google Drive Cloud storage Backup"
    );


    class MyViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        lateinit var img_view:ImageView
        lateinit var container:RelativeLayout
        lateinit var heading:TextView
        lateinit var desc:TextView

        init {
            img_view=itemView.findViewById(R.id.img_view) as ImageView
            container=itemView.findViewById(R.id.container) as RelativeLayout
            heading=itemView.findViewById(R.id.heading_view) as TextView
            desc=itemView.findViewById(R.id.desc_view) as TextView


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_page,parent,false))
    }

    override fun getItemCount(): Int {
        return color_icon_matrix.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.img_view.setImageResource(color_icon_matrix[position][1])
        holder.container.setBackgroundResource(color_icon_matrix[position][0])
        holder.heading.text=heading_Array[position]
        holder.desc.text=desc_Array[position]
    }


}