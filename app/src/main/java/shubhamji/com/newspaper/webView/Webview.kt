package shubhamji.com.newspaper.webView

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.webview.*
import shubhamji.com.newspaper.R
import shubhamji.com.newspaper.databinding.WebviewBinding

class Webview : Fragment() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: WebviewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.webview,
            container,
            false
        )

        val fabButton=binding.floatingActionButton

        fabButton.setOnClickListener { view ->
            if(webview.canGoBack()){
                webview.goBack()
            }
            else{
                view.findNavController().navigate(WebviewDirections.actionWebview2ToInvestor())
            }
        }

        val webview = binding.webview

        setupWebview(webview)


        return binding.root
    }

    private fun setupWebview(webview: WebView) {
        val url = WebviewArgs.fromBundle(arguments!!)
        true.also { webview.settings.javaScriptEnabled = it }
        webview.webViewClient = WebViewClient()
        webview.webChromeClient = WebChromeClient()
        webview.loadUrl(url.urlString)
    }


}

