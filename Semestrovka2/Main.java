import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        GenerateNums();
        File input = new File("input.txt");
        File addOutput = new File("add_output.txt");
        File findOutput = new File("find_output.txt");
        File deleteOutput = new File("delete_output.txt");
        Random random = new Random();
        SplayTree splayTree = new SplayTree();
        try {
            Scanner scanner = new Scanner(input);
            List<Integer> numbers = new ArrayList<>();
            while (scanner.hasNextLine()){
                numbers.add(Integer.parseInt(scanner.nextLine()));
            }
            long[][] add = splayTree.addElement(numbers);

            Set<Integer> firtstSet = new HashSet<>();
            while (firtstSet.size() < 100){
                firtstSet.add(numbers.get(random.nextInt(10000)));
            }
            long[][] find = splayTree.findElement(firtstSet.stream().toList());

            Set<Integer> secondSet = new HashSet<>();
            while (secondSet.size() < 1000){
                secondSet.add(numbers.get(random.nextInt(10000)));
            }
            long[][] delete = splayTree.deleteElem(secondSet.stream().toList());

            writeToFile(addOutput, add);
            writeToFile(findOutput, find);
            writeToFile(deleteOutput, delete);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(File file, long[][] data) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (long[] element : data) {
            writer.write(element[0] + " " + element[1] + "\n");
        }
        writer.close();
    }
    public static void GenerateNums(){
        File file = new File("input.txt");
        Random random = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < 10000) {
            int num = random.nextInt(10001);
            set.add(num);
        }
        try {
            FileWriter writer = new FileWriter(file);
            for (int num : set) {
                writer.write(num + "\n");
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}