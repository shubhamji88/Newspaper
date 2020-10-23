package shubhamji.com.newspaper.personal

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import shubhamji.com.newspaper.MainActivity
import shubhamji.com.newspaper.R
import shubhamji.com.newspaper.databinding.LoginpageBinding
import shubhamji.com.newspaper.databinding.PersonalFragmentBinding
class personal : Fragment() {

    companion object {
        fun newInstance() = personal()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= DataBindingUtil.inflate<PersonalFragmentBinding>(inflater,
            R.layout.personal_fragment,container,false)
        (requireActivity() as MainActivity).supportActionBar!!.hide()

        return binding.root

    }

}