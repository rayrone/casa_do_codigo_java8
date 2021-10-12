package br.com.caelum.java8.capitulo10;

import org.junit.Assert;
import org.junit.Test;

import java.time.*;

import static org.junit.Assert.*;

public class Capitulo10Test {

    @Test
    public void criarLocalDate() {
        LocalDate hoje = LocalDate.now();
        assertNotNull(hoje);
    }

    @Test
    public void criarLocalDateNoMesQueVem() {
        LocalDate mesQueVem = LocalDate.now().plusMonths(1);
        assertEquals(LocalDate.now().getMonth().getValue() + 1, mesQueVem.getMonth().getValue());
    }

    @Test
    public void criarLocalDateNoMesQuePassado() {
        LocalDate mesQuePassado = LocalDate.now().minusMonths(1);
        assertEquals(LocalDate.now().getMonth().getValue() - 1, mesQuePassado.getMonth().getValue());
    }

    @Test
    public void criarLocalTime() {
        LocalTime agora = LocalTime.now();
        assertNotNull(agora);
    }

    @Test
    public void criarLocalDateTime() {
        LocalDateTime agora = LocalDateTime.now();
        assertNotNull(agora);
    }

    @Test
    public void criarLocalDateTimeComHorarioEspecifico() {
        LocalDateTime hojeAoMeioDia = LocalDate.MAX.atTime(12, 0);
        assertNotNull(hojeAoMeioDia);
    }

    @Test
    public void criarLocalDateTimeComoCombinacaoLocalDateELocalTime() {
        LocalTime agora = LocalTime.now();
        LocalDate hoje = LocalDate.now();
        LocalDateTime dataEHora = hoje.atTime(agora);
        assertNotNull(dataEHora);
    }

    @Test
    public void criarZonedDateTimeComFusoHorarioDeSaoPaulo() {
        ZonedDateTime dataComHoraETimezone = LocalDateTime.now().atZone(ZoneId.of("America/Sao_Paulo"));
        assertNotNull(dataComHoraETimezone);

        LocalDateTime semTimeZone = dataComHoraETimezone.toLocalDateTime();
        assertNotNull(semTimeZone);

        LocalDate localDate = dataComHoraETimezone.toLocalDate();
        assertNotNull(localDate);

        LocalTime localTime = dataComHoraETimezone.toLocalTime();
        assertNotNull(localTime);
    }

    @Test
    public void criarDataComFactoryMethodOf() {
        LocalDate date = LocalDate.of(1987, 7, 22);
        assertNotNull(date);

        LocalDateTime dateTime = LocalDateTime.of(1987,7, 22, 19, 57);
        assertNotNull(dateTime);
    }

    @Test
    public void criarDataAtravesDoMetodoWith() {
        LocalDate dataDoPassado = LocalDate.now().withYear(1987);
        assertNotNull(dataDoPassado);
    }

    @Test
    public void compararDataComIsBefore() {
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = LocalDate.now().plusDays(1);
        assertTrue(hoje.isBefore(amanha));
    }

    @Test
    public void compararDataComIsAfter() {
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = LocalDate.now().plusDays(1);
        assertFalse(hoje.isAfter(amanha));
    }

    @Test
    public void compararDataComIsEquals() {
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = LocalDate.now().plusDays(1);
        assertFalse(hoje.isEqual(amanha));
    }

}
