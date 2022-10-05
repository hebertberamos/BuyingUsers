import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entitie.LogEntry;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("entre com o caminho da pasta: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();
            while(line != null){

                String[] fields = line.split(" ");
                String userName = fields[0];
                Date moment = Date.from(Instant.parse(fields[1]));

                set.add(new LogEntry(userName, moment));

                line = br.readLine();
            }
            System.out.println("total user: " + set.size());

        }
        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}
