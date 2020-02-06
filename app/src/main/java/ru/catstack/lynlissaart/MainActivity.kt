package ru.catstack.lynlissaart

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.main_activity.*
import ru.catstack.lynlissaart.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        navController = navHostFragment.findNavController()
        NavigationUI.setupActionBarWithNavController(this, navController)
        MainFragment.saveView = null
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    fun hideBar() {
        supportActionBar?.hide()
        window.decorView.apply {
            systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        }
    }

    fun showBar() {
        supportActionBar?.show()
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }
    }
}
