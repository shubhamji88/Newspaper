package shubhamji.com.newspaper.webView

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.webview.*
import shubhamji.com.newspaper.R
import shubhamji.com.newspaper.databinding.WebviewBinding

class Webview : Fragment() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: WebviewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.webview,
            container,
            false
        )

        val url = WebviewArgs.fromBundle(arguments!!)
        val webview = binding.webview
        val webSettings = webview.settings
        webSettings.javaScriptEnabled = true
        webview.webViewClient = WebViewClient()
        webview.webChromeClient = WebChromeClient()
        webview.loadUrl(url.urlString)


        return binding.root
    }

}

