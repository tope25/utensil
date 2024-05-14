package kitchen.app.utensilwizard.utensils

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kitchen.app.utensilwizard.R
import kitchen.app.utensilwizard.databinding.ActivityUtensilContentBinding

class UtensilContent : AppCompatActivity() {

    private lateinit var binding: ActivityUtensilContentBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUtensilContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve extras and set the content
        val imageResource = intent.getIntExtra("image", -1)
        val contentResource = intent.getStringArrayExtra("content")

        if (imageResource != -1 && contentResource != null) {
            binding.wonderViews.setImageResource(imageResource)

            val utensilArrayContent = contentResource.joinToString("\n\n")
            binding.wonderContent.text = utensilArrayContent
        } else {
            // Handle the case when the extras are missing
            binding.wonderContent.text = "Content not available"
        }

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
    }
}
