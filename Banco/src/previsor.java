import java.io.File;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.classifiers.trees.J48;
import java.util.Scanner; 



public class previsor {
	
	public static void main(String[] args) throws Exception {
			
			Scanner meuObj = new Scanner(System.in);  // Cria um objeto Scanner
		    System.out.println("Digite o nome do arquivo");

		    String nomeArquivo = meuObj.nextLine();  // Lê a entrada do usuário
		    
		    ArffLoader carrega = new ArffLoader();
			carrega.setSource(new File(nomeArquivo));
			Instances dado = carrega.getDataSet();
			
			
			//Indica qual o atributo vamos classificar 
			dado.setClassIndex(dado.numAttributes()-1);
			
			//Carrega o modelo salvo
			J48 arvore = (J48) weka.core.SerializationHelper.read("modeloJ48.model");
			
			//Pega uma linha do arquivo e classifica
			for(int i = 0; i < dado.numInstances(); i++) {
				double resultado = arvore.classifyInstance(dado.instance(i));
				if(resultado==0.0) {
				   System.out.println("resultado da classificação: " + "yes");
				}
				else {
					System.out.println("resultado da classificação: " + "no");
				}
				
				
			}
			meuObj.close();
			
			
			
	}
	
}
