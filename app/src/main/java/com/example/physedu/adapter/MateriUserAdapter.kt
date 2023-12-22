package com.example.physedu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.physedu.R
import com.example.physedu.ui.kelas.MateriUser

class MateriUserAdapter (private val listMateri:ArrayList<MateriUser>) : RecyclerView.Adapter<MateriUserAdapter.ListViewHolder>()  {
    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tv_namaMateri)
        val btnMulai: TextView = itemView.findViewById(R.id.btn_mulai)
        val imgGambar: ImageView = itemView.findViewById(R.id.iv_nomor)

    }
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_materi, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val superKelas = listMateri[position]
        holder.tvNama.text = superKelas.nama
        holder.btnMulai.text = superKelas.mulai

        Glide.with(holder.itemView.context)
            .load(superKelas.gambar)
            .into(holder.imgGambar)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listMateri[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listMateri.size


    interface OnItemClickCallback {
        fun onItemClicked(data: MateriUser)
    }
}