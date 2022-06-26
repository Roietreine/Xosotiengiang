package giang.tien.xstingiang.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import giang.tien.xstingiang.R
import giang.tien.xstingiang.data.Data
import giang.tien.xstingiang.databinding.ItemMainMenuBinding

class MainAdapter(
    private val listener: OnItemClickListener
): RecyclerView.Adapter<MainAdapter.Holder>() {

    val data = Data.data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_main_menu, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val newData = data[position]
        with(holder.binding){
            textSubMenu.text = newData.title
            menuTitle.text = newData.title
            menuIcon.setBackgroundResource(newData.icon)
            root.setOnClickListener { listener.onItemCLick(position + 1) }
        }
    }

    override fun getItemCount(): Int = data.size

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy {
            ItemMainMenuBinding.bind(itemView)
        }
    }
}