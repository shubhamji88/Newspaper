package shubhamji.com.newspaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
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
        val binding= DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout=binding.drawerLayout
        val database=NewsDatabase.getInstance(application)
        val newsRepository=NewsRepository(database)
        val navController=Navigation.findNavController(this, R.id.myNavHostFragment)
        //this is to display the backbutton and hamburger icon
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        fun shareIntent(): Intent
        {
            val shareIntent= Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT,"Hey there, Check this amazing Start-up News App and also invest in them")
            return shareIntent
        }
        fun shareit(): Boolean {
            startActivity(shareIntent())
            return true
        }

        NavigationUI.setupWithNavController(binding.drawer,navController)
        drawer.setNavigationItemSelectedListener { MenuItem->
            when(MenuItem.itemId){
                R.id.shareit->shareit()
                R.id.updateNews->{
                    GlobalScope.launch { newsRepository.refreshNews() }
                    Toast.makeText(applicationContext,"Your News is Updated!!",Toast.LENGTH_SHORT).show()
                    return@setNavigationItemSelectedListener true
                }
                else->return@setNavigationItemSelectedListener true

            }
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController=this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController,drawerLayout)
    }

}