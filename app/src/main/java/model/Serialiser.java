package model;
import android.content.Context;

import java.io.*;
public class Serialiser {

    public Serialiser() {
        super();
    }

    public void serialise(String filename, Object objet, Context context) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(context.openFileOutput(filename, Context.MODE_PRIVATE));
        oos.writeObject(objet);
        oos.flush();
        oos.close();
    }

    public Object deSerialise(String filename, Context context) throws IOException {
        Object obj = null;
        // Vérifier si le fichier existe avant de le désérialiser
        File file = new File(context.getFilesDir(), filename);
        if (file.exists()) {
            try {
                ObjectInputStream ois = new ObjectInputStream(context.openFileInput(filename));
                obj = ois.readObject();
                ois.close();
            } catch (ClassNotFoundException e) {
                // Gérer l'erreur de classe non trouvée
                e.printStackTrace();
            }
        }
        return obj;
    }
}
