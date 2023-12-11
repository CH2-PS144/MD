//package com.example.physedu.activity
//
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.cardview.widget.CardView
//import androidx.lifecycle.ViewModel
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.physedu.R
//
//class HomeViewModel : ViewModel() {
//    fun loadImage(view: ImageView, imageUrl: String?) {
//        imageUrl?.let {
//            Glide.with(view.context)
//                .load(it)
//                .placeholder(R.drawable.logo_home)
//                .into(view)
//        }
//    }
//
//    fun setText(view: TextView, text: String?) {
//        view.text = text ?: ""
//    }
//    fun setKelasUserList(recyclerView: RecyclerView, kelasUserList: List<KelasUser>?) {
//        kelasUserList?.let {
//            val adapter = recyclerView.adapter as KelasUserAdapter
//            adapter.submitList(it)
//        }
//    }
//
//    // Bindings for CardView
//    fun setCardCornerRadius(cardView: CardView, cornerRadius: Float) {
//        cardView.radius = cornerRadius
//    }
//}