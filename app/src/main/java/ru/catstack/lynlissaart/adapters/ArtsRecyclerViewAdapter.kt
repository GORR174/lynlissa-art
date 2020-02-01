package ru.catstack.lynlissaart.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_view.view.*
import ru.catstack.lynlissaart.R
import ru.catstack.lynlissaart.domain.Art

class ArtsRecyclerViewAdapter(private val arts: ArrayList<Art>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount() = arts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.imageView!!
    }
}