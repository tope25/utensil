package kitchen.app.utensilwizard.utensils

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kitchen.app.utensilwizard.MainActivity
import kitchen.app.utensilwizard.R
import kitchen.app.utensilwizard.adapter.utensilAsk
import kitchen.app.utensilwizard.databinding.ActivityUtensilResultsBinding

class UtensilResults : AppCompatActivity() {

    private lateinit var binding: ActivityUtensilResultsBinding
    private var score = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUtensilResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        score = intent.getIntExtra("userScore", 0)

        val scoreView = binding.pointViewer
        scoreView.text = "Your Score: $score / ${utensilAsk.size}"

        val resultView = binding.resultText
        when (score) {
            in 0 until utensilAsk.size -> {
                resultView.text = "Sorry"
            }

            utensilAsk.size -> {
                resultView.text = "YOU GOT PERFECT SCORE!"
            }

            else -> {
                resultView.text =
                    "Nice try! You got $score out of ${utensilAsk.size} correct answer"
            }
        }
        val tryText = binding.buttonBack
        tryText.paintFlags = tryText.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        binding.buttonBack.setOnClickListener {
            startActivity(Intent(this, UtensilQuiz::class.java))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}