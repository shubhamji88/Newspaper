package shubhamji.com.newspaper

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import shubhamji.com.newspaper.database.NewsDatabase
import shubhamji.com.newspaper.databinding.ActivityMainBinding
import shubhamji.com.newspaper.repository.NewsRepository

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout

        val database = NewsDatabase.getInstance(application)
        val newsRepository = NewsRepository(database)
        val navController = findNavController(this, R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)


        fun callShareIntent(): Boolean {
            startActivity(shareIntent())
            return true
        }
        NavigationUI.setupWithNavController(binding.drawer, navController)
        drawer.setNavigationItemSelectedListener { MenuItem ->
            when (MenuItem.itemId) {
                R.id.shareit -> callShareIntent()
                R.id.updateNews -> {
                    GlobalScope.launch { newsRepository.refreshNews() }
                    Toast.makeText(applicationContext, "Your News is Updated!!", Toast.LENGTH_SHORT)
                        .show()
                    return@setNavigationItemSelectedListener true
                }
                R.id.investor -> {
                    navController.navigate(LoginPageDirections.actionLoginPageToInvestor2())
                    return@setNavigationItemSelectedListener true
                }
                R.id.startup -> {
                    navController.navigate(LoginPageDirections.actionLoginPageToStartup())
                    return@setNavigationItemSelectedListener true
                }
                R.id.fragment_about -> {
                    navController.navigate(LoginPageDirections.actionLoginPageToFragmentAbout())
                    return@setNavigationItemSelectedListener true
                }
                R.id.personal -> {
                    navController.navigate(LoginPageDirections.actionLoginPageToPersonal())
                    return@setNavigationItemSelectedListener true
                }
                else -> return@setNavigationItemSelectedListener true

            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    fun shareIntent(): Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.shareMessage))
        return shareIntent
    }


}