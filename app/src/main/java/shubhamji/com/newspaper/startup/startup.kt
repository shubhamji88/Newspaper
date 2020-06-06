@file:Suppress("DEPRECATION")

package shubhamji.com.newspaper.startup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import shubhamji.com.newspaper.R
import shubhamji.com.newspaper.database.NewsDatabase
import shubhamji.com.newspaper.databinding.StartupBinding
import timber.log.Timber


@Suppress("DEPRECATION")
class startup: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : StartupBinding=DataBindingUtil.inflate(inflater,
            R.layout.startup,container,false)
        val application= requireNotNull(this.activity).application
        val datasource=NewsDatabase.getInstance(application).newsdatabaseDAO
        val viewModelFactory=startupViewModelFactory(datasource,application)
        val viewModel= ViewModelProviders.of(this,viewModelFactory).get(startupViewModel::class.java)
        binding.addnews.setOnClickListener {
            val title = binding.title.text.toString()
            val body = binding.details.text.toString()
            viewModel.addnews(title, body)
        }
        viewModel.newNews.observe(viewLifecycleOwner, Observer {
            Timber.i("the heading is ${it?.headline} and body is ${it?.body}")
        })
        return binding.root
    }
}
