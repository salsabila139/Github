package com.salsabila.idn.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.getResourceIdOrThrow
import androidx.recyclerview.widget.LinearLayoutManager
import com.salsabila.idn.github.adapter.ListUserAdapter
import com.salsabila.idn.github.databinding.ActivityMainBinding
import com.salsabila.idn.github.model.User


class MainActivity : AppCompatActivity() {
    private val list = ArrayList<User>()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()

        list.addAll(getDataUser())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        mainBinding.rvUser.layoutManager = LinearLayoutManager(this)
        var listUserAdapter = ListUserAdapter(list)
        mainBinding.rvUser.setHasFixedSize(true)
        mainBinding.rvUser.adapter = listUserAdapter
    }

    private fun getDataUser(): ArrayList<User> {
        val dataName = resources.getStringArray(R.array.name)
        val dataUserName = resources.getStringArray(R.array.username)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val listUsers = ArrayList<User>()
        for (position in dataName.indices) {
            val user = User(
                dataName[position],
                dataUserName[position],
                dataPhoto.getResourceId(position,-1),
                dataFollowers[position].toInt(),
                dataFollowing[position].toInt(),
                dataCompany[position],
                dataRepository[position].toInt(),
                dataLocation[position]
            )
            listUsers.add(user)
        }
        return listUsers
    }
}