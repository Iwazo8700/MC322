# Projeto MC322 Grupo JAEE
~~~
170442 - Emanuel de Souza Oliveira  
215394 - Enzo Hideki Iwata
218615 - João Gabriel Segato Kruse
212466 - Álvaro Marques Macedo
~~~
# Componentes
# Componente 'Speak'
Campo | Valor
----- | -----
Classe | speak.Speak <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `Enzo Iwata, João Kruse, Emanuel Oliveira, ´Álvaro Marques`
Objetivo | `Converte o texto para áudio e executa `
Interface | -

~~~
public class Speak{
  public static void speak(String texto);
}
~~~

# Componente `Tradutor`

Campo | Valor
----- | -----
Classe | tradutor.Translate <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `Enzo Iwata, João Kruse, Emanuel Oliveira, ´Álvaro Marques`
Objetivo | `Tradução de textos dee qualquer lingua com suporte no Google Tradutor para português ou inglês `
Interface | -

~~~
public class Translate{
  String translate(String frase);
  String translate(String frase, String lingua);
}
~~~

## Detalhamento das Interfaces

### Interface `ITradutor`
`Interface que recebe uma frase em formato de string e traduz para inglês como padrão, caso o usuário deseje ele pode colocar como parâmetro uma língua para se traduzir`.

Método | Objetivo
-------| --------
`traduz` | `Traduzir uma string em qualquer língua para inglês como padrão ou para uma língua desejada por sobrecarga de métodos. `

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
