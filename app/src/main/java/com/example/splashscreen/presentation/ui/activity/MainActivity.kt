package com.example.splashscreen.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.splashscreen.R
import com.example.splashscreen.presentation.ui.adapter.OnBoardingItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var onBoardingItemsAdapter: OnBoardingItemAdapter
    private lateinit var indicatorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_SplashScreen)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* setOnBoardingItems()
        setupIndicator()
        setCurrentIndicator(0)*/
    }

   /* private fun setOnBoardingItems(){
        onBoardingItemsAdapter = OnBoardingItemAdapter(
            listOf(
                OnBoardingItem(
                    onBoardingImage = R.drawable.unsplash,
                    title = "Smart Wallet",
                    description = "Managing your money can be the easiest thing you do all day."

                ),
                OnBoardingItem(
                    onBoardingImage = R.drawable.pager2,
                    title = "Effortless Budgeting",
                    description = "Customize your budget categories and stay on top of your spending 24/7."
                ),
                OnBoardingItem(
                    onBoardingImage = R.drawable.youtube,
                    title = "Automatic Savings",
                    description = "Set your savings goal, and let Empower figure out how to get you there."
                )
            )
        )
        val onboardingViewPager = findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onBoardingItemsAdapter
        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onboardingViewPager.getChildAt(0) as  RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
        findViewById<ImageView>(R.id.image_next).setOnClickListener{
            if (onboardingViewPager.currentItem + 1 < onBoardingItemsAdapter.itemCount){
                onboardingViewPager.currentItem +=1
            }else {
                navigateToHomeActivity()
            }
        }
        findViewById<TextView>(R.id.skip).setOnClickListener{
            navigateToHomeActivity()
        }
        findViewById<MaterialButton>(R.id.buttonGEtStarted).setOnClickListener {
            navigateToHomeActivity()
        }
    }

    private fun navigateToHomeActivity(){
        startActivity(Intent(applicationContext, HomeActivity::class.java))
        finish()
    }

    private fun setupIndicator(){
        indicatorsContainer = findViewById(R.id.indicatorsContainer)
        val indicators  = arrayOfNulls<ImageView>(onBoardingItemsAdapter.itemCount)
        val layoutParams : LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,0,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position : Int){
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount){
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if (i == position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            } else
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
        }
    }*/
}