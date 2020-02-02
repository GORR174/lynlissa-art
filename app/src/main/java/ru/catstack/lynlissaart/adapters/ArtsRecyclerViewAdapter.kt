package ru.catstack.lynlissaart.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_view.view.*
import ru.catstack.lynlissaart.R
import ru.catstack.lynlissaart.domain.Art

class ArtsRecyclerViewAdapter(
    private val arts: ArrayList<Art>,
    private val fragment: Fragment,
    private val onItemClickListener: (Art) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount() = arts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.imageView.setOnClickListener {
            onItemClickListener(arts[position])
        }
        Glide.with(fragment).load(arts[position].imageUrl).into(viewHolder.imageView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.imageView!!
    }
}