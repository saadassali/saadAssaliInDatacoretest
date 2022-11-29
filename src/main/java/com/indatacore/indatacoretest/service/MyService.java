package com.indatacore.indatacoretest.service;

import com.indatacore.indatacoretest.domaine.Etudiant;
import com.indatacore.indatacoretest.repository.MyRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.kohsuke.randname.RandomNameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MyService {

    private MyRepository repo;
    @Autowired
    public MyService(MyRepository repo) {
        this.repo = repo;
    }
    public Iterable<Etudiant> getAll()
    {
        return        repo.findAll();

    }
    public Etudiant addEtudiant(Etudiant etudiant)
    {

        return repo.save(etudiant);
    }
    public Etudiant addRandomEtudiant()
    {
        RandomNameGenerator rnd = new RandomNameGenerator(0);
        Random rn = new Random();

        String[] arrSplit_2 =  rnd.next().split("_", 2);
        int age= rn.nextInt(100 - 1 + 1) + 1;

        Etudiant etudiant=new Etudiant(null, arrSplit_2[0],arrSplit_2[1],age);
        return repo.save(etudiant);
    }

    public Iterable<Etudiant> saveCsvFileDataInDataBase()
    {
        return repo.saveAll(readCsv());
    }

    public  Iterable<Etudiant> readCsv() {
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader("C:/csv_file.csv");

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
                    // Skip the header
                    .withSkipLines(1)
                    .build();

            etudiants=getEtudianFromCsv(csvReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return etudiants;
    }
    //Get the one Etudiant
    private Etudiant getEtudianFromCsv(String[] nextRecord)
    {
        return new Etudiant(null,nextRecord[0],nextRecord[1], Integer.parseInt(nextRecord[2]));
    }

    //Get the list of Etudiants
    // we are going to read data line by line
    private  ArrayList<Etudiant> getEtudianFromCsv( CSVReader csvReader) throws IOException {
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        String[] nextRecord;

        while ((nextRecord = csvReader.readNext()) != null) {
            etudiants.add(getEtudianFromCsv(nextRecord));
            System.out.println();
        }
        return etudiants;
    }

}
