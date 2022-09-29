package com.example.githubuser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

class ListUserAdapter (private val listusers: ArrayList<Users>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
        private lateinit var onItemClickCallback: OnItemClickCallback
        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
                this.onItemClickCallback = onItemClickCallback
        }

        class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                var imgPhoto: CircleImageView = itemView.findViewById(R.id.img_item_photo)
                var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
                var tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
                var tvCompany: TextView = itemView.findViewById(R.id.tv_item_company)
        }

       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
                return ListViewHolder(view)
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
                val (photo,name, location, company) =listusers[position]
                if (photo != null) {
                        holder.imgPhoto.setImageResource(photo)
                }
                holder.apply {
                    tvName.text = name
                    tvLocation.text = location
                    tvCompany.text = company
                    itemView.setOnClickListener{ onItemClickCallback.onItemClicked(listusers[holder.adapterPosition])

                    }

                }
        }
        interface OnItemClickCallback{
                fun onItemClicked(data: Users)
        }
        override fun getItemCount(): Int = listusers.size


}