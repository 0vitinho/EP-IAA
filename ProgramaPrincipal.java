import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.File;


 class HeapSort {
 
    public static int[] sort(int[] v) {
        buildMaxHeap(v);
        int n = v.length;
 
        for (int i = v.length - 1; i > 0; i--) {
            swap(v, i, 0);
            maxHeapify(v, 0, --n);
        }
        
        return v;
    }
 
    private static void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--) {
            maxHeapify(v, i, v.length);
        }
 
    }
 
    private static void maxHeapify(int[] vetor, int pos, int tamanhoDoVetor) {
 
        int max = 2 * pos + 1, right = max + 1;
        if (max < tamanhoDoVetor) {
 
            if (right < tamanhoDoVetor && vetor[max] < vetor[right]) {
                max = right;
            }
 
            if (vetor[max] > vetor[pos]) {
                swap(vetor, max, pos);
                maxHeapify(vetor, max, tamanhoDoVetor);
            }
        }
    }
 
    public static void swap(int[] v, int j, int aposJ) {
        int aux = v[j];
        v[j] = v[aposJ];
        v[aposJ] = aux;
    }
}
 
public class ProgramaPrincipal {
 
    public static void main(String[] args) throws IOException {
 
        int[] arrayDesordenado = new int[1000];
        int[] arrayOrdenado = new int[1000];
        
        final File folder = new File("/home/local/USPEACHSI/a11295783/Documentos/Arquivos");

	listFilesForFolder(folder);
        

        
    }
    
    public static int[] lerArquivo(String filename){
		try{

		FileInputStream file = new FileInputStream("Arquivos/"+filename);
	
		DataInputStream input = new DataInputStream(file);
		BufferedReader read = new BufferedReader(new InputStreamReader(input));
		String strLine;

		int numLinhas = Integer.parseInt(read.readLine());
		int i = 0;
		int[] array = new int[numLinhas];
		while ((strLine = read.readLine()) != null)   {
			array[i] = Integer.parseInt(strLine);
			i++;
		}

		input.close();
		return array;
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
  		return null;
	}
        static public void imprimirVetor(int[] array) {
            for (int counter = 0; counter < (array.length - 1); counter++) {
                System.out.println(array[counter]);
            }
        }


	public static void listFilesForFolder(final File folder) {
			for (final File fileEntry : folder.listFiles()) {
				long startLeitura = System.nanoTime();
				int[] array = lerArquivo(fileEntry.getName());
				long endLeitura = System.nanoTime();
				long tempoLeitura = endLeitura - startLeitura;
				long tempoinicial = System.nanoTime();
				int[] arrayOrdenado = HeapSort.sort(array);
				long tempofinal = System.nanoTime();
				long tempototal = tempofinal - tempoinicial;
				

				System.out.printf("%s %d %d %d Intel®_Core™_i5-3330S_CPU_@_2.70GHz_×_4 Heap_Sort Java-1.8.0_212 GNU/Linux_64-bit Ordenado 11295783\n",fileEntry.getName(), array.length, tempoLeitura, tempototal);
			}
	}
}









