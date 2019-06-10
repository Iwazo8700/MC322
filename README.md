# Projeto MC322 Grupo JAEE
~~~
170442 - Emanuel de Souza Oliveira  
215394 - Enzo Hideki Iwata
218615 - João Gabriel Segato Kruse
212466 - Álvaro Marques Macedo
~~~
# Componentes
obs: Ler o README de cada componente em sua respectiva pasta para ver suas exigências
# Componente `Speak`
Campo | Valor
----- | -----
Classe | speak.Speak
Autores | `Enzo Iwata, João Kruse, Emanuel Oliveira, Álvaro Marques`
Objetivo | `Converte o texto para áudio e executa `
Interface | -

~~~
public class Speak{
  public static void speak(String texto);
}
~~~
Exige a instalação do JAR em: https://github.com/watson-developer-cloud/java-sdk/releases/download/java-sdk-7.0.0/ibm-watson-7.0.0-jar-with-dependencies.jar

## Detalhamento das Interfaces
### Interface `Speak`
`Classe que contem metodo que recebe uma string com texto e a reproduz na forma de audio com a pronuncia do ingles`.

Método | Objetivo
-------| --------
`speak` | `Metodo estatico que recebe uma String e reproduz um audio do texto. Funçao void`


# Componente `Tradutor`

Campo | Valor
----- | -----
Classe | tradutor.Translate
Autores | `Enzo Iwata, João Kruse, Emanuel Oliveira, Álvaro Marques`
Objetivo | `Tradução de textos de qualquer lingua com suporte no Google Tradutor para português ou inglês `
Interface | -

~~~
public class Translate{
  String translate(String frase);
  String translate(String frase, String lingua);
}
~~~
Exige a instalação do JAR em: https://github.com/watson-developer-cloud/java-sdk/releases/download/java-sdk-7.0.0/ibm-watson-7.0.0-jar-with-dependencies.jar

## Detalhamento das Interfaces
### Interface `Tradutor`
`Classe com metodo que recebe uma frase em formato de string e traduz para inglês como padrão, caso o usuário deseje ele pode colocar como parâmetro uma língua para se traduzir`.

Método | Objetivo
-------| --------
`traduz` | `Metodo estatico que traduz uma string para inglês como padrão ou para uma língua desejada por sobrecarga de métodos. Retorna a String traduzida`

# Componente `Temperamental`
Campo | Valor
----- | -----
Classe | Temperamental.\* 
Autores | `Enzo Iwata, João Kruse, Emanuel Oliveira, Álvaro Marques`
Objetivo | `Simula um medico com diferentes temperamentos, que vai se estressando com o passar do tempo `
Interface | `Estresse, TemperamentoGeral`

~~~

public abstract class Estresse{
  public void novoPaciente();
  public void novaPergunta();
 }
 
 public class TemperamentoGeral{
    public static IFabricaStress CriaTemperamento(String tipo);
}

~~~
## Detalhamento das Interfaces
### Interface `Estresse`
`Classe que contem os metodos de update para que se gere uma frase dependedo da situacao`.

Método | Objetivo
-------| --------
`novoPaciente` | `Imprime uma mensagem(ou não) após a consulta com um paciente, e mostra o que o médico quer fazer ou de sua situação mental. Método precisa ser chamado sempre que acabar uma consulta`
`novaPergunta` | `Imprime uma mensagem(ou não) após uma pergunta ao paciente, e mostra o que o médico quer fazer ou de sua situação mental. Método precisa ser chamado sempre que o medico fizer uma pergunta`

### Interface `TemperamentoGeral`
`Fabrica de medicos com temperamentos diferentes`

Método | Objetivo
-------| --------
`CriaTemperamento` | `Recebe como parametro uma String, dentre elas podendo ser: calmo, puto, putasso, real e unico; a opcao de unico gerara uma situacao para um unico paciente, assim o temperamento do medico mudara com a quantidade de perguntas e pela demora com que elas foram feitas; as opções restantes servem para o caso de um medico que atende varios pacientes, assim simulando o dia de um medico; os outros sao autoexplicativos, o real passa pelos outros estados de forma respectiva indo do medico calmo para o puto e depois para o putasso.`

# Componente Interface Gráfica para Web
| Campo | Valor |
| ------------- | ------------- |
| Classe |	<caminho completo da classe com pacotes> |
| Autores | João Kruse, Enzo Iwata, Emanuel Oliveira e Álvaro Marques |
| Objetivo | Exibir um gráfico de curva de nível com a relação sintomas x doenças, analisando seu comportamento |
| Interface | IGraphWeb |
~~~
public interface IGraphWeb extends IDataSet{
  public int countSintomasDoencas();
  public int regraTres(int t, int n);
  public String[] cores(); //rgb(0,0,255) -> rgb(0,255,0)
  public String[][] coresSintomasDoencas();
  public String[][] constroiGraph();
  public String[][] geraCSV();
}
  
  
~~~
# Interface IGraphWeb
## Exibir um gráfico de curvas de nível mostrando a relação dos sintomas com as doenças
| Método | Objetivo |
| ------------- | ------------- |
| countSintomasDoencas() | Esse método conta quantas vezes determinado sintoma aparece na doença e contabiliza |
| regraTres() | Recebe o número total de diagnósticos da doença e o número que o sintoma aparece, converte para uma escala de 0 a 255 |
| cores() | Faz uma requisição na regraTres() e constrói uma String rgb com a cor do ponto no gráfico |
| coresSintomasDoencas() | Retorna uma String com as cores dos pontos Doença x Sintoma, por uma média ponderada |
| constroiGraph() | A partir das coresSintomasDoencas(), constrói o restante do gráfico com as cores de cada ponto/pixel, criando visualmente a curva de nível |
| geraCSV() | salva o gráfico em um arquivo csv, cor por coordenada, que será lido pelo programa web com JavaScript |

# Interface IServidor
## Cria um servidor HTTP para realizar troca de informações entre diferentes programas

| Método | Objetivo |
| ------------- | ------------- |
| initialize() | Inicia o Servidor |
| addContext(String path, HttpHandler h)  | Adiciona rota ao servidor e seu respectivo Handler |

## Tutorial de como fazer o seu servidor:

Olá, se você está lendo isso tem a chance de querer utilizar nosso servidor :)

Primeiramente, aqui está a referência das classes do componente: [FAZER REFERÊNCIA DO ROLÊ]

Nesse tutorial, vamos aprender a fazer um servidor recebe do cliente dois números inteiros e retorna a soma deles

Para começar, precisamos que você habilite o package com.sun.net.httpserver no seu projeto do eclipse, para fazer isso siga esses passos:
1. Configure o Build Path do seu projeto: <br />
![Screenshot](imgs/cfgbuildpath.png)
2. Vá em Acess Rules e aperte em Edit: <br />
![Screenshot](imgs/bpOpen.png)
3. Sete com/sun/net/httpserver/\* como acessível <br />
![Screenshot](imgs/accessible.png)
4. Aperte OK e depois Apply and Close <br />
![Screenshot](imgs/finish.png)

Com isso você seta o que é necessário para conseguir usar o servidor, (supondo que você adicionou nosso .jar ao projeto também)
 
Agora vamos começar o servidor. Primeiramente importe os packages necessários para criar o servidor:
  
```java
import componenteServidor.*;
import java.io.IOException;
import com.sun.net.httpserver.*;
```

Depois disso, crie o objecto `servidor`:
```java
public class Somador {
	
	public static void main(String args[]) throws IOException {
		IServidor servidor = FabricaServidor.create();
		
		
	}
}
``` 
O comando `FabricaServidor.create()` retorna um novo objeto do tipo Servidor, que cria um servidor local no PORT 8500, caso queira usar outra porta, coloque o número da porta desejado como parâmetro da função: `FabricaServidor.create(PORTA)`.

Agora é a parte que adicionamos um context, ao servidor, vamos em partes. 
A função `servidor.addContext` tem dois argumentos, a `String link` e o `HttpHandler handler`, o link mostra onde estará o contexto e onde nós iremos obter e mandar informações para o servidor, o link geral de um contexto é `http://localhost:[PORTA]/[link]`, nesse exemplo como a porta é 8500 e setaremos o link como "/somador/", o link geral ficará como `http://localhost:8500/somador/`, sempre coloque o caractere '/' no final do link para evitar problemas.

Teremos então: 

```java 
servidor.addContext("/somador/", /*Handler*/);
``` 

Chegamos no Handler, a parte que pode ser um pouco complicada, as opções que dão para simplificar para o usuário só deixam as coisas mais confusas então decidi deixar essa parte mais crua, porém com algumas facilitações

### Como declarar um Handler?

Saiba que HttpHandler não é uma classe, mas sim uma interface, sempre que fomos declarar um Handler precisamos declara a função handle, então um novo Handler se parece com isso:

```java
HttpHandler handler = new HttpHandler() {
			@Override
			public void handle(HttpExchange exchange) {}
			
};
```
HttpExchange é uma classe do package `com.sun.net.httpserver` que representa os requests do contexto e pode gerar uma resposta. Basicamente é ela que trás os pedidos do cliente para o servidor, e a resposta do servidor para o cliente. Houve confusão? Calma que vai ficando mais claro.

Para nosso somador, precisamos de informações dadas pelo cliente e conseguiremos elas por querys, que são consultas que no nosso caso serão feitas por meios dos links.
A sintaxe de um query é `[LINK GERAL]/?[Variável1]=[Valor1]&[Variável2]=[Valor2]`, no nosso caso usaremos `s1` e `s2` como variáveis que representarão os números a serem somados. Um exemplo de query seria `localhost:8500/somador/?s1=10&s2=20`, que representaria que `s1 = 10` e `s2 = 20`. Agora, como conseguiremos o query de um exchange?

Coloque a função `Servidor.addHeaders(exchanges)` para habilitar headers que fazem com que o servidor consiga enviar informações para javascript.
```java
String query = Servidor.getQuery(exchange);
```
A função `Servidor.getQuery` retorna o query puro de um link, que sera no caso `s1=10&s2=20`. Para conseguir os valores separados existe uma função que trata essa String de query puro:
```java
Map<String, String> queryDividido = Servidor.splitQuery(query);
``` 
Obs: para isso é necessário que você importe `java.util.Map`. Assim tempos um dicionário feito do query, `queryDividido.get("s1")` retornará a String `"10"` e assim por diante.

Agora, a soma dos números, que será feita usando sintaxe básica de java (não teremos tratamento de erro para simplificar o turorial):

```java
int s1, s2;
s1 = Integer.parseInt(queryDividido.get("s1"));
s2 = Integer.parseInt(queryDividido.get("s2"));

String response = Integer.toString(s1+s2);
``` 
Repare que a resposta do servidor tem que ser em forma de String, então teremos que convertê-la de volta.

Agora usamos o comando de mandar a resposta ao Servidor: 

```java
Servidor.sendResponse(exchange, response);
``` 
Depois disso, acabamos a declaração do Handle, colocamos no context e começamos o servidor com `servidor.initialize()`

O código final ficará parecido com isso:
```java

import componenteServidor.*;
import java.io.IOException;
import com.sun.net.httpserver.*;
import java.util.Map;

public class Somador {
	
	public static void main(String args[]) throws IOException {
		IServidor servidor = FabricaServidor.create();
		
		HttpHandler handler = new HttpHandler() {
			@Override
			public void handle(HttpExchange exchange) throws IOException{
				Servidor.addHeaders(exchange);
				
				String query = Servidor.getQuery(exchange);
				Map<String, String> queryDividido = Servidor.splitQuery(query);
				
				int s1, s2;
				s1 = Integer.parseInt(queryDividido.get("s1"));
				s2 = Integer.parseInt(queryDividido.get("s2"));
				
				String response = Integer.toString(s1+s2);
				
				Servidor.sendResponse(exchange, response);
				
			}
			
		};
		
		servidor.addContext("/somador/", handler);
	}
}
```
							
