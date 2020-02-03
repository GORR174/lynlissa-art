package ru.catstack.lynlissaart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}
