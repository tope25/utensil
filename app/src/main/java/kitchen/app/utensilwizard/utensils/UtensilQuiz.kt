package kitchen.app.utensilwizard.utensils

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.RadioButton
import kitchen.app.utensilwizard.R
import kitchen.app.utensilwizard.adapter.utensilAsk
import kitchen.app.utensilwizard.databinding.ActivityUtensilQuizBinding

class UtensilQuiz : AppCompatActivity() {

    private lateinit var binding: ActivityUtensilQuizBinding
    private var currentUtensilTrivia = 0
    private var score = 0
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUtensilQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showUtensilQuestion(currentUtensilTrivia)
        startTimer()
    }

    private fun showUtensilQuestion(index: Int) {
        val question = utensilAsk[index]
        binding.questionTextView.text = question.utensilAsk
        binding.utensilGroup.clearCheck()
        for (i in 0 until question.utensilQuestions.size) {
            (binding.utensilGroup.getChildAt(i) as RadioButton).text = question.utensilQuestions[i]
        }
    }

    private fun correctAnswer() {
        val chooseOptionId = binding.utensilGroup.checkedRadioButtonId
        if (chooseOptionId != -1) {
            val choosedOptId = binding.utensilGroup.indexOfChild(findViewById(chooseOptionId))
            val rightAnswer = utensilAsk[currentUtensilTrivia].utensilAnswer
            if (choosedOptId == rightAnswer) {
                score++
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun startTimer() {
        timer = object : CountDownTimer(6000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000 - 0
                binding.timerTextView.text = secondsRemaining.toString()
            }

            override fun onFinish() {
                correctAnswer()
                currentUtensilTrivia++
                if (currentUtensilTrivia < utensilAsk.size) {
                    showUtensilQuestion(currentUtensilTrivia)
                    startTimer()
                } else {
                    val intent = Intent(this@UtensilQuiz, UtensilResults::class.java)
                    intent.putExtra("userScore", score)
                    startActivity(intent)
                    timer.cancel()
                }
            }
        }.start()
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }
}