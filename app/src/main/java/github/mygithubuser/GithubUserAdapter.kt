import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import github.mygithubuser.ItemsItem
import github.mygithubuser.databinding.ItemUserBinding

class GithubUserAdapter(private val listUser: List<Pair<String, String>>) : RecyclerView.Adapter<GithubUserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (name, photo) = listUser[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.binding.imageView) // imageView mana yang akan diterapkan
        holder.binding.tvItem.text = name
    }

    override fun getItemCount() = listUser.size
    fun submitList(it: List<ItemsItem>) {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)
}
