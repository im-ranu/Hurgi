package com.hurgistore


import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import im.delight.android.webview.AdvancedWebView
import kotlinx.android.synthetic.main.activity_home.*


class home : AppCompatActivity(),AdvancedWebView.Listener {


//    lateinit var webView : WebView
    lateinit var mWebView : AdvancedWebView
    val url = "https://www.hurgi.in/"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        progress.bringToFront()
        mWebView = findViewById(R.id.webview);
        mWebView.setListener(this, this);
        mWebView.loadUrl(url);

       /* webView = findViewById(R.id.wb)

        webView.clearCache(true);
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = object : WebViewClient(){
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progress.setVisibility(ProgressBar.VISIBLE);
                webView.visibility = View.VISIBLE;
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progress.setVisibility(ProgressBar.GONE);
                webView.setVisibility(View.VISIBLE);
            }


            override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler,
                error: SslError?
            ) {
                handler.proceed() // Ignore SSL certificate errors
            }
        }

        webView.settings.setAppCacheEnabled(true);
        webView.settings.javaScriptEnabled = true
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webView.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
        };
        webView.settings.setSupportZoom(true);
        webView.loadUrl(url)*/

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
            if (event?.action == KeyEvent.ACTION_DOWN) {
                when (keyCode) {
                    KeyEvent.KEYCODE_BACK -> {
                        if (mWebView.canGoBack()) {
                            mWebView.goBack();
                        } else {
                            AlertDialog.Builder(this)
                                .setMessage("Are you sure you want to exit?")
                                .setCancelable(false)
                                .setPositiveButton(
                                    "Yes"
                                ) { dialog, id -> super@home.onBackPressed() }
                                .setNegativeButton("No", null)
                                .show()
                        }
                        return true;
                    }
                }

            }

        return super.onKeyDown(keyCode, event)
    }

    override fun onPageFinished(url: String?) {
        progress.visibility = View.GONE

    }

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {
    }

    override fun onDownloadRequested(
        url: String?,
        suggestedFilename: String?,
        mimeType: String?,
        contentLength: Long,
        contentDisposition: String?,
        userAgent: String?
    ) {
    }

    override fun onExternalPageRequest(url: String?) {
    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
        progress.visibility = View.VISIBLE
    }


}
