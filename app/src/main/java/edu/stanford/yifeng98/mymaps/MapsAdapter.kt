package edu.stanford.yifeng98.mymaps

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.stanford.yifeng98.mymaps.models.UserMap

class MapsAdapter(val context: Context, val userMaps: List<UserMap>, val onClickListener: onClickListener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    interface onClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = userMaps.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userMap = userMaps[position]
        holder.itemView.setOnClickListener{
            onClickListener.onItemClick(position)
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(android.R.id.text1)
        textViewTitle.text = userMap.title
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}