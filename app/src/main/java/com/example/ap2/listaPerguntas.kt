package com.example.ap2

object listaPerguntas {

    var nomeUsuario = "nome"
    var resultado = 0

    val perguntas = listOf(
        perguntas(
            texto  = "Você reutiliza senhas em diferentes contas?",
            opcoes = listOf(
                "Sim, uso a mesma senha para várias contas.",
                "Uso senhas parecidas, mas altero algumas coisas.",
                "Não, cada conta tem uma senha única e forte."
            ),
            resultado = listOf(-2, -1, 2)
        ),
        perguntas(
            texto = "Você usa autenticação de dois fatores (2FA)?",
            opcoes = listOf(
                "Não, nunca usei.",
                "Uso em algumas contas importantes.",
                "Sim, uso em todas as contas que oferecem essa opção."
            ),
            resultado = listOf(-3, 1, 3)
        ),
        perguntas(
            texto = "Com que frequência você atualiza suas senhas?",
            opcoes = listOf(
                "Nunca ou raramente.",
                "Atualizo de tempos em tempos, mas sem uma frequência definida.",
                "Atualizo regularmente, pelo menos a cada 3-6 meses."
            ),
            resultado = listOf(-2, 1, 2)
        ),
        perguntas(
            texto = "Você costuma verificar a confiabilidade de e-mails antes de clicar em links ou baixar arquivos?",
            opcoes = listOf(
                "Não verifico, confio na aparência do e-mail.",
                "Verifico apenas se o e-mail parecer suspeito.",
                "Sempre verifico, mesmo que o e-mail pareça confiável."
            ),
            resultado = listOf(-2, 1, 2)
        ),
        perguntas(
            texto = "Você usa Wi-Fi público sem VPN para acessar contas ou serviços sensíveis?",
            opcoes = listOf(
                "Sim, com frequência.",
                "Uso, mas evito acessar serviços importantes.",
                "Não, sempre uso VPN ou evito Wi-Fi público."
            ),
            resultado = listOf(-3, -1, 3)
        )
    )
}
