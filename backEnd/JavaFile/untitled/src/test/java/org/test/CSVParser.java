package org.test;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static List<String[]> parseCSV(String csvString, char delimiter) {
        List<String[]> rows = new ArrayList<>();
        boolean insideQuotes = false;
        StringBuilder fieldBuilder = new StringBuilder();
        List<String> fields = new ArrayList<>();

        for (int i = 0; i < csvString.length(); i++) {
            char c = csvString.charAt(i);

            if (c == '"') {
                insideQuotes = !insideQuotes;
            } else if (c == delimiter && !insideQuotes) {
                fields.add(fieldBuilder.toString().trim());
                fieldBuilder.setLength(0);
            } else if (c == '\\' && i + 1 < csvString.length() && (csvString.charAt(i + 1) == delimiter || csvString.charAt(i + 1) == 'n') && insideQuotes) {
                fieldBuilder.append(csvString.charAt(i + 1) == delimiter ? delimiter : '\n');
                i++; // Skip the next character (the delimiter or 'n')
            } else if (c == '\n' && insideQuotes) {
                fieldBuilder.append("\\n");
            } else {
                fieldBuilder.append(c);
            }

            if (!insideQuotes && (c == '\n' || i == csvString.length() - 1)) {
                fields.add(fieldBuilder.toString().trim());
                rows.add(fields.toArray(new String[0]));
                fieldBuilder.setLength(0);
                fields.clear();
            }
        }

        return rows;
    }

    public static void main(String[] args) {
        String csvString = "Name;Age;Location\nJohn;25;New York\n\"Doe; Jane\";30;San Francisco\nMary\\/;28;Chicago\n\"Alice\\nBob\";35;Los Angeles";

        List<String[]> parsedCSV = parseCSV(csvString, ';');

        for (String[] row : parsedCSV) {
            for (String field : row) {
                System.out.print(field + "\t");
            }
            System.out.println();
        }
    }
}