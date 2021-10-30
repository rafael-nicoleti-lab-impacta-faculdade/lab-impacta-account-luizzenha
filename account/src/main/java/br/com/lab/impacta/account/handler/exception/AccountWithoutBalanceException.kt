package br.com.lab.impacta.account.handler.exception

import java.lang.RuntimeException

class AccountWithoutBalanceException(override val message: String,
                                     val description: String) : RuntimeException(message) {


}