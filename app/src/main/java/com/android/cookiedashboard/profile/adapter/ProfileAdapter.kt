package com.android.cookiedashboard.profile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.cookiedashboard.R
import com.android.cookiedashboard.main.MainActivity
import com.android.uiextension.launchActivity
import kotlinx.android.synthetic.main.profile_list_row.view.*

class ProfileAdapter(private val listener: ProfileActivityListener) : RecyclerView.Adapter<ProfileViewHolder>() {

    private var profiles = listOf<ProfileCard>()

    override fun getItemCount(): Int = profiles.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder =
        ProfileViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.profile_list_row, parent, false), listener)

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.setData(profiles[position])
    }

    fun updateProfileList(profiles: List<ProfileCard>) {
        this.profiles = profiles + ProfileCard(WRONG_UID, listener.getContext().getString(R.string.add), false)
        notifyDataSetChanged()
    }

    companion object {
        private const val WRONG_UID = -1
    }
}

class ProfileViewHolder(
    private val view: View,
    private val listener: ProfileActivityListener
) : RecyclerView.ViewHolder(view) {

    fun setData(profileCard: ProfileCard) {
        view.apply {
            profile_name.text = profileCard.name
            profile_image.setImageResource(getProfileImage(profileCard))
            setOnClickListener {
                if (profileCard.isProfile) showProfileDetails(context, profileCard)
                else listener.addProfile()
            }
        }
    }

    private fun getProfileImage(profileCard: ProfileCard): Int =
        if (profileCard.isProfile) R.mipmap.ic_launcher
        else R.drawable.ic_add

    private fun showProfileDetails(context: Context, profileCard: ProfileCard) {
        context.launchActivity<MainActivity> {
            putExtra(ProfileCard.PROFILE_ID, profileCard.id)
        }
    }
}

interface ProfileActivityListener {
    fun addProfile()
    fun getContext(): Context
}