package pl.sda.io;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //To znamy - wypisuje na standardowe wyjscie:
        System.out.print("Witaj swiecie!");
        //Readery/Writery:
        //Czytanie:
        System.out.println();
        //Pisanie:
        writerWriting();
        //Buforowany writer:
        bufferedWritter();
        //Buforowany reader:
        //1. Jak to zrobic?
        //2. Czy to sie łączy jakoś z czytaniem z konsoli?
        //czym jest System.in;
        //Readerow uzywa sie prawie tak samo jak streamow IO
        //Skaner
        scanner();
        //3. skaner + czytanie z konsoli?
        //Java NIO
        //Path:
        printFilenameAndFullPath();
        //Laczenie sciezek:
        concatPath();
        //Files:
        //Files.createDirectory()
        //Files.lines();
        //vs
        //Files.readAllLines()
        //Files.list()
        //Files.writeString()

    }

    private static void printFilenameAndFullPath() {
        Path path = Path.of("test.txt");
        System.out.println(path.toString());
        System.out.println(path.getFileName().toString());
    }

    private static void concatPath() {
        Path part1 = Path.of("C:/");
        Path part2 = Path.of("xxx.txt");
        Path concatenated = part1.resolve(part2);
        System.out.println(concatenated);
    }

    private static void scanner() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("Witaj " + line);
    }

    private static void bufferedWritter() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("test-write.txt"));
        writer.write("Test ala ma kota");
        writer.close();//Bardzo wazne!
    }

    private static void writerWriting() throws IOException {
        FileWriter writer = new FileWriter("test-write.txt");
        writer.write("Test ala ma kota");
        writer.close();//Bardzo wazne!
    }

    private static void readerReading() throws IOException {
        FileReader in = new FileReader("test.txt");
        int oneChar;
        while (true) {
            oneChar = in.read();
            if (oneChar == -1) {
                break;
            }
            System.out.print(oneChar); //co tutaj nie gra? co jest teraz wypisywane?
        }
        in.close();//bardzo wazne!
    }
}
