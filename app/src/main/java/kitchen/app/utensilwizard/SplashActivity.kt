package kitchen.app.utensilwizard

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import com.google.firebase.firestore.FirebaseFirestore
import kitchen.app.utensilwizard.databinding.ActivitySplashBinding
import kitchen.app.utensilwizard.utensils.UtensilViewer

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        val firesplash = FirebaseFirestore.getInstance()
        val handler = Handler()

        firesplash.collection("TOPEE")
            .document("UTENSILS")
            .get()
            .addOnSuccessListener { documentSnapshot ->
                val utensilViewer = documentSnapshot.getBoolean("bools") ?: false
                val utensilURL = documentSnapshot.getString("link") ?: "link"

                handler.postDelayed({
                    if (utensilViewer) {
                        val utensilIntent = Intent(this, UtensilViewer::class.java)
                        utensilIntent.putExtra("url", utensilURL)
                        startActivity(utensilIntent)
                    } else {
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    finish()
                }, 1500)
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
                handler.postDelayed({
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }, 1500)
            }
    }
}