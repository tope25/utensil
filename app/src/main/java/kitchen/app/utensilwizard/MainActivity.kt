package kitchen.app.utensilwizard

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import kitchen.app.utensilwizard.adapter.UtensilAdapter
import kitchen.app.utensilwizard.adapter.UtensilModels
import kitchen.app.utensilwizard.databinding.ActivityMainBinding
import kitchen.app.utensilwizard.utensils.UtensilQuiz

@SuppressLint("Deprecated")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myUtensilList: ArrayList<UtensilModels>
    private lateinit var myUtensilAdapter: UtensilAdapter
    private var exit = 0
    private val handler = Handler()
    private lateinit var autoSwipeRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewUtensils()

        binding.viewPager.clipToPadding = false
        binding.viewPager.setPadding(1, 0, 1, 0)

        val quizText = binding.utensilQuiz
        quizText.paintFlags = quizText.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        binding.utensilQuiz.setOnClickListener {
            startActivity(
                Intent(
                    this, UtensilQuiz::class.java
                )
            )
        }

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                var title = myUtensilList[position].utensilId
            }

            override fun onPageSelected(position: Int) {
            }
        })
        startAutoSwiping()
    }

    private fun startAutoSwiping() {
        val autoSwipeDelay = 3000L
        autoSwipeRunnable = object : Runnable {
            override fun run() {
                var currentItem = binding.viewPager.currentItem
                currentItem = (currentItem + 1) % myUtensilList.size
                binding.viewPager.setCurrentItem(currentItem, true)
                handler.postDelayed(this, autoSwipeDelay)
            }
        }
        handler.postDelayed(autoSwipeRunnable, autoSwipeDelay)
    }

    override fun onDestroy() {
        handler.removeCallbacks(autoSwipeRunnable)
        super.onDestroy()
    }

    private fun viewUtensils() {
        myUtensilList = ArrayList()

        myUtensilList.add(
            UtensilModels(
                R.drawable.chefsknife,
                "Chef's Knife",
                R.array.chefs_knife
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.cuttingboard,
                "Cutting Board",
                R.array.cutting_board
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.mixingbowls,
                "Mixing Bowls",
                R.array.mixing_bowls
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.spatula,
                "Spatula/Turner",
                R.array.spatula
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.woodenspoon,
                "Wooden Spoon",
                R.array.wooden_spoons
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.whisk,
                "Whisk",
                R.array.whisk
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.tongs,
                "Tongs",
                R.array.tongs
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.colander,
                "Colander",
                R.array.colander
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.measruingcupsoons,
                "Measuring Cups & Spoons",
                R.array.cups_spoons
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.peelers,
                "Chef's Knife",
                R.array.chefs_knife
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.canopener,
                "Can Opener",
                R.array.can_opener
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.ladle,
                "Ladle",
                R.array.ladle
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.rollingpin,
                "Rolling Pin",
                R.array.rolling_pin
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.grater,
                "Grater",
                R.array.grater
            )
        )

        myUtensilList.add(
            UtensilModels(
                R.drawable.kitchenshears,
                "Kitchen Shears",
                R.array.kitchen_shears
            )
        )
        myUtensilAdapter = UtensilAdapter(this, myUtensilList)
        binding.viewPager.adapter = myUtensilAdapter
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        if (exit == 0) {
            exit = 1
            Toast.makeText(this, "PRESS AGAIN TO EXIT", Toast.LENGTH_SHORT).show()
        } else {
            super.onBackPressed()
            finishAffinity()
        }
    }
}