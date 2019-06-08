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
Objetivo | `Tradução de textos dee qualquer lingua com suporte no Google Tradutor para português ou inglês `
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
Classe | Temperamental.* 
Autores | `Enzo Iwata, João Kruse, Emanuel Oliveira, Álvaro Marques`
Objetivo | `Simula um medico com diferentes temperamentos ou que vai se estressando com o passar do tempo `
Interface | `IFabricaStress, Estresse`

~~~

public class TemperamentoGeral{
    public static IFabricaStress CriaTemperamento(String tipo){
        IFabricaStress retorno = null;
        if(tipo.equalsIgnoreCase("calmo"))
            retorno = new CriaCalmo();
        else if(tipo.equalsIgnoreCase("puto"))
            retorno = new CriaPuto();
        else if(tipo.equalsIgnoreCase("putasso"))
            retorno = new CriaPutasso();
        else if(tipo.equalsIgnoreCase("real"))
            retorno = new CriaReal();
        else if(tipo.equalsIgnoreCase("unico"))
            retorno = new CriaUnico();
        return retorno;
    }
}
~~~


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
