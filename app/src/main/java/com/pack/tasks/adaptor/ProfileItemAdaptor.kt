package com.pack.tasks.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pack.tasks.databinding.LayoutListItemBinding
import com.pack.tasks.entities.ListModel

class ProfileItemAdaptor(private val context: Context, private var dataList: List<ListModel>,var onYourInfoItemResponse:OnYourInfoItemResponse) :
    RecyclerView.Adapter<ProfileItemAdaptor.ViewHolder>() {

    class ViewHolder(private val binding: LayoutListItemBinding,var onYourInfoItemResponse:OnYourInfoItemResponse) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onYourInfoItemResponse.onYourItemClickListener(adapterPosition)
            }
        }

        fun bind(dataItem: ListModel) {
            binding.ivItem.setImageResource(dataItem.imageResourceId)
            binding.tvListTitle.text = dataItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = LayoutListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding,onYourInfoItemResponse)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = dataList[position]
        holder.bind(dataItem)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateData(newDataList: List<ListModel>) {
        dataList = newDataList
        notifyDataSetChanged()
    }

    interface OnYourInfoItemResponse{
        fun onYourItemClickListener(position: Int)
    }
}