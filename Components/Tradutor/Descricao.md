# Utilizando o Módulo Tradutor

Para utilizar o módulo do Tradutor é necessário instalar um Jar no link:https://github.com/watson-developer-cloud/java-sdk/releases/download/java-sdk-7.0.0/ibm-watson-7.0.0-jar-with-dependencies.jar

Depois, é preciso adicionar o Jar ao build path do programa.

O acesso ao Tradutor é feito através de uma função static chamada translate na classe Translate,
que recebe como parâmetros um String contendo o texto a ser traduzido e uma String contendo a 
língua de destino (opcional, o default é inglês).
