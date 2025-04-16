package com.example.dojunioraosenior

import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.SimpleExpandableListAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.dojunioraosenior.RegrasActivity

class RegrasActivity : AppCompatActivity() {

    private lateinit var expandableListView: ExpandableListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regras)

        expandableListView = findViewById(R.id.expandableListView)

        val listTitle = listOf(
            "1. Tempo e Rodadas",
            "2. Como Jogar",
            "3. Pré Jogo",
            "4. Primeira rodada e as demais",
            "5. Tipos de Casas",
            "6. Condição de Vitória",
            "7. Carta Desenvolvedor Full Stack",
            "8. Carta Engenheiro DevOps",
            "9. Carta Arquiteto de Software",
            "10. Carta Engenheiro de Qualidade de Software",
            "11. Carta Cientista de Dados",
            "12. Carta Engenheiro de Inteligência Artificial",
            "13. Carta Analista de Cibersegurança",
            "14. Carta Administrador de banco de dados"
        )

        val listDetail = hashMapOf(
            "1. Tempo e Rodadas" to listOf(
                "Jogue o dado para decidir a ordem dos turnos. Em seguida, definam quantas rodadas irão jogar.",
                "A rodada termina quando o jogador com o menor número no dado finalizar sua jogada.."
            ),
            "2. Como Jogar" to listOf(
                "Jogadores recomendados: 4",
                "Dados jogados por rodada: 1 por jogador",
                "Dinheiro inicial: 800 por jogador.",
                "Quantidade de rodas mínimas recomendadas: 10"
            ),
            "3. Pré Jogo" to listOf(
                "Todos jogam os dados, e se organizam em ordem de quem tirar o numero maior para pegar as cartas de carreira primeiro.",
            ),
            "4. Primeira rodada e as demais" to listOf(
                "Na sua vez role o dado o número que cair é o número de casas que você deve andar pelo tabuleiro ao cair em uma casa siga as instruções dadas or ela",
            ),
            "5. Tipos de Casas" to listOf(
                "Qualidade ou Defeito: Pegue uma carta com efeito permanente.",
                " Bônus: Pegue uma carta de efeito e utilize ela quando quiser.",
                "Procrastinação: Fique uma rodada parado.",
                " Host: Caso queira comprar uma host pague o valor dela e pegue sua respectiva carta.",
                "Atualização: Jogue um dado:\n 1 - 3: volte todas as casas que andou nessa rodada.\n 4 - 6: atualização bem sucedida, continue ",
                "Start: Casa de inicio",
                "BUG CRÍTICO Descrição: Seu código quebrou a produção! O sistema está fora do ar, e você precisa ficar aqui na próxima rodada resolvendo o problema\n Use uma carta especial que permita a saída antecipada \n Pague $150 para acelerar o hotfix e sair imediatamente.\n  Role um dado: se tirar 5 ou 6, você resolve o problema e sai imediatamente.",
                " STARTUP: Descrição: Você encontrou uma oportunidade de investimento! Aqui, você não paga nada e pode receber bônus especiais dependendo do que já conquistou no jogo. \n Se tiver hospedagem de aplicativos, receba \$100 extra \n Ou tente a sorte e faça um investimento relâmpago de R$100. Role um dado:  4-6:  Dobre o valor investido   1-3: Investimento deu errado, Pague R$300. ",
                "INOVAÇÃO DISRUPTIVA: Descrição: Você investiu em uma tecnologia inovadora, mas o custo de desenvolvimento foi alto! Para manter sua vantagem competitiva, é preciso um grande investimento. \n Pague R$250 para bancar os custos de pesquisa e desenvolvimento \n Use uma carta especial que permita a saída imediatamente. \n ou Tente a sorte: 1-3: O investimento não deu retorno imediato, pague R$300. 4-6: Sua inovação foi um sucesso! Pague apenas RS 150 e ganhe uma carta de Qualidade."
            ),
            "6. Condição de Vitória" to listOf(
                "Após a última rodada, conte os pontos. O jogador com a maior pontuação vence."
            ),
            "7. Carta Desenvolvedor Full Stack" to listOf(
                "Carreira: Profissional que atua no desenvolvimento tanto da interface visual quanto da estrutura interna dos sistemas.",
                "   1. Ele programa o front-end, garantindo que o usuário tenha uma boa experiência ao interagir com a aplicação, criando interfaces intuitivas e responsivas.",
                "   2. Também desenvolve o back-end, escrevendo a lógica do sistema, integrando bancos de dados e garantindo que todas as funcionalidades operem corretamente.",
                "   3. Seu trabalho envolve equilibrar desempenho, segurança e usabilidade, tornando o software eficiente e agradável para os usuários finais."
            ),
            "8. Carta Engenheiro DevOps" to listOf(
                "Carreira: Especialista que automatiza processos e melhora a integração entre desenvolvimento e operações.",
                "   1. Ele cria pipelines de CI/CD (Integração Contínua e Entrega Contínua) para automatizar testes e deploys, reduzindo erros e tornando os lançamentos mais rápidos.",
                "   2. Trabalha com infraestrutura como código, monitoramento de servidores e escalabilidade, garantindo que os sistemas rodem de maneira estável e segura.",
                "   3. Sua função é essencial para otimizar a colaboração entre desenvolvedores e administradores de sistemas, reduzindo o tempo entre desenvolvimento e entrega do produto final."
            ),
            "9. Carta Arquiteto de Software" to listOf(
                "Carreira: Profissional que define a estrutura e tecnologias usadas em um sistema.",
                "   1. Ele projeta a arquitetura dos sistemas, decidindo como os componentes de software se conectam e se comunicam, garantindo um design eficiente e sustentável.",
                "   2. Escolhe as melhores tecnologias, frameworks e padrões de desenvolvimento para que o software seja seguro, escalável e fácil de manter no futuro.",
                "   3. Seu trabalho previne problemas estruturais que poderiam comprometer o desempenho da aplicação, assegurando que ela possa crescer sem precisar ser totalmente refeita."
            ),
            "10. Carta Engenheiro de Qualidade de Software" to listOf(
                "Carreira: Responsável por testar e garantir a qualidade dos softwares antes de chegarem ao usuário.",
                "   1. Ele realiza testes manuais e automatizados para encontrar falhas que possam comprometer o funcionamento do software, garantindo que o produto final seja confiável.",
                "   2. Trabalha com testes de desempenho, segurança e usabilidade para assegurar que o sistema funcione bem em diferentes cenários e dispositivos.",
                "   3. Seu papel é fundamental para evitar que erros cheguem aos usuários finais, melhorando a experiência do cliente e reduzindo custos com correções futuras."
            ),
            "11. Carta Cientista de Dados" to listOf(
                "Carreira: Profissional que analisa grandes volumes de dados para extrair informações valiosas.",
                "   1. Ele utiliza estatística e programação para processar e interpretar dados, descobrindo padrões que ajudam empresas a tomar decisões mais estratégicas",
                "   2. Trabalha com inteligência artificial, aprendizado de máquina e algoritmos preditivos para transformar dados brutos em insights úteis.",
                "   3. Seu trabalho é essencial para setores como marketing, saúde e finanças, ajudando a prever tendências e otimizar operações com base em dados concretos."
            ),
            "12. Carta Engenheiro de Inteligência Artificial" to listOf(
                "Carreira: Especialista em criar algoritmos que permitem que máquinas aprendam e tomem decisões.",
                "   1. Ele desenvolve modelos de aprendizado de máquina e redes neurais que possibilitam desde reconhecimento facial até carros autônomos e assistentes virtuais.",
                "   2. Trabalha na otimização de algoritmos para que máquinas possam aprender com o tempo e melhorar suas respostas com base nos dados analisados",
                "   3. Sua área de atuação é fundamental para o avanço da automação e da tecnologia, impactando desde o entretenimento até a medicina e a indústria"
            ),
            "13. Carta Analista de Cibersegurança" to listOf(
                "Carreira: Profissional que protege sistemas contra ataques e invasões.",
                "   1. Ele analisa e identifica vulnerabilidades em redes, servidores e sistemas, desenvolvendo estratégias para impedir ataques e invasões de hackers",
                "   2. Implementa sistemas de defesa como firewalls, criptografia e testes de invasão (pentesting) para reforçar a segurança digital.",
                "   3. Trabalha em empresas, bancos e órgãos governamentais garantindo a proteção de informações sensíveis, evitando prejuízos financeiros e vazamento de dados."
            ),
            "14. Carta Administrador de banco de dados" to listOf(
                "Carreira: Responsável por gerenciar e otimizar grandes volumes de informações",
                "   1. Ele estrutura, mantém e otimiza bancos de dados para garantir que informações sejam armazenadas de forma segura e possam ser acessadas rapidamente.",
                "   2. Trabalha na implementação de backups e recuperação de dados, prevenindo perdas de informações em caso de falhas no sistema.",
                "   3. Seu trabalho é essencial para empresas que lidam com grandes volumes de dados, garantindo que as operações sejam rápidas e eficientes."
            ),
        )

        val groupList = listTitle.map { mapOf("TITLE" to it) }

        val childList: List<List<Map<String, String>>> = listTitle.map { title ->
            listDetail[title]!!.map { rule ->
                mapOf("CONTENT" to rule)
            }
        }

        val adapter = SimpleExpandableListAdapter(
            this,
            groupList,
            android.R.layout.simple_expandable_list_item_1,
            arrayOf("TITLE"),
            intArrayOf(android.R.id.text1),
            childList,
            android.R.layout.simple_list_item_1,
            arrayOf("CONTENT"),
            intArrayOf(android.R.id.text1)
        )

        expandableListView.setAdapter(adapter)

        val backButton: com.google.android.material.floatingactionbutton.FloatingActionButton =
            findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

    }

}
