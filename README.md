Em uma linguagem orientada a objetos, além de usarmos os parâmetros para explorar novos casos de teste, devemos considerar também o estado dos atributos do objeto. Pensando nisso, resolvemos usar valores diferentes no estado dos tanques antes de rodar cada técnica de teste.

As classes de equivalência foram definidas unicamente no enunciado do problema, pois estamos tratando do comportamento de sua especificação. No método de encomendar combustível combinamos os parâmetros para criar classes.

Considerando a técnica do valor limite, como temos três condições no método de encomendar combustível o número de combinações de teste pode crescer rapidamente, logo devemos usar a estratégia do domínio simplificado, onde utilizamos uma matriz para facilitar a criação de casos de teste. A estratégia proposta pressupõe variar os in-points nos diferentes testes, isso permite verificar se o programa fornece resultados corretos para vários in-points. Vamos variá-los dependendo se for ou não emergência.

Já para os métodos que enchem os tanques, foi deduzido que não haveria testes de valor limite já que as rotinas sempre tentarão encher até o máximo permitido dos tanques, diferentemente de casos onde se dá para traduzir in e off points como true e false em certas condições.

Como o teste estrutural pode chegar a testar todas as combinações de decisões de um determinado script, devemos ser muito criteriosos pois a quantidade de casos de teste cresce exponencialmente. Levando isso em conta, decidimos primeiramente garantir que os casos já criados com base na especificação cubram todas as linhas do nosso código. 

Havia uma condição em cada método de encher um tanque na qual nenhum dos casos acima passou por. Apenas conseguimos atingir essas condições quando passamos por parâmetro uma quantidade, que quando somada com a atual do tanque, é insuficiente para enchê-lo.

Após isso devemos focar nossa atenção nos pontos mais críticos, analisando suas condições. O método de encomendar combustível é o mais importante e verificamos se os casos já feitos cobriam todos os blocos do código e o fato de não possuir qualquer loop também facilitou nossa abordagem.

Por fim, após rodarmos os drivers do grupo 15 obtivemos 2 falhas dos 14 casos. As falhas se explicam pois foi ordenado uma encomenda de combustível com quantidade igual a zero, um caso com emergência e outro sem. Na implementação do nosso programa é possível passar uma quantidade zero e o método retornará o valor remanescente em cada tanque, quando era de se esperar -2 (valor inválido) segundo o drive.

Já com o driver do professor houve 20 falhas dos 25 casos rodados. Acreditamos ser algum detalhe na conversão para int dos cálculos (se foi ou não arredondado), pois os números esperados são bem próximos dos encontrados.
