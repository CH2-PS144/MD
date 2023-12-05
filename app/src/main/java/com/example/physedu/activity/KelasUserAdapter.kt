package com.example.physedu.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.physedu.R
import com.example.physedu.databinding.ItemUserBinding

class KelasUserAdapter (private val listKelas:ArrayList<KelasUser>)  : RecyclerView.Adapter<KelasUserAdapter.ListViewHolder>()  {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgGambar: ImageView = itemView.findViewById(R.id.iv_gbr_kelas)
        val tvNama: TextView = itemView.findViewById(R.id.tvKelasUser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kelas, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listKelas.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, gambar) = listKelas[position]
        holder.imgGambar.setImageResource(gambar)
        holder.tvNama.text = nama

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listKelas[holder.adapterPosition]) }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: KelasUser)
    }
}
