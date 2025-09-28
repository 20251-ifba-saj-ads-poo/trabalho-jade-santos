# Relatório de Avaliação - trabalho-jade-santos

Gestão de Academia de Ginástica

Modele um sistema para uma academia. A academia possui alunos, professores e diferentes modalidades de aulas (musculação, pilates, yoga). Cada aluno pode se inscrever em várias modalidades e cada professor pode ministrar várias aulas. Implemente funcionalidades para listar alunos por modalidade e professores responsáveis por cada aula.

## Resumo da Pontuação

| Critério | Pontuação Máxima | Pontuação Obtida | Comentários |
| --- | --- | --- | --- |
| **Interface Gráfica (JavaFX)** | **20** | **10** | A interface tenta abranger o escopo, mas o tratamento de erros é inexistente no padrão solicitado. |
| **Camada de Negócio** | **30** | **2** | A camada de serviço para a lógica principal do sistema não segue o padrão e não possui regras de negócio ou exceções. |
| **Camada de Dados** | **20** | **4** | Falha crítica ao misturar um esqueleto de persistência JPA com uma implementação principal em memória. |
| **Separação em Camadas** | **20** | **4** | A arquitetura em 3 camadas foi desconsiderada em favor de um padrão misto e confuso. |
| **Boas Práticas** | **10** | **1** | O código é desorganizado, mistura padrões e utiliza más práticas como listas estáticas para armazenamento de dados. |
| **Total** | **100** | **21** | |

---

## Pontos de Atenção

- **Falha Crítica de Arquitetura**: O projeto é uma mistura de duas aplicações distintas. Uma segue o esqueleto do modelo com JPA, mas não é usada. A outra, que implementa a lógica da academia, utiliza um padrão de repositórios e serviços em memória (Singletons) que ignora completamente a arquitetura solicitada (JPA, `Service<T>`, `Repository<T>`).
- **Modelo de Dados Incorreto**: As classes principais (`Aluno`, `Professor`, `Aula`) não são entidades JPA e não herdam de `AbstractEntity`. Os dados são armazenados em listas estáticas (`Biblioteca.java`), uma prática inadequada que não garante persistência.
- **Camada de Serviço Inexistente (para a lógica principal)**: A lógica de negócio da academia não possui uma camada de serviço que estenda `Service<T>`. As validações e regras de negócio são inexistentes ou não seguem o padrão de lançamento de exceções.
- **Separação de Camadas Comprometida**: A arquitetura de 3 camadas foi completamente ignorada na implementação principal do sistema, que se baseia em Singletons para acesso a dados em memória.
