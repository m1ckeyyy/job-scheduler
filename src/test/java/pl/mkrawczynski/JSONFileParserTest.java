package pl.mkrawczynski;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class JSONFileParserTest {

    @Test
    void doesntThrowExceptions() {
        assertDoesNotThrow(() -> JSONFileParser.getPickersFromFile("src/test/resources/store.json"));
        assertDoesNotThrow(() -> JSONFileParser.getOrdersFromFile("src/test/resources/orders.json"));
    }

    @Test
    void readsFilesCorrectly() throws IOException, ParseException {
        List<Order> orders = JSONFileParser.getOrdersFromFile("src/test/resources/orders.json");
        List<Picker> pickers = JSONFileParser.getPickersFromFile("src/test/resources/store.json");
        LocalTime[] times = JSONFileParser.getTimesFromFile("src/test/resources/store.json");

        assertEquals(orders.size(), 5);
        assertEquals(orders.get(2).getId(), "order-3");
        assertEquals(orders.get(4).getPickingTime(), Duration.ofMinutes(30));
        assertEquals(pickers.size(),2);
        assertEquals(pickers.get(1).getId(), "P2");
        assertEquals(times[0], LocalTime.of(9,0));
        }
    }


