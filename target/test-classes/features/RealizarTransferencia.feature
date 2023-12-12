#language: pt

Funcionalidade: Validar o fluxo de transferência entre contas


  Esquema do Cenario: Realizar a transferencia entre contas

    Dado que estou na pagina de inicio do Bug Bank
    Quando clico em Registrar para a primeira conta
    E preencho os dados de registro corretamente para a primeira conta, informando <Email1>, <Nome1>, <Senha1> e <ConfirmacaoSenha1>
    E seleciono criar conta com saldo para a primeira conta
    E clico no botao cadastrar para cadastrar a primeira conta
    Entao deve aparecer a mensagem sinalizando que a primeira conta foi criada com sucesso

    Dado que clico no botão fechar
    E clico em Registrar para a segunda conta
    Quando preencho os dados de registro corretamente para a segunda conta, informando <Email2>, <Nome2>, <Senha2> e <ConfirmacaoSenha2>
    E validar que a segunda conta tenha saldo
    E clico no botão cadastrar para cadastrar a segunda conta
    Entao deve aparecer a mensagem sinalizando que a segunda conta foi criada com sucesso

    Dado que clico no botão fechar
    E que estou na tela de login do Bug Bank
    Quando preencho os dados de login corretamente para a primeira conta, informando <Email1> e <Senha1>
    Entao o usuario deve ser logado com sucesso

    Dado que valido o saldo para a primeira conta
    E que clico em transferencia
    Quando preencho os dados para transferencia corretamente, informando a conta, digito, valor e descricao
    Entao deve aparecer a mensagem sinalizando que a transferencia de valor para a conta foi realizada com sucesso

    Dado que retorno a tela de inicio da primeira conta
    Entao deve aparecer o saldo corretamente para primeira conta

    Dado clico em sair
    E que estou na tela de login do Bug Bank
    Quando preencho os dados de login corretamente para a segunda conta, informando <Email2> e <Senha2>
    Entao o usuario deve ser logado com sucesso

    Dado que estou na tela de inicio da segunda conta
    Entao deve aparecer o saldo corretamente para a segunda conta


    Exemplos:
      | Email1                    | Nome1            | Senha1      | ConfirmacaoSenha1 | Email2                      | Nome2           | Senha2       | ConfirmacaoSenha2 |
      | "kaiquerenling@gmail.com" | "Kaique Renling" | "k10080705" | "k10080705"       | "kaiquerenling96@gmail.com" | "Kaique Doval"  | "k10080706"  | "k10080706"       |


