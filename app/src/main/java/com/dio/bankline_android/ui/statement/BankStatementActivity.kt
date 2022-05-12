package com.dio.bankline_android.ui.statement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.dio.bankline_android.R
import com.dio.bankline_android.databinding.ActivityBankStatementBinding
import com.dio.bankline_android.databinding.ActivityWelcomeBinding
import com.dio.bankline_android.domain.Correntista
import com.dio.bankline_android.domain.Movimentacao
import com.dio.bankline_android.domain.TipoMovimentacao
import java.lang.IllegalArgumentException

class BankStatementActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ACCOUNT_HOLDER = "com.dio.bankline_android.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private val binding by lazy {
        ActivityBankStatementBinding.inflate(layoutInflater)
    }

    private val accountHolder by lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER) ?: throw IllegalArgumentException()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()
    }

    private fun findBankStatement() {
        val dataSet = ArrayList<Movimentacao>()
        dataSet.add(Movimentacao(1 ,"11/05/22 21:24:55", "Lorem ipsum", 1000.0, TipoMovimentacao.RECEITA, 1))
        dataSet.add(Movimentacao(1 ,"11/05/22 21:24:55", "Lorem ipsum", 1000.0, TipoMovimentacao.DESPESA, 1))
        dataSet.add(Movimentacao(1 ,"11/05/22 21:24:55", "Lorem ipsum", 1000.0, TipoMovimentacao.RECEITA, 1))
        dataSet.add(Movimentacao(1 ,"11/05/22 21:24:55", "Lorem ipsum", 1000.0, TipoMovimentacao.DESPESA, 1))
        dataSet.add(Movimentacao(1 ,"11/05/22 21:24:55", "Lorem ipsum", 1000.0, TipoMovimentacao.RECEITA, 1))
        binding.rvBankStatement.adapter = BankStatementAdapter(dataSet)
    }
}