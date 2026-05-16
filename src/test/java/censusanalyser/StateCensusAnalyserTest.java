package censusanalyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    String censusFilePath = "src/test/resources/IndiaStateCensusData.csv";
    String wrongDelimiterPath = "src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";
    String wrongHeaderPath = "src/test/resources/IndiaStateCensusDataWrongHeader.csv";
    String wrongTypePath = "src/test/resources/IndiaStateCensusData.txt";
    String wrongPath = "src/test/resources/IndiaStateCode.csv";

    String stateCodePath = "src/test/resources/IndiaStateCode.csv";
    String wrongStateCodeDelimiter = "src/test/resources/IndiaStateCodeWrongDelimiter.csv";
    String wrongStateCodeHeader = "src/test/resources/IndiaStateCodeWrongHeader.csv";
    String wrongStateCodeType = "src/test/resources/IndiaStateCode.txt";

    @Test
    public void givenIndianCensusCSVFile_ShouldReturnCorrectRecords() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            int numberOfRecords = censusAnalyser.loadIndiaCensusData(censusFilePath);

            Assertions.assertEquals(4, numberOfRecords);

        } catch (CensusAnalyserException e) {
            e.printStackTrace();
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

    @Test
    public void givenWrongDelimiterFile_ShouldThrowException() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            censusAnalyser.loadIndiaCensusData(wrongDelimiterPath);

        } catch (CensusAnalyserException e) {

            Assertions.assertEquals(
                    CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER,
                    e.type);
        }
    }

    @Test
    public void givenWrongHeaderFile_ShouldThrowException() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            censusAnalyser.loadIndiaCensusData(wrongHeaderPath);

        } catch (CensusAnalyserException e) {

            Assertions.assertEquals(
                    CensusAnalyserException.ExceptionType.INCORRECT_HEADER,
                    e.type);
        }
    }
    @Test
    public void givenIndianStateCodeCSVFile_ShouldReturnCorrectRecords() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            int numberOfRecords =
                    censusAnalyser.loadIndianStateCode(stateCodePath);

            Assertions.assertEquals(4, numberOfRecords);

        } catch (CensusAnalyserException e) {
        }
    }

    @Test
    public void givenWrongStateCodeFile_ShouldThrowException() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            censusAnalyser.loadIndianStateCode("abc.csv");

        } catch (CensusAnalyserException e) {

            Assertions.assertEquals(
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,
                    e.type);
        }
    }

    @Test
    public void givenWrongStateCodeType_ShouldThrowException() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            censusAnalyser.loadIndianStateCode(wrongStateCodeType);

        } catch (CensusAnalyserException e) {

            Assertions.assertEquals(
                    CensusAnalyserException.ExceptionType.INVALID_FILE_TYPE,
                    e.type);
        }
    }

    @Test
    public void givenWrongStateCodeDelimiter_ShouldThrowException() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            censusAnalyser.loadIndianStateCode(wrongStateCodeDelimiter);

        } catch (CensusAnalyserException e) {

            Assertions.assertEquals(
                    CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER,
                    e.type);
        }
    }

    @Test
    public void givenWrongStateCodeHeader_ShouldThrowException() {

        try {

            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();

            censusAnalyser.loadIndianStateCode(wrongStateCodeHeader);

        } catch (CensusAnalyserException e) {

            Assertions.assertEquals(
                    CensusAnalyserException.ExceptionType.INCORRECT_HEADER,
                    e.type);
        }
    }

}