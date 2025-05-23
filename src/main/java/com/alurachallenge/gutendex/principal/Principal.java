package com.alurachallenge.gutendex.principal;

import com.alurachallenge.gutendex.model.DataBook;
import com.alurachallenge.gutendex.model.DataResponse;
import com.alurachallenge.gutendex.service.ApiClient;
import com.alurachallenge.gutendex.service.DataConverter;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private final ApiClient apiClient = new ApiClient();
    private final DataConverter converter = new DataConverter();
    private final String URL_BASE = "https://gutendex.com/books/";

    public void showMenu() {

        System.out.println("SOLICITANDO INFORMACION ...");

        //* Solicitando información de las 3 primeras páginas de resultados
        List<DataResponse> responseList = new ArrayList<>();
        String json = "";

        for (int i = 1; i <= 3; i++) {
            json = apiClient.fetchData(URL_BASE + "?page=" + i);
            var drList = converter.fromJson(json, DataResponse.class);
            responseList.add(drList);
        }

        //* Convirtiendo la lista de DataResponse a una lista del tipo DataBook
        List<DataBook> dataBookList = responseList
                .stream()
                .flatMap(dataResponse -> dataResponse.dataBookList().stream())
                .collect(Collectors.toList());

        System.out.println("Top 10 libros más descargados:");
        dataBookList
                .stream()
                .filter(b -> b.downloadCount() > 0.0)
                .sorted(Comparator.comparing(DataBook::downloadCount).reversed())
                .limit(10)
                .map((b) -> b.title().toUpperCase() + " - " + b.downloadCount() + " descargas.")
                .forEach(System.out::println);


        System.out.println();

        System.out.println("ESTADÍSTICAS");

        DoubleSummaryStatistics est = dataBookList
                .stream()
                .filter(e -> e.downloadCount() > 0.0)
                .collect(Collectors.summarizingDouble(DataBook::downloadCount));

        System.out.println("Media de las descargas: " + est.getAverage());
        System.out.println("Libro más descargado: " + est.getMax());
        System.out.println("Libro menos descargado: " + est.getMin());
        System.out.println("Cantidad de libros evaluados para calcular las estadísticas: " + est.getCount());

    }
}
