package censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {

        try {

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

        } catch (RuntimeException e) {

            throw new CensusAnalyserException(
                    "CSV File Problem",
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);

        } catch (Exception e) {

            if (csvFilePath.contains(".txt")) {

                throw new CensusAnalyserException(
                        "Invalid File Type",
                        CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE);
            }

            throw new CensusAnalyserException(
                    "CSV File Problem",
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}