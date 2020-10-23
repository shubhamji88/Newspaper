@file:Suppress("DEPRECATION")

package shubhamji.com.newspaper.startup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import shubhamji.com.newspaper.MainActivity
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
        (requireActivity() as MainActivity).supportActionBar!!.hide()
        binding.addnews.setOnClickListener {
            val title = binding.title.text.toString()
            val body = binding.details.text.toString()
            val name=binding.NameDetails.text.toString()
            val date=binding.DateDetails.text.toString()
            val website="https://www."+binding.Website.text.toString()
//            Toast.makeText(context,"title=${title},body=${body},name=${name},date=$date",Toast.LENGTH_LONG).show()
            viewModel.addnews(title, body,name,date,website)
            findNavController().navigate(R.id.action_startup_to_loginPage)
            Snackbar.make(
                activity!!.findViewById(android.R.id.content),
                "Your News was added Successfully!!",
                Snackbar.LENGTH_SHORT // How long to display the message.
            ).show()

        }
//        viewModel.newNews.observe(viewLifecycleOwner, Observer {
//            Toast(context,"heading ${it?.title} body ${it?.description}name${it?.author}published${it?.publishedAt}",Toast.LENGTH_SHORT).show()
//        })
        return binding.root
    }
}
