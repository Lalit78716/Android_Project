package com.example.flipr_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.flipr_app.Adaptor.MyViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_welcome.*

class welcomeActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var isRemember=false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        sharedPreferences=getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)

        isRemember=sharedPreferences.getBoolean("FLAG",false)

        if(isRemember){
            intent=Intent(this,MainActivity::class.java).also {
                startActivity(it)
                finish() }
        }
        init()

    }
    private fun init() {
        view_pager.adapter= MyViewPagerAdapter(this@welcomeActivity)
        TabLayoutMediator(tabDots,view_pager, TabLayoutMediator.TabConfigurationStrategy( { tab, position->
            //here we will set something for tab link text...etc
        })).attach()

        val editor:SharedPreferences.Editor=sharedPreferences.edit()
        editor.putBoolean("FLAG",true)
        editor.apply()

        view_pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                yha pr visibe invisble

                if(position==3){
                    start_btn.visibility= View.VISIBLE
                    pre_btn.visibility= View.VISIBLE
                    next_btn.visibility= View.INVISIBLE
                }
                else if(position==0){
                    pre_btn.visibility= View.INVISIBLE
                }
                else{
                    start_btn.visibility= View.INVISIBLE
                    pre_btn.visibility= View.VISIBLE
                    next_btn.visibility= View.VISIBLE
                }

            }
        })


        start_btn.setOnClickListener{
            intent=Intent(this,MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
        skip_btn.setOnClickListener {
            intent=Intent(this,MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }


    }

}