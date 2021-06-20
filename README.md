## Exercicio (Java): Compras no Supermercado

O exercicio publicado é referente ao treinamento do Bootcamp Java Developer - Ordenação e Filtros em Java 
(https://digitalinnovation.one)

#### Descrição do Desafio:

Pedro trabalha sempre até tarde todos os dias, com isso tem pouco tempo tempo para as tarefas domésticas. Para economizar tempo ele faz a lista de compras do supermercado em um aplicativo e costuma anotar cada item na mesma hora que percebe a falta dele em casa.

O problema é que o aplicativo não exclui itens duplicados, como Pedro anota o mesmo item mais de uma vez e a lista acaba ficando extensa. Sua tarefa é melhorar o aplicativo de notas desenvolvendo um código que exclua os itens duplicados da lista de compras e que os ordene alfabeticamente.

#### Entrada: 

A primeira linha de entrada contém um inteiro N (N < 100) com a quantidade de casos de teste que vem a seguir, ou melhor, a quantidade de listas de compras para organizar. Cada lista de compra consiste de uma única linha que contém de 1 a 1000 itens ou palavras compostas apenas de letras minúsculas (de 1 a 20 letras), sem acentos e separadas por um espaço.

#### Saída: 

A saída contém N linhas, cada uma representando uma lista de compra, sem os itens repetidos e em ordem alfabética.

Exemplos de Entrada  | Exemplos de Saída
------------- | -------------
2 | carne laranja picles suco
carne laranja suco picles laranja picles | laranja pera
laranja pera laranja pera pera | 


#### Java　

```java
//SOLUCAO 1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections; 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ComprasNoSupermercado {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
   
    ArrayList<String> listaComprasAux = new ArrayList<String>();
    StringBuilder listaCompras = new StringBuilder();
     
    /*Será lido a primeira linha de entrada. O valor que entrará na variavel 'linhasDeEntrada' 
    é referente o numero de linhas que será lido na sequencia*/
    st = new StringTokenizer(br.readLine()); 
    int linhasDeEntrada = Integer.parseInt(st.nextToken()); 
    
    /*Essa Estrutura de repetição 'for', será executado conforme a quantidade de linhas 
    que consta na variavel 'linhasDeEntrada'*/
    for (int i = 0; i < linhasDeEntrada; i++){ 
      
      /*Será lido a proxima linha*/
      st = new StringTokenizer(br.readLine());
      /*O loop irá ler o objeto 'st', enquanto for valido o dado será adicionar no ArrayList*/
      while (st.hasMoreTokens()) listaComprasAux.add(st.nextToken());
      
      /*O objeto do tipo HashSet, será utilizado para remover valores repetidos da lista*/
      Set<String> removerValorDuplicado = new HashSet<>(listaComprasAux);
      listaComprasAux.clear();
      listaComprasAux.addAll(removerValorDuplicado);
    
      /*A lista será ordenado em ordem crescente*/
      Collections.sort(listaComprasAux);
      
      /*Como a lista é um array a impressão sairá em colunas, neste caso será usado um 
      objeto builder, para concatenar os itens, para que sejam impressos na mesma linha*/
      for (String s : listaComprasAux){
         listaCompras.append(s);
         listaCompras.append(" ");
      }
     /*será feita a impressão de cada lista, os itens ficarão na mesma linha*/  
     System.out.println(listaCompras.toString());
     
     /*Limpado o ArrayList(listaComprasAux)e o objeto StringBuilder(listaCompras), para serem 
     reutilizadas, na proxima lista*/
     listaCompras = new StringBuilder();
		 listaComprasAux = new ArrayList();
    }
  }
}
```

