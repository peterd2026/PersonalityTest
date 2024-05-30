import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Read/Write File
 */

public class FileTools {

    /**
     * Write file
     *
     * @param str  (content)
     * @param name (file name)
     */
    public void writeResult(String str, String name) {
        File file = new File("src/Results/" + name + "'s personality test results.txt");
        if (file.exists()) {
            file = new File("src/Results/" + name + "1's personality test results.txt");
        }
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            byte[] b = str.getBytes();
            outputStream.write(b);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Read file
     *
     * @param name
     * @return file content
     */
    public List<String> QuestionReader(String name) {
        //turn questions file into stream
        FileInputStream fis = null;
        //read stream
        InputStreamReader isr = null;
        //read char stream then show
        BufferedReader br = null;
        //save the questions read into a list
        List<String> listA = new ArrayList<String>();

        try {
            fis = new FileInputStream("src/TestQuestions/" + name + ".txt");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            while (br.ready()) {
                listA.add(br.readLine());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                br.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return listA;
    }
}
