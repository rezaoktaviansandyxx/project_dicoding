package github.mygithubuser

import GithubUserAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import github.mygithubuser.databinding.ActivityMainBinding
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var userAdapter:   GithubUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val mainViewModel=ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)
        mainViewModel.listUser.observe(this, {listUser ->setListUserData(listUser)})

      mainViewModel.listUser.observe(this, {listUser -> setGithubUserData(listUser)})

        mainViewModel.isLoading.observe(this, {
            showLoading(it)
        })

    }

    private fun showLoading(it: Serializable) {
        TODO("Not yet implemented")
    }

    private fun setGithubUserData(listUser: List<ItemsItem>?) {
        TODO("Not yet implemented")
    }

    private fun setListUserData(listUser: List<ItemsItem>?) {
        TODO("Not yet implemented")
    }
}
