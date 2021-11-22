package priv.jb.homework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import priv.jb.homework.R
import priv.jb.homework.data.Video

class RecycleViewAdapter (var video : List<Video>) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView : ImageView = view.findViewById(R.id.item_img)
        val titleText : TextView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var indexInList = position%video.size
        var videoItem = video.get(indexInList)

        holder.titleText.text = videoItem.title
        Glide.with(holder.imageView.context)
            .load(videoItem.img)
            .transition(withCrossFade(2000))
            .into(holder.imageView)
    }
}