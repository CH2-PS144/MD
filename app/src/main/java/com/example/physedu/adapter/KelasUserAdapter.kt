package com.example.physedu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.physedu.R
import com.example.physedu.ui.kelas.KelasUser

class KelasUserAdapter (private val listKelas:ArrayList<KelasUser>) : RecyclerView.Adapter<KelasUserAdapter.ListViewHolder>()  {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvNama: TextView = itemView.findViewById(R.id.tvItemName)
        val btnMulai: TextView = itemView.findViewById(R.id.btn_ayoMulai)
        val imgGambar: ImageView = itemView.findViewById(R.id.img_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kelas, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val superKelas = listKelas[position]
        holder.tvNama.text = superKelas.kelas
        holder.btnMulai.text = superKelas.mulai

        Glide.with(holder.itemView.context)
            .load(superKelas.gambar)
            .into(holder.imgGambar)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listKelas[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listKelas.size

    interface OnItemClickCallback {
        fun onItemClicked(data: KelasUser)
    }
}
