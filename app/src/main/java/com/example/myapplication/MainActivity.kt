package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var zamandurdur: Long =0
        binding.button.setOnClickListener {

            binding.kronom.base=SystemClock.elapsedRealtime()+zamandurdur
            //base zamana sistem saatinini ve basşlangıçtaki değişkeni ekiliyoruz. sistem saati kronomerenin sen durdursan bile başlangıçtan itibaren çalıştığı zamanı temsil ediyor
            binding.kronom.start()
            //başlat
            binding.button.visibility= View.GONE
            //başla butonunu görünmez yapıp durdur butornunu görünür yapıyorz
            binding.buttonpause.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))

        }
        binding.buttonpause.setOnClickListener {
            zamandurdur= binding.kronom.base-SystemClock.elapsedRealtime()
            //startta kaldığı yerden devam edebilmesi için bu çıkarma işlemi yapılıyor
            binding.kronom.stop()

            binding.buttonpause.visibility= View.GONE
            //başla butonunu görünmez yapıp durdur butornunu görünür yapıyorz
            binding.button.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }
        binding.button3.setOnClickListener {
            binding.kronom.base=SystemClock.elapsedRealtime();
            //startta kaldığı yerden devam edebilmesi için bu çıkarma işlemi yapılıyor
            binding.kronom.stop()
            zamandurdur=0

            binding.buttonpause.visibility= View.GONE
            //başla butonunu görünmez yapıp durdur butornunu görünür yapıyorz
            binding.button.visibility= View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }





    }
}