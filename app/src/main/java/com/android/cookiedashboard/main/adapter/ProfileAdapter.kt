package com.android.cookiedashboard.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.cookiedashboard.R
import kotlinx.android.synthetic.main.profile_list_row.view.*

class ProfileAdapter(private val listener: MainActivityListener) : RecyclerView.Adapter<ProfileViewHolder>() {

    private var profiles = listOf<String>()

    override fun getItemCount(): Int = profiles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder =
        ProfileViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.profile_list_row, parent, false), parent, listener)

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.setData(profiles[position])
    }

    fun updateProfileList(profiles: List<String>) {
        this.profiles = profiles
        notifyDataSetChanged()
    }
}

class ProfileViewHolder(
    private val view: View,
    private val viewGroup: ViewGroup,
    private val listener: MainActivityListener
) : RecyclerView.ViewHolder(view) {

    fun setData(profileName: String) {
        view.profile_name.text = profileName
    }

}

interface MainActivityListener {
    fun addProfile()
}