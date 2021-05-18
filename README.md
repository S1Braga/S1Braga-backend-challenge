Bem-vindo ao Desafio de Aptidão SWAT-Intel. Você pode desenvolver seu trabalho da seguinte maneira:

Missão: Criar uma API REST de pesquisa de rota de transporte de suprimentos

Tempo estimado 4 horas

Premissas:

A API REST deve ser escrita em Java / Kotlin com Spring ou C # com .NET Core.
O banco de dados não é necessário.
O que será avaliado:

Qualidade do código e da solução
Os recursos (neste repositório) que você deve usar:

Há um CSV da iTrain e um JSON da UberOnRails , cada um com uma lista de viagens de trem agendadas pela empresa entre 2021/02/10 e 2021/02/18.
Um JSON das estações de trem disponíveis.
Eles são estruturados da seguinte forma:
eu treino

Campo	Formato
trip_number	Alfanumérico (comprimento de 6 caracteres)
origin_station	Alfanumérico (comprimento de 3 caracteres)
destiny_station	Alfanumérico (comprimento de 3 caracteres)
data	DATA
departure_time	TEMPO
tempo de chegada	TEMPO
preço	decimal
UberOnRails

Campo	Formato
viagem	Alfanumérico (comprimento de 8 caracteres)
origem	Alfanumérico (comprimento de 3 caracteres)
destino	Alfanumérico (comprimento de 3 caracteres)
data de partida	DATA
partida	TEMPO
chegada	TEMPO
valor	decimal
Estações de trem

Campo	Formato
nome	Alfanumérico
estação	Alfanumérico (comprimento de 3 caracteres)
cidade	Alfanumérico
Objetivo A:

Fornecer 1 (um) endpoint que receba Origin station, Destiny statione opcionalmente Trip datecritérios e retorne um JSON com todas as rotas disponíveis (compostas por uma ou mais viagens) das duas empresas (iTrain e UberOnRails) atendendo aos critérios de pesquisa, ordenados por data e horário de chegada.
As conexões de viagem podem ser utilizadas desde que o intervalo entre as viagens seja igual ou inferior a 12 horas.
Uma viagem do iTrain pode se conectar com uma viagem do UberOnRails, não há problema nisso.
O máximo de conexões de viagem depende de você.
Objetivo B:

Fornece 1 (um) ponto de extremidade que retorna a lista de todas as estações de trem que correspondem total ou parcialmente a um Station namecritério.
Os critérios não devem ser exigidos para usar o terminal.
A correspondência de criteira não deve ser sensível a maiúsculas e minúsculas.
Exemplo de resposta:

[
	{
		" origem " : " GRU " ,
		 " destino " : " LOA " ,
		 " partida " : " AAAA-MM-DDTHH: mm: ss.sssZ " ,
		 " chegada " : " AAAA-MM-DDTHH: mm: ss.sssZ " ,
		 " etapas " : [
			{
				" origem " : " GRU " ,
				 " destino " : " NYC " ,
				 " partida " : " AAAA-MM-DDTHH: mm: ss.sssZ " ,
				 " chegada " : " AAAA-MM-DDTHH: mm: ss.sssZ " ,
				 " empresa " : " UberOnRails " ,
				 " preço " : 1400,00
			},
			{
				" origem " : " NYC " ,
				 " destino " : " LOA " ,
				 " partida " : " AAAA-MM-DDTHH: mm: ss.sssZ " ,
				 " chegada " : " AAAA-MM-DDTHH: mm: ss.sssZ " ,
				 " empresa " : " UberOnRails " ,
				 " preço " : 350,00
			}
		]
	}
]
Extras: Adicione todas as dependências ou recursos que você acha que são necessários para desenvolver a melhor solução para o desafio. Alguns exemplos, mas você não precisa se limitar a eles:

Documentação (Swagger, OpenAPI etc)
Cache
Docker
Testes
Faça upload da solução:

Sua solução deve ser carregada em um repositório público Github ou Bitbucket. O repositório deve ter:
O projeto.
Um README explicando como executar seu projeto.
