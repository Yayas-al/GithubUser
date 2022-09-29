package com.example.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserProfile : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        val imgPhoto: CircleImageView = findViewById(R.id.img_item_photo)
        val tvUserName: TextView =findViewById(R.id.tv_item_username)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvLocation: TextView = findViewById(R.id.tv_item_location)
        val tvCompany: TextView = findViewById(R.id.tv_item_company)
        val tvRepository: TextView = findViewById(R.id.tv_item_repository)
        val tvFollowers: TextView = findViewById(R.id.tv_item_followers)
        val tvFollowing: TextView = findViewById(R.id.tv_item_following)

        val user = intent.getParcelableExtra<Users>(KEY_USER) as Users
        val (photo, username,name, location, repository , company, followers, following) =user
        if (photo != null) {
            imgPhoto.setImageResource(photo)
        }
        tvUserName.text = username
        tvName.text = name
        tvLocation.text = location
        tvRepository.text = repository
        tvCompany.text = company
        tvFollowers.text = followers
        tvFollowing.text = following


    }
    companion object{
        const val KEY_USER = "key_user"
    }

}
