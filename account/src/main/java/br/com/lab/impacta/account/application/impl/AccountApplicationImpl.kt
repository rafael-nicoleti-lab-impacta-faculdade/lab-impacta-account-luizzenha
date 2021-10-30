package br.com.lab.impacta.account.application.impl

import br.com.lab.impacta.account.application.AccountApplication
import br.com.lab.impacta.account.application.adapter.AccountAdapter
import br.com.lab.impacta.account.application.dto.request.DebitAccountRequest
import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse
import br.com.lab.impacta.account.application.dto.response.DebitAccountResponse
import br.com.lab.impacta.account.model.Account
import br.com.lab.impacta.account.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AccountApplicationImpl (
    private val accountService: AccountService
    ) : AccountApplication {


    override fun balance(accountId: Long): AccountBalanceResponse {
        val account: Account = accountService.findAccount(accountId)
        return AccountAdapter.toDtoBalance(account)
    }

    override fun debit(accountId: Long, debitAccountRequest: DebitAccountRequest): DebitAccountResponse {
        accountService.debitAccount(accountId, debitAccountRequest.valueOfDebit)
        return DebitAccountResponse(true)
    }

}