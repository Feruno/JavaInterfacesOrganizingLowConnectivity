package org.example;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2) {

        int t_1 = t1.getTimeTo() - t1.getTimeFrom();
        int t_2 = t2.getTimeTo() - t2.getTimeFrom();

        if(t_1 < t_2){
            return -1;
        } else if (t_1 > t_2) {
            return 1;
        }else {
            return 0;
        }
    }
}
