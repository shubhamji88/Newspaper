package shubhamji.com.newspaper.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import shubhamji.com.newspaper.MainActivity
import shubhamji.com.newspaper.R
import shubhamji.com.newspaper.databinding.PersonalFragmentBinding

class personal : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding= DataBindingUtil.inflate<PersonalFragmentBinding>(inflater,
            R.layout.personal_fragment,container,false)
        (requireActivity() as MainActivity).supportActionBar!!.hide()
        return binding.root

    }

}