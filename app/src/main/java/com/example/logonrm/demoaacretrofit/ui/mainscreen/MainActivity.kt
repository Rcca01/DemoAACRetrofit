package com.example.logonrm.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.logonrm.demoaacretrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        btnPesquisar.setOnClickListener({
            if (!edCep.text.toString().isEmpty()){
                mainViewModel.pesquisarEndereco(edCep.text.toString())
            }else{
                Toast.makeText(this,"Informa um CEP",Toast.LENGTH_SHORT).show()
            }
        })

        mainViewModel.apiResponse.observe(this, Observer {
            apiResponse ->
            if (apiResponse?.erro == null){
                Log.i("TAG","SUCESSO")
                val end = apiResponse?.endereco
                tvResultado.text = "Logradouro: ${end?.logradouro}\n " +
                        "Complemento: ${end?.complemento}\n " +
                        "Bairro: ${end?.bairro}\n " +
                        "Localidade ${end?.localidade} - ${end?.uf}"
            }else{
                Log.i("TAG"," $(apiResponse.erro} ...")
            }
        })
        mainViewModel.isLoading.observe(this,
                Observer { isLoading ->
                    if(isLoading!!){
                        loading.visibility = View.VISIBLE
                    }else{
                        loading.visibility = View.GONE
                    }
                })
    }
}
