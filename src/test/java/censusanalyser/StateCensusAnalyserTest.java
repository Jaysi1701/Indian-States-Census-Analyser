package censusanalyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    String censusFilePath = "src/test/resources/IndiaStateCensusData.csv";
    String wrongDelimiterPath = "src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";
    String wrongHeaderPath = "src/test/resources/IndiaStateCensusDataWrongHeader.csv";
    String wrongTypePath = "src/test/resources/IndiaStateCensusData.txt";
    String wrongPath = "src/test/resources/IndiaStateCode.csv";

    @Test
    public void givenIndianCensusCSVFile_ShouldReturnCorrectRecords() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            int numberOfRecords = censusAnalyser.loadIndiaCensusData(censusFilePath);

            Assertions.assertEquals(4, numberOfRecords);

        } catch (CensusAnalyserException e) {
        }
    }

    @Test
    public void givenWrongFilePath_ShouldThrowException() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            censusAnalyser.loadIndiaCensusData(wrongPath);

        } catch (CensusAnalyserException e) {

            Assertions.assertEquals(
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,
                    e.type);
        }
    }

    @Test
    public void givenWrongFileType_ShouldThrowException() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            censusAnalyser.loadIndiaCensusData(wrongTypePath);

        } catch (CensusAnalyserException e) {

            Assertions.assertEquals(
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE,
                    e.type);
        }
    }
}