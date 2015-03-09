package tilespainter.Model;



import java.io.File;
import javax.swing.filechooser.FileFilter;


public class Filtre_Simple extends FileFilter {
   //Description et extension acceptée par le filtre
   private String description;
   private String extension;
   //Constructeur à partir de la description et de l'extension acceptée
   public Filtre_Simple(String description, String extension){
      if(description == null || extension ==null){
         throw new NullPointerException("La description (ou extension) ne peut etre null.");
      }
      this.description = description;
      this.extension = extension;
   }
   //Implémentation de FileFilter
   public boolean accept(File file){
      if(file.isDirectory()) { 
         return true; 
      } 
      String nomFichier = file.getName().toLowerCase(); 
 
      return nomFichier.endsWith(extension);
   }
      public String getDescription(){
      return description;
   }
}
