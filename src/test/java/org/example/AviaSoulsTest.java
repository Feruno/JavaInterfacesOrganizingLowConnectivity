package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AviaSoulsTest {
    Ticket tickets = new Ticket("Гонконг", "Москва", 15_000, 12, 20 );
    Ticket tickets2 = new Ticket("Токио", "Пекин", 25_000, 15, 21 );
    Ticket tickets3 = new Ticket("Париж", "Хитроу", 15_000, 18, 22 );
    Ticket tickets4 = new Ticket("Гонконг", "Москва", 10_000, 10, 23 );

    @Test
    public void compareTo() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(tickets);
        aviaSouls.add(tickets2);
        aviaSouls.add(tickets3);
        aviaSouls.add(tickets4);

        System.out.println(tickets.compareTo(tickets2));
        System.out.println(tickets2.compareTo(tickets));
        System.out.println(tickets.compareTo(tickets3));

        int expectedZero = 0;
        int expectedPositive = 1;
        int expectedNegative = -1;

        Assertions.assertEquals(tickets.compareTo(tickets2) , expectedNegative);
        Assertions.assertEquals(tickets2.compareTo(tickets) , expectedPositive);
        Assertions.assertEquals(tickets.compareTo(tickets3) , expectedZero);
    }

    @Test
    public void searchByPrice() {
        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(tickets);
        aviaSouls.add(tickets2);
        aviaSouls.add(tickets3);
        aviaSouls.add(tickets4);

        Ticket[] res = aviaSouls.search("Гонконг", "Москва");
        Ticket[] expected = {tickets4, tickets};

        Assertions.assertArrayEquals(expected, res);
    }

    @Test
    public void successCompareTo() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(tickets); //8
        aviaSouls.add(tickets2); //6
        aviaSouls.add(tickets3); //4
        aviaSouls.add(tickets4); //13

        Ticket[] sort = {tickets, tickets2, tickets3, tickets4};
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        Arrays.sort(sort, ticketTimeComparator);

        Ticket[] expected = {tickets3, tickets2, tickets, tickets4};

        Assertions.assertArrayEquals(expected, sort);
    }

    @Test
    public void searchAndSortBy() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(tickets); //8
        aviaSouls.add(tickets2); //6
        aviaSouls.add(tickets3); //4
        aviaSouls.add(tickets4); //13

        Ticket[] sort = {tickets, tickets2, tickets3, tickets4};

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] res = aviaSouls.searchAndSortBy("Париж", "Хитроу", ticketTimeComparator );

        Ticket[] expected = {tickets3};

        Assertions.assertArrayEquals(expected, res);
    }


    @Test
    public void searchAndSortByTwoСoincidence() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(tickets); //8
        aviaSouls.add(tickets2); //6
        aviaSouls.add(tickets3); //4
        aviaSouls.add(tickets4); //13

        Ticket[] sort = {tickets, tickets2, tickets3, tickets4};

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] res = aviaSouls.searchAndSortBy("Гонконг", "Москва", ticketTimeComparator );
        System.out.println(res);

        Ticket[] expected = {tickets, tickets4};
        System.out.println(expected);

        Assertions.assertArrayEquals(expected, res);
    }




}