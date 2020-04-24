Em uma linguagem orientada a objetos, al�m de usarmos os par�metros para explorar novos casos de teste, devemos considerar tamb�m o estado dos atributos do objeto. Pensando nisso, resolvemos usar valores diferentes no estado dos tanques antes de rodar cada t�cnica de teste.

As classes de equival�ncia foram definidas unicamente no enunciado do problema, pois estamos tratando do comportamento de sua especifica��o. No m�todo de encomendar combust�vel combinamos os par�metros para criar classes.

Considerando a t�cnica do valor limite, como temos tr�s condi��es no m�todo de encomendar combust�vel o n�mero de combina��es de teste pode crescer rapidamente, logo devemos usar a estrat�gia do dom�nio simplificado, onde utilizamos uma matriz para facilitar a cria��o de casos de teste. A estrat�gia proposta pressup�e variar os in-points nos diferentes testes, isso permite verificar se o programa fornece resultados corretos para v�rios in-points. Vamos vari�-los dependendo se for ou n�o emerg�ncia.

J� para os m�todos que enchem os tanques, foi deduzido que n�o haveria testes de valor limite j� que as rotinas sempre tentar�o encher at� o m�ximo permitido dos tanques, diferentemente de casos onde se d� para traduzir in e off points como true e false em certas condi��es.

Como o teste estrutural pode chegar a testar todas as combina��es de decis�es de um determinado script, devemos ser muito criteriosos pois a quantidade de casos de teste cresce exponencialmente. Levando isso em conta, decidimos primeiramente garantir que os casos j� criados com base na especifica��o cubram todas as linhas do nosso c�digo. 

Havia uma condi��o em cada m�todo de encher um tanque na qual nenhum dos casos acima passou por. Apenas conseguimos atingir essas condi��es quando passamos por par�metro uma quantidade, que quando somada com a atual do tanque, � insuficiente para ench�-lo.

Ap�s isso devemos focar nossa aten��o nos pontos mais cr�ticos, analisando suas condi��es. O m�todo de encomendar combust�vel � o mais importante e verificamos se os casos j� feitos cobriam todos os blocos do c�digo e o fato de n�o possuir qualquer loop tamb�m facilitou nossa abordagem.

Por fim, ap�s rodarmos os drivers do grupo 15 obtivemos 2 falhas dos 14 casos. As falhas se explicam pois foi ordenado uma encomenda de combust�vel com quantidade igual a zero, um caso com emerg�ncia e outro sem. Na implementa��o do nosso programa � poss�vel passar uma quantidade zero e o m�todo retornar� o valor remanescente em cada tanque, quando era de se esperar -2 (valor inv�lido) segundo o drive.

J� com o driver do professor houve 20 falhas dos 25 casos rodados. Acreditamos ser algum detalhe na convers�o para int dos c�lculos (se foi ou n�o arredondado), pois os n�meros esperados s�o bem pr�ximos dos encontrados.
