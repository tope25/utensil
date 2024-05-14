package kitchen.app.utensilwizard.utensils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kitchen.app.utensilwizard.R
import kitchen.app.utensilwizard.databinding.ActivityUtensilViewerBinding

@SuppressLint("SetJavaScriptEnabled", "SetTextI18n", "Deprecated")
class UtensilViewer : AppCompatActivity() {

    private lateinit var binding: ActivityUtensilViewerBinding
    private var exit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUtensilViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView: WebView = binding.webView
        val progressBar: ProgressBar = binding.progressBar

        if (isNetWorkConnected()) {
            val webSettings: WebSettings = webView.settings
            webSettings.javaScriptEnabled = true

            val url = intent.getStringExtra("url")

            webView.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    progressBar.visibility = ProgressBar.VISIBLE
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressBar.visibility = ProgressBar.GONE
                }

                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    return super.shouldOverrideUrlLoading(view, request)
                }
            }

            if (url != null) {
                webView.loadUrl(url)
            }
        } else {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isNetWorkConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        if (exit == 0) {
            exit = 1
            Toast.makeText(this, "PRESS AGAIN TO EXIT", Toast.LENGTH_SHORT).show()
        } else {
            super.onBackPressed()
            finishAffinity()
        }
    }
}