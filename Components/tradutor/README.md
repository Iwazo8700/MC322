# Utilização da componente

Para usar a componente de traducao, é necessário instalar o JAR de serviços da IBM em:https://github.com/watson-developer-cloud/java-sdk/releases/download/java-sdk-7.0.0/ibm-watson-7.0.0-jar-with-dependencies.jar
e colocá-la em seu build path. Caso seu projeto possua um module-info.java, é necessário acrescentar "requires ibm.watson;".

A utilização da componente se dá pela classe Translate. Ela possui um método static chamado translate que recebe o texto a ser traduzido e,
opcionalmente, a língua que se deseja traduzir para (só a sigla da língua. Ex: ingles = en, Portugues = pt, alemão = de, etc).
