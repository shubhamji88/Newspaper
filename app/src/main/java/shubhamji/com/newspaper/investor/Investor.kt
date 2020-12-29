package shubhamji.com.newspaper.investor

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import shubhamji.com.newspaper.MainActivity
import shubhamji.com.newspaper.R
import shubhamji.com.newspaper.database.NewsDatabase
import shubhamji.com.newspaper.databinding.InvestorBinding


class Investor:Fragment(){
    lateinit var viewModel: investorViewModel
    lateinit var viewModelFactory: investorViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: InvestorBinding =DataBindingUtil.inflate(inflater,R.layout.investor, container, false)
        (requireActivity() as MainActivity).supportActionBar!!.hide()
        val application = requireNotNull(this.activity).application
        val dataSource = NewsDatabase.getInstance(application).newsdatabaseDAO
        viewModelFactory =
            investorViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(investorViewModel::class.java)
        val adapter = InvestorAdapter(ClickListner { url: String ->
            view?.findNavController()?.navigate(InvestorDirections.actionInvestorToWebview2(url))
        })
        binding.newslist.adapter=adapter

        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            it.let {
                adapter.submitList(it)
            }
        })
        setHasOptionsMenu(true)

        return binding.root
    }
    private fun shareIntent(): Intent
    {
        val shareIntent= Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.shareMessage))
        return shareIntent
    }
    fun shareit()
    {
        startActivity(shareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu,menu)
        if(null==shareIntent().resolveActivity(activity!!.packageManager)){
            menu.findItem(R.id.share)?.setVisible(false)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.share -> shareit()
        }
        if(item.itemId.toString()=="share")
        {
            shareit()
        }
        return super.onOptionsItemSelected(item)
    }

}
