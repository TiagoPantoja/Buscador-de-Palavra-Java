**Buscador De Texto Mais Profundo:**

A aplicação realiza uma busca pelo texto mais profundo em uma página HTML.

O texto mais profundo está contido em uma tag HTML que possui o maior nível de profundidade.

**Como usar:**

Para compilar o programa, execute o seguinte comando, a partir do diretório que contém o(s) arquivo(s) de código-fonte: *javac HtmlAnalyzer.java*

Para executar, execute o seguinte comando, a partir do diretório onde foi feita a compilação, alterando o argumento que contém a URL para uma URL válida: *java HtmlAnalyzer inserir-url-aqui*

OBS: É necessário alterar a URL, pois eu utilizei a URL do exemplo para testar a aplicação.


**Requisitos:**

Para executar a aplicação, é necessário ter instalado o Java JDK 8 ou superior. Contudo, a versão utilizada foi o Java JDK 17.

**Funcionalidades:**

A aplicação busca o texto mais profundo em uma página HTML. Ela usa uma pilha para controlar as tags HTML e identificar a tag mais profunda.

Se a estrutura for mal-formadas, a aplicação retornará a mensagem: "malformed HTML".

Se não for possível obter o conteúdo HTML por falha de conexão, a aplicação retornará a mensagem: "URL connection error".
