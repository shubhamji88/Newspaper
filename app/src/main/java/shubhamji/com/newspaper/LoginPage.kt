package shubhamji.com.newspaper

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import shubhamji.com.newspaper.LoginPageDirections

import shubhamji.com.newspaper.databinding.LoginpageBinding
import timber.log.Timber

class LoginPage: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
         container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    val binding= DataBindingUtil.inflate<LoginpageBinding>(inflater,
        R.layout.loginpage,container,false)
        binding.investorNav.setOnClickListener{view : View->
            view.findNavController().navigate(
                LoginPageDirections.actionLoginPageToInvestor2(
                    "Nothing new"
                )
            )

        }
        binding.startupNav.setOnClickListener{view :View->
            view.findNavController().navigate(R.id.action_loginPage_to_startup)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    private fun shareIntent(): Intent {
        val intent=Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT,"Check This NEW START UP NEWS APP")
        return intent

    }
    private fun share()
    {
        startActivity(shareIntent())
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.share ->share()
        }
        return super.onOptionsItemSelected(item)
                || NavigationUI.onNavDestinationSelected(item,view!!.findNavController())
    }

}