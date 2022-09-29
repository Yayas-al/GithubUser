package com.example.githubuser

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)
        list.addAll(listUsers)
        showRecyclerList()


    }

    private val listUsers: ArrayList<Users>
        get() {
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            val dataUserName = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listusers = ArrayList<Users>()
            for (i in dataName.indices) {
                val user = Users(
                    dataPhoto.getResourceId(i, -1),
                    dataUserName[i],
                    dataName[i],
                    dataLocation[i],
                    dataRepository[i],
                    dataCompany[i],
                    dataFollowers[i],
                    dataFollowing[i]

                )
                listusers.add(user)
            }
            return listusers
        }

    private fun showRecyclerList() {
        rvUser.layoutManager = GridLayoutManager(this, 2)
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUser.layoutManager = LinearLayoutManager(this)
        }
        val ListUserAdapter = ListUserAdapter(list)
        rvUser.adapter = ListUserAdapter

        ListUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Users){
                val moveDetailUser = Intent(this@MainActivity, UserProfile::class.java)
                moveDetailUser.putExtra(UserProfile.KEY_USER, data)
                startActivity(moveDetailUser)
    }}
        )}}