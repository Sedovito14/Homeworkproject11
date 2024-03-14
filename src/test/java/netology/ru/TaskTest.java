package netology.ru;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldFindSubtaskInEpic() {
        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSubtaskInEpic() {
        boolean expected = false;
        boolean actual = epic.matches("Шоколад");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAllInEpic() {
        String[] subtasks = {};
        Epic epic = new Epic(55, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("f");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTopicInMeeting() {
        boolean expected = true;
        boolean actual = meeting.matches("Приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindProjectInMeeting() {
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindStartInMeeting() {
        boolean expected = true;
        boolean actual = meeting.matches("Во вторник");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTopicInMeeting() {
        boolean expected = false;
        boolean actual = meeting.matches("Вкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProjectInMeeting() {
        boolean expected = false;
        boolean actual = meeting.matches("Колесо");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindStartInMeeting() {
        boolean expected = false;
        boolean actual = meeting.matches("В понедельник");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTitleInSimpleTask() {
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTitleInSimpleTask() {
        boolean expected = false;
        boolean actual = simpleTask.matches("Завтрак");

        Assertions.assertEquals(expected, actual);
    }
}
