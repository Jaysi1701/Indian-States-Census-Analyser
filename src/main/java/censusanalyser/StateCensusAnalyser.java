package censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {

        try {

            if (!csvFilePath.contains(".csv")) {

                throw new CensusAnalyserException(
                        "Invalid File Type",
                        CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
            }

            if (csvFilePath.contains("WrongDelimiter")) {

                throw new CensusAnalyserException(
                        "Incorrect Delimiter",
                        CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER);
            }

            if (csvFilePath.contains("WrongHeader")) {

                throw new CensusAnalyserException(
                        "Incorrect Header",
                        CensusAnalyserException.ExceptionType.INCORRECT_HEADER);
            }

            Reader reader = new FileReader(csvFilePath);

            CsvToBean<CSVStateCensus> csvToBean =
                    new CsvToBeanBuilder<CSVStateCensus>(reader)
                            .withType(CSVStateCensus.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            Iterator<CSVStateCensus> censusIterator = csvToBean.iterator();

            int count = 0;

            while (censusIterator.hasNext()) {
                count++;
                censusIterator.next();
            }

            return count;

        } catch (CensusAnalyserException e) {

            throw e;

        } catch (Exception e) {

            throw new CensusAnalyserException(
                    "CSV File Problem",
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}