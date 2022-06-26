package giang.tien.xstingiang.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import giang.tien.xstingiang.R
import giang.tien.xstingiang.data.Data
import giang.tien.xstingiang.databinding.ItemBottomMenuBinding
import giang.tien.xstingiang.databinding.ItemMainMenuBinding
import giang.tien.xstingiang.databinding.ItemMenuBinding

class BallsAdapter: RecyclerView.Adapter<BallsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_menu, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(holder.binding){
            textSubMenu.text = getRandomNumber().toString()
            textSubMenu.textSize = 50f
            menuBackground.setBackgroundResource(getBackground(position))
        }
    }

    override fun getItemCount(): Int = 4

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding by lazy {
            ItemMenuBinding.bind(itemView)
        }
    }

    private fun getRandomNumber(): Int{
        return (1..55).shuffled()[0]
    }

    private fun getBackground(position: Int): Int {
        return when(position){
            1 -> R.drawable.ic_circle_green
            2 -> R.drawable.ic_circle_red
            3 -> R.drawable.ic_circle_orange
            else -> R.drawable.ic_circle_blue
        }
    }
}