package com.demo.walet.transactionhistory.service;

import com.demo.walet.transactionhistory.models.dto.TransactionView;
import com.demo.walet.transactionhistory.models.entity.AccountStatements;
import com.demo.walet.transactionhistory.models.entity.Transactions;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoryServiceTest {

    @InjectMocks
    HistoryService historyService;

    @Mock
    TransactionsService transactionsService;
    @Mock
    StatementsService statementsService;

    AutoCloseable closeable;
    @BeforeEach
    void setUp() {
        closeable=MockitoAnnotations.openMocks(this);
    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        closeable.close();
    }

    @SneakyThrows
    @Test
    void getCurrentBalance() {
        Date date1=new SimpleDateFormat("dd-MM-yyyy").parse("25-05-2021");
        AccountStatements acs=new AccountStatements(1,10,date1,500L);

        Date date2=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS").parse("26-05-2021 10:10:10.100");
        List<Transactions> transactionsList= Arrays.asList(
                new Transactions(1,2,10,1,50,new Date()),
                new Transactions(2,3,10,0,10,date2)
        );

        Mockito.when(statementsService.getLatestStatement(Mockito.anyInt())).thenReturn(acs);
        Mockito.when(transactionsService.getTransactionsAfter(Mockito.anyInt(),Mockito.any())).thenReturn(transactionsList);
        Double actualAmount= historyService.getCurrentBalance(10);

        assertEquals(540,actualAmount);

    }

    @Test
    void getTransationTypeBetween() throws ParseException {
        //transactionsService.getTransactionsBetween
        Date date2=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS").parse("26-05-2021 10:10:10.100");
        List<Transactions> transactionsList= Arrays.asList(
                new Transactions(1,2,10,1,50,new Date()),
                new Transactions(2,3,10,0,10,date2)
        );
        Mockito.when(transactionsService.getTransactionsBetween(Mockito.anyInt(), Mockito.any(), Mockito.any(), Mockito.any()))
                .thenReturn(transactionsList);

        List<TransactionView> expectedList=Arrays.asList(
                new TransactionView(2,"credit",Double.valueOf(50),new Date()),
                new TransactionView(3,"debit",Double.valueOf(10), date2)
        );
        List<TransactionView> transactionViews= historyService.getTransationTypeBetween(10, date2, new Date(),null);
        assertEquals(expectedList.size(),transactionViews.size());

    }
}