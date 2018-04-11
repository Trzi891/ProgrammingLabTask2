import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class UniqParserTest {
    Parser parser = new Parser();
    String[] args = new String[]{};

    @Test
    public void test() throws FileNotFoundException {
         parser = new Parser();
         args = new String[]{"-i", "-u", "-c", "-s", "2", "-o", "outputFile.txt", "file.txt"};

        parser.analyzeArgs(args);

        assertTrue(parser.isCaseInsensetive());
        assertTrue(parser.isUnique());
        assertTrue(parser.isCount());
        assertEquals(parser.getIgnoreChar(), 2);
        assertEquals(parser.getInputFileName(), "file.txt");
        assertEquals(parser.getOutputFileName(), "outputFile.txt");

    }

    @Test
    public void hasNoFileName() throws Exception {
         parser = new Parser();
         args = new String[]{"-i", "-u", "-c", "-s", "2"};
        parser.analyzeArgs(args);

        assertTrue(parser.isCaseInsensetive());
        assertTrue(parser.isUnique());
        assertTrue(parser.isCount());
        assertEquals(parser.getIgnoreChar(), 2);
        assertEquals(parser.getInputFileName(), "");
        assertEquals(parser.getOutputFileName(), "");

    }

    @Test
    public void onlyHasOutputFileName() throws FileNotFoundException {
        parser = new Parser();
         args = new String[]{"-i", "-u", "-c", "-o", "output.txt"};

        parser.analyzeArgs(args);

        assertTrue(parser.isCaseInsensetive());
        assertTrue(parser.isUnique());
        assertTrue(parser.isCount());
        assertEquals(parser.getIgnoreChar(), 0);
        assertEquals(parser.getInputFileName(), "");
        assertEquals(parser.getOutputFileName(), "output.txt");
    }

    @Test
    public void test4() throws FileNotFoundException {
        parser = new Parser();
         args = new String[]{ "-u", "-c", "-o", "output.txt", "file.txt"};

        parser.analyzeArgs(args);

        assertFalse(parser.isCaseInsensetive());
        assertTrue(parser.isUnique());
        assertTrue(parser.isCount());
        assertEquals(parser.getIgnoreChar(), 0);
        assertEquals(parser.getInputFileName(), "file.txt");
        assertEquals(parser.getOutputFileName(), "output.txt");
    }
  /*  private static File textFile;
    private static File outFile;


    private static FileWriter outWriter;


    private void assertFileContent(String expectedContent, File file) throws FileNotFoundException {
        String reader = new BufferedReader(new FileReader(file)).lines().collect(Collectors.joining("\n"));
        assertEquals(expectedContent, reader);
    }

    private void ready() throws IOException {
        textFile = new File("input/file.txt");
        FileReader testReader = new FileReader(textFile);

        outFile = new File("src/test/java/task2/out.txt");
        outWriter = new FileWriter(outFile);
    }

    public void After() throws IOException {
        System.gc();
        outFile.delete();
    }


    @Test
    private void countSameLines() {


    }

    @Test
    private void chooseDifferentLines() {

    }

    @Test
    private void ignoreCharacters() {

    }

    @Test
    private void caseInsensetive() {

    }*/


}
