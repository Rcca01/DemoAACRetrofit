package com.example.logonrm.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import com.example.logonrm.demoaacretrofit.entities.EnderecoResponse

interface EnderecoRepository{
    fun buscarEndereco(cep:String): LiveData<EnderecoResponse>
}
