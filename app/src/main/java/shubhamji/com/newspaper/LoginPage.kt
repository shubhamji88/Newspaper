package shubhamji.com.newspaper

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import shubhamji.com.newspaper.databinding.LoginpageBinding
class LoginPage: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<LoginpageBinding>(
            inflater,
            R.layout.loginpage, container, false
        )


        binding.investorNav.setOnClickListener { view: View ->
            view.findNavController().navigate(
                LoginPageDirections.actionLoginPageToInvestor2()
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
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.shareMessage))
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
            R.id.shareit ->share()
        }
        return super.onOptionsItemSelected(item)
                || NavigationUI.onNavDestinationSelected(item,view!!.findNavController())
    }

    override fun onStart() {
        setupActionBar()
        super.onStart()
    }

    private fun setupActionBar() {
        val tool = (requireActivity() as MainActivity).supportActionBar!!
        tool.show()
        tool.setTitle("        SILICON PAPER")
    }

}
