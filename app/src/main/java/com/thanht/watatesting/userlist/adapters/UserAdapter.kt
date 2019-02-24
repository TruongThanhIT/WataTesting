package com.thanht.watatesting.userlist.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thanht.watatesting.R
import com.thanht.watatesting.userlist.models.UserModel
import com.thanht.watatesting.utils.getSystemWidth
import kotlinx.android.synthetic.main.item_user_info.view.*
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.bitmap.CenterCrop


class UserAdapter(private val keywordList: List<UserModel>, private val context: Context) :
    RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user_info, parent, false))
    }

    override fun getItemCount(): Int {
        return keywordList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = keywordList[position]
        val dimension: Int = context.getSystemWidth() / 3
        holder.tvName.text = user.name
        holder.tvAge.text = context.resources.getString(R.string.txt_age, user.age.toString())
        holder.tvAddress.text = user.address
        val params = holder.ivAvatar.layoutParams as ViewGroup.LayoutParams
        params.width = dimension
        params.height = dimension
        holder.ivAvatar.layoutParams = params
        val requestOptions = RequestOptions()
            .placeholder(ColorDrawable(Color.parseColor("#E0E9F1")))
            .override(dimension)
            .transforms(CenterCrop(), RoundedCorners(16))

        Glide.with(context)
            .load(user.url)
            .apply(requestOptions)
            .into(holder.ivAvatar)

    }

}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName: TextView = itemView.tvName
    val tvAge: TextView = itemView.tvAge
    val tvAddress: TextView = itemView.tvAddress
    val ivAvatar: ImageView = itemView.ivAvatar
}