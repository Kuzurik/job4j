package ru.job4j.cinema;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CinemaTest {

    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        Session session3D = new Session3D();
        cinema.add(session3D);
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(session3D)));
    }

    @Test(expected = TicketException.class)
    public void notBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test(expected = SessionException.class)
    public void notFind() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(session -> true);
    }


}
