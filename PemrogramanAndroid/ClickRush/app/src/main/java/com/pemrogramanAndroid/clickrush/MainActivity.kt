package com.PemrogramanAndroid.clickrush

import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.PemrogramanAndroid.clickrush.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var vScore = 0
    private var time = 60
    private lateinit var countDownTimer: CountDownTimer
    private var timeRunning = false
    private lateinit var scaleAnim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btTap.setOnClickListener {
            if (time > 0) {
                vScore++
                binding.tvScore.text = vScore.toString()
                binding.btTap.startAnimation(scaleAnim)
            }
            if (!timeRunning) {
                timeRunning = true
                startTimer()
            }
        }

        // Load animation from resources
        scaleAnim = AnimationUtils.loadAnimation(this, R.anim.scale_animation)

        if (savedInstanceState != null) {
            vScore = savedInstanceState.getInt("skor")
            time = savedInstanceState.getInt("waktu")
            val pesan = savedInstanceState.getString("isiPesan")
            pesan?.let { binding.textView.text = it }
        }

        setupTimer()
    }

    private fun setupTimer() {
        countDownTimer = object : CountDownTimer(time.toLong() * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                time--
                binding.tvTime.text = time.toString()
            }

            override fun onFinish() {
                val pesan = "Time's up! Your score was: $vScore"
                binding.textView2.text = pesan
                vScore = 0
                binding.tvScore.text = vScore.toString()
                time = 60
                binding.tvTime.text = time.toString()
                timeRunning = false
                binding.btTap.isEnabled = true
            }
        }
    }

    private fun startTimer() {
        countDownTimer.start()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("skor", vScore)
        outState.putInt("waktu", time)
        outState.putString("isiPesan", binding.textView.text.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.infoDetail) {
            showAboutDialog()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    private fun showAboutDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("About")
            .setMessage("Clickrush 1.0\nCreated by 71200654 Effie Rambu Boba")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }

        val dialog = builder.create()
        dialog.show()
    }
}