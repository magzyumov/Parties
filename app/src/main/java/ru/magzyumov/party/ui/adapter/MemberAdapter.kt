package ru.magzyumov.party.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.magzyumov.party.R
import ru.magzyumov.party.data.entity.MemberEntity
import ru.magzyumov.party.databinding.ItemMemberBinding


class MemberAdapter(members: List<MemberEntity>): RecyclerView.Adapter<MemberAdapter.MemberHolder>() {

    private var allMembers: MutableList<MemberEntity> = mutableListOf()

    init {
        allMembers.addAll(members)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemMemberBinding = DataBindingUtil.inflate(inflater, R.layout.item_member, parent, false)
        return MemberHolder(binding)
    }

    override fun getItemCount() = allMembers.size

    override fun onBindViewHolder(holder: MemberHolder, position: Int) {
        holder.bind(member = allMembers[position])
    }

    fun swap(members: List<MemberEntity>) {
        val diffCallback = DiffCallback(allMembers, members)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        allMembers.clear()
        allMembers.addAll(members)
        diffResult.dispatchUpdatesTo(this)
    }

    class MemberHolder(binding: ItemMemberBinding): RecyclerView.ViewHolder(binding.root) {
        private val binding: ItemMemberBinding = binding

        fun bind(member: MemberEntity) {
            binding.member = member
            binding.executePendingBindings()
        }
    }

    class DiffCallback(
        private val oldList: List<MemberEntity>,
        private val newList: List<MemberEntity>
    ): DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
                    && oldList[oldItemPosition].name == newList[newItemPosition].name
                    && oldList[oldItemPosition].avatar == newList[newItemPosition].avatar
        }
    }
}
