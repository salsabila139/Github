package com.salsabila.idn.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.salsabila.idn.github.databinding.ActivityDetail2Binding
import com.salsabila.idn.github.model.User

class Detail : AppCompatActivity() {

    companion object{
        private var EXTRA_USERNAME = "extra_username"
    }
    private lateinit var detail2Binding: ActivityDetail2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detail2Binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(detail2Binding.root)

        supportActionBar?.hide()
        var user = intent.getParcelableExtra<User>(EXTRA_USERNAME) as User
        Glide.with(this).load(user.photo).into(detail2Binding.ivProfileDetail)
        detail2Binding.tvNameDetail.text = user.name
        detail2Binding.tvUsernameDetail.text = user.username
        detail2Binding.tvCompany.text = user.company
        detail2Binding.tvLocation.text = user.location
        detail2Binding.tvFollowers.text = user.followers.toString()
        detail2Binding.tvFollowing.text = user.following.toString()
        detail2Binding.tvRepository.text = user.repository.toString()

    }
}