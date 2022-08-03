package me.dio.cartaodevisitas.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import me.dio.cartaodevisitas.App
import me.dio.cartaodevisitas.R
import me.dio.cartaodevisitas.data.BusinessCard
import me.dio.cartaodevisitas.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnConfirmar.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tillNome.editText?.text.toString(),
                empresa = binding.tillEmpresa.editText?.text.toString(),
                telefone = binding.tillTelefone.editText?.text.toString(),
                email = binding.tillEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tillCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}