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

