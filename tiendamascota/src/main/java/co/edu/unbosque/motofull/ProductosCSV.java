package co.edu.unbosque.motofull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ProductosCSV 
{
	
	public void LeerArchivoCSV(String PathFile) throws CsvValidationException, IOException
	{
		
		System.out.println("Ingresó a leer el archivo");
		CSVReader csvReader = new CSVReader(new FileReader(PathFile));
		String[] fila = null;
		
		while((fila = csvReader.readNext()) != null) {
			System.out.println("Empezó a leer fila a fila");
			System.out.println(fila[0]
		              + " | " + fila[1]
		              + " |  " + fila[2]);
		}

		csvReader.close();
	}
	
	public void ruta()
	{
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("choosertitle");
	    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	      System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
	      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
	    } else {
	      System.out.println("No Selection ");
	    }
	  }
	
}
