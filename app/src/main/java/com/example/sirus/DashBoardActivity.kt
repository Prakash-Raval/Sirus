package com.example.sirus

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sirus.adapters.CategoriesAdapter
import com.example.sirus.adapters.FeaturedAdapter
import com.example.sirus.adapters.MostViewedAdapter
import com.example.sirus.databinding.ActivityDashBoardBinding
import com.example.sirus.modals.CategoryData
import com.example.sirus.modals.FeaturedData
import com.example.sirus.modals.MostViewedData
import com.google.android.material.navigation.NavigationView


class DashBoardActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityDashBoardBinding
    private lateinit var fetAdapter: FeaturedAdapter
    private lateinit var mostAdapter: MostViewedAdapter
    private lateinit var catAdapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        categoryAdapter()
        mostViewedAdapter()
        featuredAdapter()
        navigateDrawer()
        openRetailer()
    }

    private fun categoryAdapter() {
        val catData: ArrayList<CategoryData> = ArrayList()
        catData.add(CategoryData("Education", R.drawable.mac))
        catData.add(CategoryData("Shops", R.drawable.mac))
        catData.add(CategoryData("Medical", R.drawable.mac))
        catData.add(CategoryData("Hospital", R.drawable.mac))
        catData.add(CategoryData("Transport", R.drawable.mac))
        catAdapter = CategoriesAdapter(catData)
        binding.categoriesRecycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.categoriesRecycler.adapter = catAdapter

    }

    private fun mostViewedAdapter() {
        val mostData: ArrayList<MostViewedData> = ArrayList()
        mostData.add(
            MostViewedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        mostData.add(
            MostViewedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        mostData.add(
            MostViewedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        mostData.add(
            MostViewedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        mostData.add(
            MostViewedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        mostData.add(
            MostViewedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        mostData.add(
            MostViewedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        mostData.add(
            MostViewedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        mostAdapter = MostViewedAdapter(mostData)
        binding.mostViewedRecycler.adapter = mostAdapter
        binding.mostViewedRecycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
    }

    private fun featuredAdapter() {
        val featuredData: ArrayList<FeaturedData> = ArrayList()
        featuredData.add(
            FeaturedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        featuredData.add(
            FeaturedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        featuredData.add(
            FeaturedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        featuredData.add(
            FeaturedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        featuredData.add(
            FeaturedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        featuredData.add(
            FeaturedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        featuredData.add(
            FeaturedData(
                R.drawable.mac,
                "MacDonald's",
                3.2f,
                "hello welcome to MacDonald's hello welcome to MacDonald's hello welcome to MacDonald's "
            )
        )
        fetAdapter = FeaturedAdapter(featuredData)
        binding.featuredRecycler.adapter = fetAdapter
        binding.featuredRecycler.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuCategory ->{
                startActivity(Intent(this,CategoryActivity::class.java))
            }
            R.id.menuDashBoard ->{
                startActivity(Intent(this,DashBoardActivity::class.java))
            }
        }
        return true
    }

    private fun navigateDrawer() {

        binding.navigationView.bringToFront()
        binding.navigationView.setNavigationItemSelectedListener(this)
        binding.navigationView.setCheckedItem(R.id.menuDashBoard)

        binding.imgMenu.setOnClickListener {
            if (binding.drawerLayout.isDrawerVisible(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.END)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        animateDrawer()

    }

    private fun animateDrawer() {
        binding.drawerLayout.setScrimColor(Color.TRANSPARENT)
        binding.drawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                val endScale = 0.7F
                // Scale the View based on current slide offset
                val diffScaledOffset: Float = slideOffset * (1 - endScale)
                val offsetScale: Float = 1 - diffScaledOffset
                binding.container0.scaleX = offsetScale
                binding.container0.scaleY = offsetScale
                // Translate the View, accounting for the scaled width
                val xOffset = drawerView.width * slideOffset
                val xOffsetDiff = binding.container0.width * diffScaledOffset / 2
                val xTranslation = xOffset - xOffsetDiff
                binding.container0.translationX = xTranslation
            }
        })
    }

    private fun openRetailer(){
        binding.imgPlus.setOnClickListener {
            startActivity(Intent(this,RetailerActivity::class.java))
        }
    }

}