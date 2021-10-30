package br.com.lab.impacta.account.api

import br.com.lab.impacta.account.application.AccountApplication
import br.com.lab.impacta.account.application.dto.request.DebitAccountRequest
import br.com.lab.impacta.account.application.dto.response.DebitAccountResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/accounts")
class DebitController (
    @Autowired var accountApplication: AccountApplication){

    @PostMapping("/{accountId}/debit")
    fun debit(@PathVariable accountId: Long, @RequestBody debitAccountRequest: DebitAccountRequest):
            ResponseEntity<DebitAccountResponse> {
        val debitAccountResponse = accountApplication.debit(accountId, debitAccountRequest)

        return ResponseEntity.ok(debitAccountResponse)
    }
}