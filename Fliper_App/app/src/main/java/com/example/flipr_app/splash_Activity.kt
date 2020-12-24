package com.example.flipr_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.flipr_app.Adaptor.MyViewPagerAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class splash_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val background=object :Thread(){
            override fun run() {
                try {
                    Thread.sleep(3000)
                    val intent= Intent(this@splash_Activity,welcomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                catch (e:Exception){
                    e.printStackTrace()
                }

            }
        }
        background.start()


    }


}