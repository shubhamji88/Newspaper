@file:Suppress("DEPRECATION")

package shubhamji.com.newspaper.startup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import shubhamji.com.newspaper.MainActivity
import shubhamji.com.newspaper.R
import shubhamji.com.newspaper.database.NewsDatabase
import shubhamji.com.newspaper.databinding.StartupBinding


@Suppress("DEPRECATION")
class startup: Fragment() {
    private lateinit var viewModel: startupViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : StartupBinding=DataBindingUtil.inflate(inflater,
            R.layout.startup,container,false)
        val application= requireNotNull(this.activity).application
        val datasource=NewsDatabase.getInstance(application).newsdatabaseDAO
        val viewModelFactory=startupViewModelFactory(datasource,application)
        viewModel= ViewModelProviders.of(this,viewModelFactory).get(startupViewModel::class.java)
        (requireActivity() as MainActivity).supportActionBar!!.hide()
        binding.addnews.setOnClickListener {
            addNewsClickListner(it,binding)

        }
        return binding.root
    }

    private fun addNewsClickListner(view: View?,binding : StartupBinding) {
        val title = binding.title.text.toString()
        val body = binding.details.text.toString()
        val name=binding.NameDetails.text.toString()
        val date=binding.DateDetails.text.toString()
        val website="https://www."+binding.Website.text.toString()
        viewModel.addnews(title, body,name,date,website)
        findNavController().navigate(R.id.action_startup_to_loginPage)
        Snackbar.make(
            activity!!.findViewById(android.R.id.content),
            "Your News was added Successfully!!",
            Snackbar.LENGTH_SHORT
        ).show()

    }

}
