# Draft Brasileirão

## Objetivo do Projeto
O projeto **Draft Brasileirão** tem como objetivo proporcionar uma experiência interativa de criação de times de futebol personalizados, inspirado no modo FutDraft do jogo FIFA. Os usuários podem selecionar uma formação tática, escolher jogadores para cada posição a partir de opções apresentadas aleatoriamente, revisar a formação do time e, por fim, salvar a equipe com um nome personalizado. Esta aplicação busca simular a estratégia envolvida na montagem de um time, permitindo explorar diferentes combinações e testar formações variadas.

## Estrutura do Projeto


- **MainActivity (Tela Inicial)**
  - Apresenta o título do aplicativo e um botão para iniciar o draft.
  - Inclui um ícone personalizado (`iconeapp`) na parte superior.

- **FormationActivity (Tela de Seleção de Formação)**
  - Permite que o usuário escolha a formação tática desejada (4-3-3).
  - Exibe a formação selecionada após a escolha.
  - Contém um `Fragment` para navegação, que inclui botões "Voltar" e "Avançar".

- **PlayerSelectionActivity (Tela de Seleção de Jogadores)**
  - Lista as posições de jogadores (ex.: GL, LD, ZAG1, ZAG2, etc.) e permite que o usuário selecione um jogador para cada posição a partir de um pop-up com três opções aleatórias.
  - Os jogadores selecionados são exibidos em tempo real nas respectivas posições.

- **TeamSummaryActivity (Tela de Resumo do Time)**
  - Apresenta a formação do time montado em um layout visual de campo de futebol.
  - Os jogadores selecionados são posicionados de acordo com a formação escolhida e exibidos abaixo das respectivas posições.

- **FinalizationActivity (Tela de Finalização)**
  - Permite inserir o nome da equipe e salvar o draft.
  - Contém um botão para reiniciar o processo e criar um novo draft.

- **Fragment (ButtonDetailsFragment)**
  - Um `Fragment` reutilizável que inclui botões "Voltar" e "Avançar".
  - Usado em múltiplas telas para navegação entre elas.

## Funcionamento do Fragment
O `ButtonDetailsFragment` foi projetado para ser incluído em várias telas e servir como uma interface de navegação reutilizável. Ele contém dois botões:
- **Botão "Voltar"**: Redireciona o usuário para a tela anterior.
- **Botão "Avançar"**: Leva o usuário para a próxima tela do processo de montagem do draft.

Este fragment é inserido em cada layout de tela usando a tag `<fragment>` e é gerenciado pela activity pai para definir as ações dos botões de navegação.

## Funcionamento das Telas
1. **Tela Inicial**: O usuário é recebido com o título "Draft Brasileirão" e um botão "Iniciar Draft".
2. **Seleção de Formação**: O usuário escolhe a formação desejada (ex.: 4-3-3) e avança para a próxima tela.
3. **Seleção de Jogadores**: O usuário escolhe jogadores para cada posição em um layout de lista. Ao clicar em uma posição, um pop-up com três opções de jogadores é exibido.
4. **Resumo do Time**: O time montado é exibido em um layout visual de campo, com os jogadores posicionados nas respectivas posições.
5. **Finalização**: O usuário pode inserir um nome e salvar o draft. Há também a opção de reiniciar e começar um novo draft.
