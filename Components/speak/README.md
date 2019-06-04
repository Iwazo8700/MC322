# Utilização da componente

Para usar a componente de fala, é necessário instalar o JAR de serviços da IBM em:https://github.com/watson-developer-cloud/java-sdk/releases/download/java-sdk-7.0.0/ibm-watson-7.0.0-jar-with-dependencies.jar
e colocá-la em seu build path. Caso seu projeto possua um module-info.java, é necessário acrescentar "requires ibm.watson;".

A utilização da componente se dá pela classe Speak. Ela possui apenas um método static chamado speak que recebe o texto a ser falado
em inglês.
