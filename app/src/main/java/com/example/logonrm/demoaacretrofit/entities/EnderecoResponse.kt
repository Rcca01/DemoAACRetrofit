package com.example.logonrm.demoaacretrofit.entities

import android.arch.lifecycle.LiveData
import com.example.logonrm.demoaacretrofit.repositories.EnderecoRepository

class EnderecoResponse{

    var endereco:Endereco?
    var erro: Throwable?

    constructor(endereco: Endereco?){
        this.endereco = endereco
        this.erro = null
    }

    constructor(erro:Throwable){
        this.erro = erro
        this.endereco = null
    }
}

