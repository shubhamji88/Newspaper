package shubhamji.com.newspaper.investor

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import shubhamji.com.newspaper.R
import shubhamji.com.newspaper.database.NewsDatabase
import shubhamji.com.newspaper.database.stack.Stack.Companion.stack
import shubhamji.com.newspaper.databinding.InvestorBinding


@Suppress("DEPRECATION")
class Investor:Fragment(){
    lateinit var viewModel: investorViewModel
    lateinit var viewModelFactory: investorViewModelFactory
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : InvestorBinding=
            DataBindingUtil.inflate(inflater,
                R.layout.investor, container, false)
        val application= requireNotNull(this.activity).application
        val dataSource=NewsDatabase.getInstance(application).newsdatabaseDAO
        viewModelFactory=
            investorViewModelFactory(dataSource,application)
        viewModel= ViewModelProviders.of(this,viewModelFactory).get(investorViewModel::class.java)
        val adapter=InvestorAdapter(ClickListner{ url: String->
//            Toast.makeText(context,"url is : ${url}",Toast.LENGTH_SHORT).show()
            view?.findNavController()?.navigate(InvestorDirections.actionInvestorToWebview2(url))
        })
        binding.newslist.adapter=adapter
        viewModel.heading.observe(viewLifecycleOwner, Observer {
            it.let{
//                adapter.submitList(it)
                adapter.submitList(stack)
            }
        })
        setHasOptionsMenu(true)

        return binding.root
    }
    private fun shareIntent(): Intent
    {
        val shareIntent= Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT,"Hey there, Check this amazing Start-up News App and also invest in them")
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
//    fun Click(url: String){
//        Toast.makeText(context,url,Toast.LENGTH_SHORT).show()
//        view?.findNavController()?.navigate(InvestorDirections.actionInvestorToWebview2(url))
//    }
}
